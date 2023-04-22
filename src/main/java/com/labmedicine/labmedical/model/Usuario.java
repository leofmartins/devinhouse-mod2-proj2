package com.labmedicine.labmedical.model;

import com.labmedicine.labmedical.model.enums.TipoEspecializacao;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Accessors
public class Usuario extends Pessoa {
  private String cadastroCRM;
  private TipoEspecializacao especializacao;
  private String senha;
}
