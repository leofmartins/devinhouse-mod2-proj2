package com.labmedicine.labmedical.repositories;

import com.labmedicine.labmedical.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ConsultaRepository extends
    JpaRepository<Consulta, Long> {
}
