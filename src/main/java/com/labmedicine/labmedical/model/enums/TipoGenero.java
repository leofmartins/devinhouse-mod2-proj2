package com.labmedicine.labmedical.model.enums;

public enum TipoGenero {
  MASCULINO("masculino"),
  FEMININO("feminino"),
  PREFIRO_NAO_DIZER("prefiro não dizer"),
  OUTRO("outro");

  private String genero;

  TipoGenero(String genero) {
    this.genero = genero;
  }

  public String getGenero() {
    return genero;
  }
}
