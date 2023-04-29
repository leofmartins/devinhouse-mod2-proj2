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
public class Exame {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String nomeExame;

  @NotNull
  private Date dataHoraExame;

  @NotNull
  private String tipoExame;

  @NotNull
  private String laboratorio;

  private String arquivoExame;

  @NotNull
  private String resultadoExame;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "paciente_id", nullable = false)
  private Paciente paciente;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "medico_id", nullable = false)
  private Usuario medico;
}
