package com.labmedicine.labmedical.model.converters;

import com.labmedicine.labmedical.model.enums.TipoEspecializacao;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class EspecializacaoConverter implements AttributeConverter<TipoEspecializacao, String> {
  @Override
  public String convertToDatabaseColumn(TipoEspecializacao tipoEspecializacao) {
    if (tipoEspecializacao.getEspecializacao() == null)
      return null;
    return tipoEspecializacao.getEspecializacao();
  }

  @Override
  public TipoEspecializacao convertToEntityAttribute(String especializacao) {
    if (especializacao == null)
      return null;
    return Stream.of(TipoEspecializacao.values())
        .filter(e -> e.getEspecializacao().equals(especializacao))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
