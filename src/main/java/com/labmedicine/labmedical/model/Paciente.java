package com.labmedicine.labmedical.model;

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

  @OneToOne(mappedBy = "paciente",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.REMOVE})
  private Endereco endereco;

  @OneToMany(mappedBy = "paciente",
            cascade = {CascadeType.REMOVE})
  private Set<Consulta> consultas = new HashSet<>();

  @OneToMany(mappedBy = "paciente",
            cascade = {CascadeType.REMOVE})
  private Set<Exame> exames = new HashSet<>();
}
