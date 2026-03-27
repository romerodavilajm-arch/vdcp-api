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
 * MensajeConfirmacion
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-27T19:44:58.488998954Z[Etc/UTC]", comments = "Generator version: 7.5.0")
public class MensajeConfirmacion implements Serializable {

  private static final long serialVersionUID = 1L;

  private String mensaje;

  public MensajeConfirmacion() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MensajeConfirmacion(String mensaje) {
    this.mensaje = mensaje;
  }

  public MensajeConfirmacion mensaje(String mensaje) {
    this.mensaje = mensaje;
    return this;
  }

  /**
   * Get mensaje
   * @return mensaje
  */
  @NotNull 
  @Schema(name = "mensaje", example = "Operación realizada correctamente", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("mensaje")
  public String getMensaje() {
    return mensaje;
  }

  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MensajeConfirmacion mensajeConfirmacion = (MensajeConfirmacion) o;
    return Objects.equals(this.mensaje, mensajeConfirmacion.mensaje);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mensaje);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MensajeConfirmacion {\n");
    sb.append("    mensaje: ").append(toIndentedString(mensaje)).append("\n");
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

