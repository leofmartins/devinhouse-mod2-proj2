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
public class Exame {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private Long id;

  @NotNull
  @Getter
  @Setter
  private String nomeExame;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  @Getter
  @Setter
  private Date dataHoraExame;

  @NotNull
  @Getter
  @Setter
  private String tipoExame;

  @NotNull
  @Getter
  @Setter
  private String laboratorio;

  @Getter
  @Setter
  private String arquivoExame;

  @NotNull
  @Getter
  @Setter
  private String resultadoExame;

  @ManyToOne
  @JoinColumn(name = "paciente_id", nullable = false)
  @Getter
  @Setter
  private Paciente paciente;

  @ManyToOne
  @JoinColumn(name = "medico_id", nullable = false)
  @Getter
  @Setter
  private Usuario medico;
}
