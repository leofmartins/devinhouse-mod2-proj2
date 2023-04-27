package com.labmedicine.labmedical.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@Data
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

  @OneToOne
  @JoinColumn(name = "paciente_id")
  private Paciente paciente;
}
