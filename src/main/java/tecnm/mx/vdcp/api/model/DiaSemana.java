package tecnm.mx.vdcp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Día de la semana. Los valores se expresan en minúsculas y sin tildes de forma intencional para garantizar compatibilidad con parámetros de URL, bases de datos sin soporte Unicode completo y clientes legacy. Convención establecida: no modificar a formas acentuadas (miércoles, sábado) sin coordinar una migración versionada de la API. 
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-27T19:44:58.488998954Z[Etc/UTC]", comments = "Generator version: 7.5.0")
public enum DiaSemana {
  
  LUNES("lunes"),
  
  MARTES("martes"),
  
  MIERCOLES("miercoles"),
  
  JUEVES("jueves"),
  
  VIERNES("viernes"),
  
  SABADO("sabado"),
  
  DOMINGO("domingo");

  private String value;

  DiaSemana(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static DiaSemana fromValue(String value) {
    for (DiaSemana b : DiaSemana.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

