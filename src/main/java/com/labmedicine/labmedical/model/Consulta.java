package com.labmedicine.labmedical.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Accessors
public class Consulta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String motivoConsulta;

  private Date dataHoraConsulta;

  private String descricaoProblema;

  private String medicacaoReceitada;

  private String dosagemPrecaucoes;

  @ManyToOne
  private Paciente paciente;

  @ManyToOne
  private Usuario medico;
}
