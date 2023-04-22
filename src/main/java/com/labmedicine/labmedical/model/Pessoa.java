package com.labmedicine.labmedical.model;

import com.labmedicine.labmedical.model.enums.TipoEstadoCivil;
import com.labmedicine.labmedical.model.enums.TipoGenero;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@MappedSuperclass
public class Pessoa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String nomeCompleto;

  @NotNull
  @Enumerated(EnumType.ORDINAL)
  private TipoGenero genero;

  @NotNull
  private Date dataNascimento;

  @NotNull
  @Column(unique = true)
  private String cpf;

  @NotNull
  private String rg;

  @NotNull
  private TipoEstadoCivil estadoCivil;

  @NotNull
  private String telefone;

  @NotNull
  private String email;

  @NotNull
  private String naturalidade;
}
