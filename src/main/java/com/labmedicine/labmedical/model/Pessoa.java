package com.labmedicine.labmedical.model;

import com.labmedicine.labmedical.model.enums.TipoEstadoCivil;
import com.labmedicine.labmedical.model.enums.TipoGenero;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private Long id;

  @NotNull
  @Getter
  @Setter
  private String nomeCompleto;

  @NotNull
  @Getter
  @Setter
  private TipoGenero genero;

  @NotNull
  @Getter
  @Setter
  private Date dataNascimento;

  @NotNull
  @Column(unique = true)
  @Getter
  @Setter
  private String cpf;

  @NotNull
  @Getter
  @Setter
  private String rg;

  @NotNull
  @Getter
  @Setter
  private TipoEstadoCivil estadoCivil;

  @NotNull
  @Getter
  @Setter
  private String telefone;

  @NotNull
  @Getter
  @Setter
  private String email;

  @NotNull
  @Getter
  @Setter
  private String naturalidade;
}
