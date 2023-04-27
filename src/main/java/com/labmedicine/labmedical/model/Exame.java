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

  @ManyToOne
  @JoinColumn(name = "paciente_id")
  private Paciente paciente;

  @ManyToOne
  @JoinColumn(name = "medico_id")
  private Usuario medico;
}
