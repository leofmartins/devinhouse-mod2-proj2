package com.labmedicine.labmedical.repositories;

import com.labmedicine.labmedical.model.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExameRepository extends
    PagingAndSortingRepository<Exame, Long>,
    CrudRepository<Exame, Long>,
    JpaRepository<Exame, Long> {
}
