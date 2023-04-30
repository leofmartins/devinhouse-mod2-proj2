package com.labmedicine.labmedical.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Paciente extends Pessoa{

  @Getter
  @Setter
  private String alergias;

  @Getter
  @Setter
  private String cuidadosEspecificos;

  @NotNull
  @Getter
  @Setter
  private String contatoEmergencia;

  @Getter
  @Setter
  private String convenio;

  @Getter
  @Setter
  private String numeroCarteiraConvenio;

  @Getter
  @Setter
  private Date validadeCarteiraConvenio;

  @OneToOne(cascade = {CascadeType.REMOVE})
  @JoinColumn(name = "endereco_id")
  @Getter
  @Setter
  private Endereco endereco;

  @OneToMany(mappedBy = "paciente",
            fetch = FetchType.LAZY)
  @JsonIgnore
  @Getter
  @Setter
  private Set<Consulta> consultas = new HashSet<>();

  @OneToMany(mappedBy = "paciente",
            fetch = FetchType.LAZY)
  @JsonIgnore
  @Getter
  @Setter
  private Set<Exame> exames = new HashSet<>();
}
