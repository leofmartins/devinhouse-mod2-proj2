package com.labmedicine.labmedical.repositories;

import com.labmedicine.labmedical.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UsuarioRepository extends
    PagingAndSortingRepository<Usuario, Long>,
    CrudRepository<Usuario, Long>,
    JpaRepository<Usuario, Long> {
  List<Usuario> findByCpf(String cpf);
}
