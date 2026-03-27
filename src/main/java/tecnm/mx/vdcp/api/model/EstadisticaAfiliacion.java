package tecnm.mx.vdcp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Agregado estadístico del número de puntos de venta registrados bajo una afiliación específica.
 */

@Schema(name = "EstadisticaAfiliacion", description = "Agregado estadístico del número de puntos de venta registrados bajo una afiliación específica.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-27T19:44:58.488998954Z[Etc/UTC]", comments = "Generator version: 7.5.0")
public class EstadisticaAfiliacion implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer afiliacionId;

  private String afiliacionNombre;

  private Integer totalPuntosVenta;

  public EstadisticaAfiliacion() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EstadisticaAfiliacion(Integer afiliacionId, String afiliacionNombre, Integer totalPuntosVenta) {
    this.afiliacionId = afiliacionId;
    this.afiliacionNombre = afiliacionNombre;
    this.totalPuntosVenta = totalPuntosVenta;
  }

  public EstadisticaAfiliacion afiliacionId(Integer afiliacionId) {
    this.afiliacionId = afiliacionId;
    return this;
  }

  /**
   * Identificador de la afiliación.
   * @return afiliacionId
  */
  @NotNull 
  @Schema(name = "afiliacion_id", example = "1", description = "Identificador de la afiliación.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("afiliacion_id")
  public Integer getAfiliacionId() {
    return afiliacionId;
  }

  public void setAfiliacionId(Integer afiliacionId) {
    this.afiliacionId = afiliacionId;
  }

  public EstadisticaAfiliacion afiliacionNombre(String afiliacionNombre) {
    this.afiliacionNombre = afiliacionNombre;
    return this;
  }

  /**
   * Nombre de la afiliación para presentación en gráficas o reportes.
   * @return afiliacionNombre
  */
  @NotNull 
  @Schema(name = "afiliacion_nombre", example = "FUCQ", description = "Nombre de la afiliación para presentación en gráficas o reportes.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("afiliacion_nombre")
  public String getAfiliacionNombre() {
    return afiliacionNombre;
  }

  public void setAfiliacionNombre(String afiliacionNombre) {
    this.afiliacionNombre = afiliacionNombre;
  }

  public EstadisticaAfiliacion totalPuntosVenta(Integer totalPuntosVenta) {
    this.totalPuntosVenta = totalPuntosVenta;
    return this;
  }

  /**
   * Número total de puntos de venta registrados bajo esta afiliación.
   * @return totalPuntosVenta
  */
  @NotNull 
  @Schema(name = "total_puntos_venta", example = "42", description = "Número total de puntos de venta registrados bajo esta afiliación.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("total_puntos_venta")
  public Integer getTotalPuntosVenta() {
    return totalPuntosVenta;
  }

  public void setTotalPuntosVenta(Integer totalPuntosVenta) {
    this.totalPuntosVenta = totalPuntosVenta;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EstadisticaAfiliacion estadisticaAfiliacion = (EstadisticaAfiliacion) o;
    return Objects.equals(this.afiliacionId, estadisticaAfiliacion.afiliacionId) &&
        Objects.equals(this.afiliacionNombre, estadisticaAfiliacion.afiliacionNombre) &&
        Objects.equals(this.totalPuntosVenta, estadisticaAfiliacion.totalPuntosVenta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(afiliacionId, afiliacionNombre, totalPuntosVenta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EstadisticaAfiliacion {\n");
    sb.append("    afiliacionId: ").append(toIndentedString(afiliacionId)).append("\n");
    sb.append("    afiliacionNombre: ").append(toIndentedString(afiliacionNombre)).append("\n");
    sb.append("    totalPuntosVenta: ").append(toIndentedString(totalPuntosVenta)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

