package com.labmedicine.labmedical.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente extends Pessoa{

  private String alergias;

  private String cuidadosEspecificos;

  @NotNull
  private String contatoEmergencia;

  private String convenio;

  private String numeroCarteiraConvenio;

  private Date validadeCarteiraConvenio;

  @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
  private Endereco endereco;

  @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
  private Set<Consulta> consultas;

  @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
  private Set<Exame> exames;
}
