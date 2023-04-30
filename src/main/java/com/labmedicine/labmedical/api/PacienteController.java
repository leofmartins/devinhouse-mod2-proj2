package com.labmedicine.labmedical.api;

import com.labmedicine.labmedical.model.Paciente;
import com.labmedicine.labmedical.repositories.ConsultaRepository;
import com.labmedicine.labmedical.repositories.EnderecoRepository;
import com.labmedicine.labmedical.repositories.ExameRepository;
import com.labmedicine.labmedical.repositories.PacienteRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/pacientes", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
@AllArgsConstructor
public class PacienteController {

  private PacienteRepository pacienteRepository;
  private EnderecoRepository enderecoRepository;
  private ConsultaRepository consultaRepository;
  private ExameRepository exameRepository;

  @PostMapping(consumes = "application/json")
  public ResponseEntity<?> postPaciente(@RequestBody @Valid Paciente paciente) {
    Long enderecoId = paciente.getEndereco().getId();
    if (enderecoRepository.findById(enderecoId).isEmpty())
      return new ResponseEntity<>("ERRO: Id informado não corresponde a nenhum endereço cadastrado." +
              " Verifique e tente novamente.", HttpStatus.BAD_REQUEST);
    try {
      if (pacienteRepository.findByCpf(paciente.getCpf()).isEmpty()) {
        Paciente pacienteCadastrado = pacienteRepository.save(paciente);
        return new ResponseEntity<>(pacienteCadastrado, HttpStatus.CREATED);
      }
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping(path = "/{id}", consumes = "application/json")
  public ResponseEntity<?> putPaciente(@PathVariable Long id,
                                              @RequestBody @Valid Paciente pacienteDadosAtualizado) {
    if (pacienteRepository.findById(id).isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    Paciente pacienteAtualizar = pacienteRepository.findById(id).orElseThrow();
    List<String> campoManter = Arrays.asList("id", "rg", "cpf", "endereco", "consultas", "exames");
    BeanUtils.copyProperties(pacienteDadosAtualizado,
        pacienteAtualizar,
        campoManter.toArray(new String[0]));
    try {
      Paciente pacienteAtualizado = pacienteRepository.save(pacienteAtualizar);
      return new ResponseEntity<>(pacienteAtualizado, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Iterable<Paciente> geAlltPacientes(@RequestParam(required = false) String nome) {
    if (nome != null)
      return pacienteRepository.findByNomeCompletoContains(nome);
    return pacienteRepository.findAll();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
    if (pacienteRepository.findById(id).isEmpty())
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    Paciente paciente = pacienteRepository.findById(id).orElseThrow();
    return new ResponseEntity<>(paciente, HttpStatus.OK);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<?> deletePaciente(@PathVariable Long id) {
    if (pacienteRepository.findById(id).isEmpty())
      return new ResponseEntity<>("ERRO: Paciente não encontrado.", HttpStatus.NOT_FOUND);
    Paciente pacienteDeletar = pacienteRepository.findById(id).orElseThrow(RuntimeException::new);
    boolean temConsulta = !pacienteDeletar.getConsultas().isEmpty();
    boolean temExame = !pacienteDeletar.getExames().isEmpty();
    if (!temConsulta && !temExame) {
      pacienteRepository.delete(pacienteDeletar);
      return new ResponseEntity<>("Paciente excluído com sucesso.", HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>("ERRO: Paciente possui exame ou consulta. " +
            "Não pode ser excluído.", HttpStatus.BAD_REQUEST);
  }
}
