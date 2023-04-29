package com.labmedicine.labmedical.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors
public class Consulta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String motivoConsulta;

  @NotNull
  private Date dataHoraConsulta;

  @NotNull
  private String descricaoProblema;

  @NotNull
  private String medicacaoReceitada;

  @NotNull
  private String dosagemPrecaucoes;

  @ManyToOne
  @JoinColumn(name = "paciente_id", nullable = false)
  private Paciente paciente;

  @ManyToOne
  @JoinColumn(name = "medico_id", nullable = false)
  private Usuario medico;
}
