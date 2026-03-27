package tecnm.mx.vdcp.api.model;

import java.net.URI;
import java.util.Objects;

import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Delegación territorial del municipio de Querétaro donde se ubica el punto de venta.
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-27T19:44:58.488998954Z[Etc/UTC]", comments = "Generator version: 7.5.0")
public enum Delegacion {
  
  FELIPE_CARRILLO_PUERTO("Felipe Carrillo Puerto"),
  
  FELIX_OSORES_SOTOMAYOR("Felix Osores Sotomayor"),
  
  JOSEFA_VERGARA_Y_HERNANDEZ("Josefa Vergara y Hernandez"),
  
  VILLA_CAYETANO_RUBIO("Villa Cayetano Rubio"),
  
  EPIGMENIO_GONZALES("Epigmenio Gonzales"),
  
  SANTA_ROSA_JAUREGUI("Santa Rosa Jauregui"),
  
  CENTRO_HISTORICO("Centro Historico");

  private String value;

  Delegacion(String value) {
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
  public static Delegacion fromValue(String value) {
    for (Delegacion b : Delegacion.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

