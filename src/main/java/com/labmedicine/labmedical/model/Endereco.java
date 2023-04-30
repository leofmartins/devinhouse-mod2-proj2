package com.labmedicine.labmedical.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors
public class Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private Long id;

  @NotNull
  @Getter
  @Setter
  private String cep;

  @NotNull
  @Getter
  @Setter
  private String cidade;

  @NotNull
  @Getter
  @Setter
  private String estado;

  @NotNull
  @Getter
  @Setter
  private String logradouro;

  @NotNull
  @Getter
  @Setter
  private Integer numero;

  @Getter
  @Setter
  private String complemento;

  @NotNull
  @Getter
  @Setter
  private String bairro;

  @Getter
  @Setter
  private String pontoReferencia;

  @OneToOne(mappedBy = "endereco")
  @JsonIgnore
  @Getter
  @Setter
  private Paciente paciente;
}
