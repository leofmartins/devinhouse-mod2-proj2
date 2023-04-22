package com.labmedicine.labmedical.model.enums;

public enum TipoEstadoCivil {
  SOLTEIRO("solteiro"),
  CASADO("casado"),
  SEPARADO("separado"),
  DIVORCIADO("divorciado"),
  VIUVO("viúvo");

  private String estadoCivil;

  TipoEstadoCivil(String estadoCivil) {
    this.estadoCivil = estadoCivil;
  }

  public String getEstadoCivil() {
    return estadoCivil;
  }
}
