package com.labmedicine.labmedical.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
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

  @OneToOne(cascade = {CascadeType.REMOVE})
  @JoinColumn(name = "endereco_id")
  private Endereco endereco;

  @OneToMany(mappedBy = "paciente",
            cascade = {CascadeType.REMOVE})
  @JsonIgnore
  private Set<Consulta> consultas = new HashSet<>();

  @OneToMany(mappedBy = "paciente",
            cascade = {CascadeType.REMOVE})
  @JsonIgnore
  private Set<Exame> exames = new HashSet<>();
}
