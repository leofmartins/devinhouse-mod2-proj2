package com.labmedicine.labmedical.model;

import com.labmedicine.labmedical.model.enums.TipoEstadoCivil;
import com.labmedicine.labmedical.model.enums.TipoGenero;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String nomeCompleto;

  @NotNull
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
