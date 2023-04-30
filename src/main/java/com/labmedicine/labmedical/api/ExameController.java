package com.labmedicine.labmedical.api;

import com.labmedicine.labmedical.model.Exame;
import com.labmedicine.labmedical.repositories.ExameRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/exames", produces = "application/json")
@CrossOrigin("http://localhost:8080")
@AllArgsConstructor
public class ExameController {

  private ExameRepository exameRepository;

  @PostMapping(consumes = "application/json")
  public ResponseEntity<?> postExame(@RequestBody @Valid Exame exame) {
    exame.setDataHoraExame(new Date());
    try {
      Exame exameSalvo = exameRepository.save(exame);
      return new ResponseEntity<>(exameSalvo, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping(path = "/{id}", consumes = "application/json")
  public ResponseEntity<?> putExame(@PathVariable Long id, @RequestBody @Valid Exame exameNovosDados) {
    if (exameRepository.findById(id).isEmpty())
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    Exame exameEmAtualizacao = exameRepository.findById(id).orElseThrow(RuntimeException::new);
    List<String> camposManter = Arrays.asList("id", "dataHoraExame");
    BeanUtils.copyProperties(
        exameNovosDados,
        exameEmAtualizacao,
        camposManter.toArray(new String[0])
    );
    try {
      Exame exameAtualizado = exameRepository.save(exameEmAtualizacao);
      return new ResponseEntity<>(exameAtualizado, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<?> getExame(@PathVariable Long id) {
    if (exameRepository.findById(id).isEmpty())
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    Exame examePesquisado = exameRepository.findById(id).orElseThrow(RuntimeException::new);
    return new ResponseEntity<>(examePesquisado, HttpStatus.OK);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<?> deleteExame(@PathVariable Long id) {
    if (exameRepository.findById(id).isEmpty())
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    exameRepository.delete(exameRepository.findById(id).orElseThrow(RuntimeException::new));
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
