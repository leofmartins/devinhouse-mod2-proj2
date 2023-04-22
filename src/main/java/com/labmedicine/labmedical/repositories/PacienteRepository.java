package com.labmedicine.labmedical.repositories;

import com.labmedicine.labmedical.model.Pessoa;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PacienteRepository extends PagingAndSortingRepository<Pessoa, Long> {
}
