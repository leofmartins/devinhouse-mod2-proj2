package com.labmedicine.labmedical.api;

import com.labmedicine.labmedical.model.Paciente;
import com.labmedicine.labmedical.repositories.PacienteRepository;
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

  @PostMapping(consumes = "application/json")
  public ResponseEntity<Paciente> postPaciente(@RequestBody Paciente paciente) {
    try {
      if (pacienteRepository.findByCpf(paciente.getCpf()).isEmpty()) {
        pacienteRepository.save(paciente);
        return new ResponseEntity<>(paciente, HttpStatus.CREATED);
      }
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping(path = "/{id}", consumes = "application/json")
  public ResponseEntity<Paciente> putPaciente(@PathVariable Long id,
                                              @RequestBody Paciente pacienteAtualizado) {
    if (pacienteRepository.findById(id).isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    Paciente pacienteAtualizar = pacienteRepository.findById(id).orElseThrow();
    List<String> campoManter = Arrays.asList("id", "rg", "cpf", "endereco", "consultas", "exames");
    BeanUtils.copyProperties(pacienteAtualizado,
        pacienteAtualizar,
        campoManter.toArray(new String[0]));
    try {
      pacienteRepository.save(pacienteAtualizar);
      return new ResponseEntity<>(pacienteAtualizar, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
    Paciente _paciente = pacienteRepository.findById(id).orElseThrow();
    return new ResponseEntity<>(_paciente, HttpStatus.OK);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Paciente> deletePaciente(@PathVariable Long id) {
    if (pacienteRepository.findById(id).isEmpty())
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    Paciente paciente = pacienteRepository.findById(id).orElseThrow(RuntimeException::new);
    if (paciente.getConsultas().isEmpty() && paciente.getExames().isEmpty()) {
      pacienteRepository.delete(paciente);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
}