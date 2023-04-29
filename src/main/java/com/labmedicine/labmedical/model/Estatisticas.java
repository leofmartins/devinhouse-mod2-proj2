package com.labmedicine.labmedical.model;

import lombok.Data;
import lombok.NoArgsConstructor;

public class Estatisticas {
  private int pacientes = 0;
  private int consultas = 0;
  private int exames = 0;

  public Estatisticas() {}

  public int getPacientes() {
    return pacientes;
  }

  public void setPacientes(int pacientes) {
    this.pacientes = pacientes;
  }

  public int getConsultas() {
    return consultas;
  }

  public void setConsultas(int consultas) {
    this.consultas = consultas;
  }

  public int getExames() {
    return exames;
  }

  public void setExames(int exames) {
    this.exames = exames;
  }
}
