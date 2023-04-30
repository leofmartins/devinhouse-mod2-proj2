package com.labmedicine.labmedical.repositories;

import com.labmedicine.labmedical.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
