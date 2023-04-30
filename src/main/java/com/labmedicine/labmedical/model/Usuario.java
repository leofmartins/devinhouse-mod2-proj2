package com.labmedicine.labmedical.model;

import com.labmedicine.labmedical.model.enums.TipoEspecializacao;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends Pessoa {

  @NotNull
  @Getter
  @Setter
  private String cadastroCRM;

  @NotNull
  @Getter
  @Setter
  private TipoEspecializacao especializacao;

  @NotNull
  @Size(min = 8)
  @Getter
  @Setter
  private String senha;
}
