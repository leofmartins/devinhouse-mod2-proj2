package com.labmedicine.labmedical.model.enums;

public enum TipoEspecializacao {
  CLINICO_GERAL("clínico geral"),
  ANESTESISTA("anestesista"),
  DERMATOLOGISTA("dermatologista"),
  GINECOLOGISTA("ginecologista"),
  NEUROLOGISTA("neurologista"),
  PEDIATRIA("pediatria"),
  PSIQUIATRIA("psiquiatria"),
  ORTOPEDIA("ortopedia");

  private String especializacao;

  TipoEspecializacao(String especializacao) {
    this.especializacao = especializacao;
  }

  public String getEspecializacao() {
    return especializacao;
  }
}
