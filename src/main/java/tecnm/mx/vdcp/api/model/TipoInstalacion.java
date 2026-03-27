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
 * Clasificación física del punto de venta: tianguis: mercado informal itinerante al aire libre. corredor: conjunto de puestos alineados en vía pública. mercado: instalación fija techada con puestos individuales. otro: cualquier modalidad no clasificada en las anteriores. 
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-27T19:44:58.488998954Z[Etc/UTC]", comments = "Generator version: 7.5.0")
public enum TipoInstalacion {
  
  TIANGUIS("tianguis"),
  
  CORREDOR("corredor"),
  
  MERCADO("mercado"),
  
  OTRO("otro");

  private String value;

  TipoInstalacion(String value) {
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
  public static TipoInstalacion fromValue(String value) {
    for (TipoInstalacion b : TipoInstalacion.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

