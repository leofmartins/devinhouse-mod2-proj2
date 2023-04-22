package com.labmedicine.labmedical.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors
public class Paciente extends Pessoa{

  private String alergias;

  private String cuidadosEspecificos;

  @NotNull
  private String contatoEmergencia;

  private String convenio;

  private String numeroCarteiraConvenio;

  private Date validadeCarteiraConvenio;

  @OneToOne
  private Endereco endereco;
}
