package com.labmedicine.labmedical.repositories;

import com.labmedicine.labmedical.model.Pessoa;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<Pessoa, Long> {
}
