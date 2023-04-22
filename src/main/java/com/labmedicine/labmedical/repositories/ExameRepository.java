package com.labmedicine.labmedical.repositories;

import com.labmedicine.labmedical.model.Exame;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExameRepository extends PagingAndSortingRepository<Exame, Long> {
}
