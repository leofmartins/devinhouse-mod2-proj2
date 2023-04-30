package com.labmedicine.labmedical.api;

import com.labmedicine.labmedical.model.Consulta;
import com.labmedicine.labmedical.repositories.ConsultaRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api/consultas", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
@AllArgsConstructor
public class ConsultaController {

  private ConsultaRepository consultaRepository;

  @PostMapping(consumes = "application/json")
  public ResponseEntity<?> postConsulta(@RequestBody @Valid Consulta consulta) {
    try {
      Consulta consultaSalva = consultaRepository.save(consulta);
      return new ResponseEntity<>(consultaSalva, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping(path = "/{id}", consumes = "application/json")
  public ResponseEntity<?> putConsulta(@RequestBody @Valid Consulta consultaRecebida,
                                              @PathVariable("id") Long id) {
    if (consultaRepository.findById(id).isEmpty())
      return new ResponseEntity<>("ERRO: Id de consulta não encontrado.", HttpStatus.NOT_FOUND);
    List<String> camposManter = Arrays.asList("id", "dataHoraConsulta");
    Consulta consultaAtualizar = consultaRepository.findById(id).orElseThrow();
    BeanUtils.copyProperties(
        consultaRecebida,
        consultaAtualizar,
        camposManter.toArray(new String[0])
    );
    try {
      Consulta consultaAtualizada = consultaRepository.save(consultaAtualizar);
      return new ResponseEntity<>(consultaAtualizada, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("ERRO: Verifique os dados e tente novamente.",
              HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Consulta> getConsultaPeloId(@PathVariable Long id) {
    if (consultaRepository.findById(id).isEmpty())
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    Consulta consulta = consultaRepository.findById(id).orElseThrow();
    return new ResponseEntity<>(consulta, HttpStatus.OK);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> deleteConsulta(@PathVariable("id") Long id) {
    if (consultaRepository.findById(id).isEmpty())
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    Consulta consultaDeletar = consultaRepository.findById(id).orElseThrow();
    consultaRepository.delete(consultaDeletar);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
