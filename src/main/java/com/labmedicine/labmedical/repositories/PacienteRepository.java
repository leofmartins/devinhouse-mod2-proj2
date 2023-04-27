package com.labmedicine.labmedical.repositories;

import com.labmedicine.labmedical.model.Paciente;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PacienteRepository extends
    PagingAndSortingRepository<Paciente, Long>,
    CrudRepository<Paciente, Long> {
  List<Paciente> findByNomeCompletoContains(String nomeCompleto);
  List<Paciente> findByCpf(String cpf);
}
