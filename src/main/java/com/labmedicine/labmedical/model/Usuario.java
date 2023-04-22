package com.labmedicine.labmedical.model;

import com.labmedicine.labmedical.model.enums.TipoEspecializacao;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Accessors
public class Usuario extends Pessoa {

  @NotNull
  private String cadastroCRM;

  @NotNull
  private TipoEspecializacao especializacao;

  @NotNull
  @Size(min = 8)
  private String senha;
}
