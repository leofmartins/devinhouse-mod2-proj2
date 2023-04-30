package com.labmedicine.labmedical.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private Long id;

  @NotNull
  @Getter
  @Setter
  private String motivoConsulta;

  @NotNull
  @Getter
  @Setter
  private Date dataHoraConsulta;

  @NotNull
  @Getter
  @Setter
  private String descricaoProblema;

  @NotNull
  @Getter
  @Setter
  private String medicacaoReceitada;

  @NotNull
  @Getter
  @Setter
  private String dosagemPrecaucoes;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "paciente_id", nullable = false)
  @Getter
  @Setter
  private Paciente paciente;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "medico_id", nullable = false)
  @Getter
  @Setter
  private Usuario medico;
}
