package com.labmedicine.labmedical.model;

import com.labmedicine.labmedical.model.enums.TipoEstadoCivil;
import com.labmedicine.labmedical.model.enums.TipoGenero;
import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public class Pessoa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nomeCompleto;
  private TipoGenero genero;
  private Date dataNascimento;
  private String cpf;
  private String rg;
  private TipoEstadoCivil estadoCivil;
  private String telefone;
  private String email;
  private String naturalidade;
}
