package com.labmedicine.labmedical.api;

import com.labmedicine.labmedical.model.Endereco;
import com.labmedicine.labmedical.repositories.EnderecoRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/enderecos", produces = "application/json")
@AllArgsConstructor
public class EnderecoControlller {

  private EnderecoRepository enderecoRepository;

  @PostMapping(consumes = "application/json")
  public ResponseEntity<?> postEndereco(@RequestBody @Valid Endereco endereco) {
    try {
      Endereco endrecoCadastrado = enderecoRepository.save(endereco);
      return new ResponseEntity<>(endrecoCadastrado, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping
  public ResponseEntity<?> getEnderecos() {
    List<Endereco> enderecos = enderecoRepository.findAll();
    return new ResponseEntity<>(enderecos, HttpStatus.OK);
  }
}
