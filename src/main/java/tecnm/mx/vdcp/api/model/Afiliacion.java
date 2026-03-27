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
 * Organización gremial, sindical o agrupación comercial a la que pueden estar afiliados los puntos de venta.
 */

@Schema(name = "Afiliacion", description = "Organización gremial, sindical o agrupación comercial a la que pueden estar afiliados los puntos de venta.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-27T19:44:58.488998954Z[Etc/UTC]", comments = "Generator version: 7.5.0")
public class Afiliacion implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String nombre;

  public Afiliacion() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Afiliacion(Integer id, String nombre) {
    this.id = id;
    this.nombre = nombre;
  }

  public Afiliacion id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador único de la afiliación.
   * @return id
  */
  @NotNull 
  @Schema(name = "id", example = "1", description = "Identificador único de la afiliación.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Afiliacion nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Nombre completo de la organización o agrupación.
   * @return nombre
  */
  @NotNull @Size(min = 1, max = 100) 
  @Schema(name = "nombre", example = "FUCQ", description = "Nombre completo de la organización o agrupación.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nombre")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Afiliacion afiliacion = (Afiliacion) o;
    return Objects.equals(this.id, afiliacion.id) &&
        Objects.equals(this.nombre, afiliacion.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Afiliacion {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
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

