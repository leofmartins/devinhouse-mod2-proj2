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
public class Exame {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nomeExame;

  private Date dataHoraExame;

  private String tipoExame;

  private String laboratorio;

  private String arquivoExame;

  private String resultadoExame;

  @ManyToOne
  private Paciente paciente;

  @ManyToOne
  private Usuario medico;
}
