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
 * Colonia o fraccionamiento del municipio de Querétaro donde puede ubicarse un punto de venta.
 */

@Schema(name = "Colonia", description = "Colonia o fraccionamiento del municipio de Querétaro donde puede ubicarse un punto de venta.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-27T19:44:58.488998954Z[Etc/UTC]", comments = "Generator version: 7.5.0")
public class Colonia implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String nombre;

  public Colonia() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Colonia(Integer id, String nombre) {
    this.id = id;
    this.nombre = nombre;
  }

  public Colonia id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador único de la colonia.
   * @return id
  */
  @NotNull 
  @Schema(name = "id", example = "12", description = "Identificador único de la colonia.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Colonia nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Nombre oficial de la colonia o fraccionamiento.
   * @return nombre
  */
  @NotNull @Size(min = 1, max = 150) 
  @Schema(name = "nombre", example = "San Antonio de la Punta", description = "Nombre oficial de la colonia o fraccionamiento.", requiredMode = Schema.RequiredMode.REQUIRED)
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
    Colonia colonia = (Colonia) o;
    return Objects.equals(this.id, colonia.id) &&
        Objects.equals(this.nombre, colonia.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Colonia {\n");
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

