package com.labmedicine.labmedical.api;

import com.labmedicine.labmedical.model.Usuario;
import com.labmedicine.labmedical.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api/usuarios", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
@AllArgsConstructor
public class UsuarioController {

  private UsuarioRepository usuarioRepository;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Iterable<Usuario> getUsuarios() {
    return usuarioRepository.findAll();
  }

  @PostMapping(consumes = "application/json")
  public ResponseEntity<?> postUsuario(@RequestBody @Valid Usuario usuario) {
    try {
      if (usuarioRepository.findByCpf(usuario.getCpf()).isEmpty()) {
        Usuario usuarioCadastrado = usuarioRepository.save(usuario);
        return new ResponseEntity<>(usuarioCadastrado, HttpStatus.CREATED);
      }
      return new ResponseEntity<>("ERRO: Já existe um usuário com o CPF informado.",
              HttpStatus.CONFLICT);
    } catch (Exception e) {
      return new ResponseEntity<>("ERRO: Dados inválidos. Verifique e tente novamente.",
              HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping(path = "/{id}", consumes = "application/json")
  public ResponseEntity<?> putUsuario(@PathVariable Long id,
                                            @RequestBody @Valid Usuario usuarioAtualizado) {
    if (usuarioRepository.findById(id).isEmpty()) {
      return new ResponseEntity<>("ERRO: Id de usuário não encontrado", HttpStatus.NOT_FOUND);
    }
    Usuario usuarioAtualizar = usuarioRepository.findById(id).orElseThrow();
    List<String> campoManter = Arrays.asList("id", "cpf", "rg", "senha");
    BeanUtils.copyProperties(usuarioAtualizado,
        usuarioAtualizar,
        campoManter.toArray(new String[0]));
    try {
      usuarioRepository.save(usuarioAtualizar);
      return new ResponseEntity<>(usuarioAtualizar, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("ERRO: Dados inválidos. Verifique e tente novamente.",
              HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping(path = "/{id}/senha", consumes = "application/json")
  public ResponseEntity<?> putSenha(@PathVariable Long id,
                                          @RequestBody @Valid Usuario pacienteDadosAtualizados) {
    if (pacienteDadosAtualizados.getSenha().length() < 8) {
      return new ResponseEntity<>("ERRO: A senha deve ter pelo menos 8 caracteres.",
              HttpStatus.BAD_REQUEST);
    }

    if (usuarioRepository.findById(id).isEmpty()) {
      return  new ResponseEntity<>("ERRO: Id de usuário não encontrado.", HttpStatus.NOT_FOUND);
    }

    Usuario usuarioAtualizar = usuarioRepository.findById(id).orElseThrow();
    usuarioAtualizar.setSenha(pacienteDadosAtualizados.getSenha());
    Usuario usuarioAtualizado = usuarioRepository.save(usuarioAtualizar);
    return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
  }
}
