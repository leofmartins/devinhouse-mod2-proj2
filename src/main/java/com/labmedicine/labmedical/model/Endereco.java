package com.labmedicine.labmedical.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors
public class Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String cep;

  @NotNull
  private String cidade;

  @NotNull
  private String estado;

  @NotNull
  private String logradouro;

  @NotNull
  private Integer numero;

  private String complemento;

  @NotNull
  private String bairro;

  private String pontoReferencia;
}
