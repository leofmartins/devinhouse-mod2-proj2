package com.labmedicine.labmedical.model.converters;

import com.labmedicine.labmedical.model.enums.TipoGenero;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class GeneroCoverter implements AttributeConverter<TipoGenero, String> {
  @Override
  public String convertToDatabaseColumn(TipoGenero tipoGenero) {
    if (tipoGenero.getGenero() == null)
      return null;
    return tipoGenero.getGenero();
  }

  @Override
  public TipoGenero convertToEntityAttribute(String genero) {
    if (genero == null)
      return null;
    return Stream.of(TipoGenero.values())
        .filter(g -> g.getGenero().equals(genero))
        .findFirst()
        .orElseThrow(IllegalAccessError::new);
  }
}
