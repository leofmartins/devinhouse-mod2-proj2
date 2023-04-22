package com.labmedicine.labmedical.model.converters;

import com.labmedicine.labmedical.model.enums.TipoEstadoCivil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class EstadoCivilConverter implements AttributeConverter<TipoEstadoCivil, String> {
  @Override
  public String convertToDatabaseColumn(TipoEstadoCivil tipoEstadoCivil) {
    if (tipoEstadoCivil.getEstadoCivil() == null)
      return null;
    return tipoEstadoCivil.getEstadoCivil();
  }

  @Override
  public TipoEstadoCivil convertToEntityAttribute(String estadoCivil) {
    if (estadoCivil == null)
      return null;
    return Stream.of(TipoEstadoCivil.values())
        .filter(ec -> ec.getEstadoCivil().equals(estadoCivil))
        .findFirst()
        .orElseThrow(IllegalAccessError::new);
  }
}
