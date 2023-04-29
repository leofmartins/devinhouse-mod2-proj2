package com.labmedicine.labmedical.api;

import com.labmedicine.labmedical.model.Estatisticas;
import com.labmedicine.labmedical.repositories.ConsultaRepository;
import com.labmedicine.labmedical.repositories.ExameRepository;
import com.labmedicine.labmedical.repositories.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/estatisticas", produces = "application/json")
@CrossOrigin("http://localhost:8080")
@AllArgsConstructor
public class EstatisticasController {

  private PacienteRepository pacienteRepository;
  private ConsultaRepository consultaRepository;
  private ExameRepository exameRepository;

  @GetMapping
  @ResponseBody
  public ResponseEntity<Estatisticas> getEstatisticas() {
    Estatisticas estatisticas = new Estatisticas();
    int pacientes = pacienteRepository.findAll().size();
    int consultas = consultaRepository.findAll().size();
    int exames = exameRepository.findAll().size();

    estatisticas.setPacientes(pacientes);
    estatisticas.setConsultas(consultas);
    estatisticas.setExames(exames);

    return new ResponseEntity<>(estatisticas, HttpStatus.OK);
  }
}
