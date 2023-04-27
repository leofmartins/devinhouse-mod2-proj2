package com.labmedicine.labmedical.api;

import com.labmedicine.labmedical.model.Usuario;
import com.labmedicine.labmedical.repositories.UsuarioRepository;
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
  public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario) {
    try {
      if (usuarioRepository.findByCpf(usuario.getCpf()).isEmpty()) {
        Usuario _usuario = usuarioRepository.save(usuario);
        return new ResponseEntity<>(_usuario, HttpStatus.CREATED);
      }
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping(path = "/{id}", consumes = "application/json")
  public ResponseEntity<Usuario> putUsuario(@PathVariable Long id,
                                            @RequestBody Usuario usuarioAtualizado) {
    if (usuarioRepository.findById(id).isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping(path = "/{id}/senha", consumes = "application/json")
  public ResponseEntity<Usuario> putSenha(@PathVariable Long id,
                                          @RequestBody Usuario usuarioAtualizado) {
    if (usuarioAtualizado.getSenha().length() < 8) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    if (usuarioRepository.findById(id).isEmpty()) {
      return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    Usuario usuarioAtualizar = usuarioRepository.findById(id).orElseThrow();
    usuarioAtualizar.setSenha(usuarioAtualizado.getSenha());
    usuarioRepository.save(usuarioAtualizar);
    return new ResponseEntity<>(usuarioAtualizar, HttpStatus.OK);
  }
}