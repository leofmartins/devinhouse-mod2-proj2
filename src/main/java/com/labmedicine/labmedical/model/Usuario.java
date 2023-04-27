package com.labmedicine.labmedical.model;

import com.labmedicine.labmedical.model.enums.TipoEspecializacao;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends Pessoa {

  @NotNull
  private String cadastroCRM;

  @NotNull
  private TipoEspecializacao especializacao;

  @NotNull
  @Size(min = 8)
  private String senha;
}
