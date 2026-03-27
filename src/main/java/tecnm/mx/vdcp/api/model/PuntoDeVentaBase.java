package tecnm.mx.vdcp.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import tecnm.mx.vdcp.api.model.Delegacion;
import tecnm.mx.vdcp.api.model.DiaSemana;
import tecnm.mx.vdcp.api.model.Estatus;
import tecnm.mx.vdcp.api.model.TipoHorario;
import tecnm.mx.vdcp.api.model.TipoInstalacion;
import java.util.NoSuchElementException;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PuntoDeVentaBase
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-03-27T19:44:58.488998954Z[Etc/UTC]", comments = "Generator version: 7.5.0")
public class PuntoDeVentaBase implements Serializable {

  private static final long serialVersionUID = 1L;

  private String nombre;

  private TipoInstalacion tipoInstalacion;

  private Estatus estatus;

  private JsonNullable<@Size(max = 500) String> delimitaciones = JsonNullable.<String>undefined();

  private Integer coloniaId;

  private JsonNullable<@Size(max = 300) String> referencia = JsonNullable.<String>undefined();

  private Delegacion delegacion;

  private JsonNullable<String> poligono = JsonNullable.<String>undefined();

  private JsonNullable<URI> imagenUrl = JsonNullable.<URI>undefined();

  @Valid
  private JsonNullable<List<DiaSemana>> diasOperacion = JsonNullable.<List<DiaSemana>>undefined();

  private JsonNullable<@Size(max = 100) String> horario = JsonNullable.<String>undefined();

  private JsonNullable<TipoHorario> tipoHorario = JsonNullable.<TipoHorario>undefined();

  private JsonNullable<@Size(max = 200) String> asociacion = JsonNullable.<String>undefined();

  private Integer afiliacionId;

  private JsonNullable<@Size(max = 150) String> representanteGeneral = JsonNullable.<String>undefined();

  private JsonNullable<@Size(max = 500) String> estructura = JsonNullable.<String>undefined();

  private JsonNullable<@Size(max = 1000) String> observaciones = JsonNullable.<String>undefined();

  public PuntoDeVentaBase() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PuntoDeVentaBase(String nombre, TipoInstalacion tipoInstalacion, Estatus estatus, Integer coloniaId, Delegacion delegacion, Integer afiliacionId) {
    this.nombre = nombre;
    this.tipoInstalacion = tipoInstalacion;
    this.estatus = estatus;
    this.coloniaId = coloniaId;
    this.delegacion = delegacion;
    this.afiliacionId = afiliacionId;
  }

  public PuntoDeVentaBase nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Nombre oficial o común del punto de venta tal como aparece en el padrón municipal.
   * @return nombre
  */
  @NotNull @Size(min = 1, max = 200) 
  @Schema(name = "nombre", example = "Tianguis Calle Nueva", description = "Nombre oficial o común del punto de venta tal como aparece en el padrón municipal.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nombre")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public PuntoDeVentaBase tipoInstalacion(TipoInstalacion tipoInstalacion) {
    this.tipoInstalacion = tipoInstalacion;
    return this;
  }

  /**
   * Get tipoInstalacion
   * @return tipoInstalacion
  */
  @NotNull @Valid 
  @Schema(name = "tipo_instalacion", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tipo_instalacion")
  public TipoInstalacion getTipoInstalacion() {
    return tipoInstalacion;
  }

  public void setTipoInstalacion(TipoInstalacion tipoInstalacion) {
    this.tipoInstalacion = tipoInstalacion;
  }

  public PuntoDeVentaBase estatus(Estatus estatus) {
    this.estatus = estatus;
    return this;
  }

  /**
   * Get estatus
   * @return estatus
  */
  @NotNull @Valid 
  @Schema(name = "estatus", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("estatus")
  public Estatus getEstatus() {
    return estatus;
  }

  public void setEstatus(Estatus estatus) {
    this.estatus = estatus;
  }

  public PuntoDeVentaBase delimitaciones(String delimitaciones) {
    this.delimitaciones = JsonNullable.of(delimitaciones);
    return this;
  }

  /**
   * Descripción textual de los límites físicos o calles que delimitan el punto de venta.
   * @return delimitaciones
  */
  @Size(max = 500) 
  @Schema(name = "delimitaciones", example = "Calle Nueva entre Calle los Mendoza y Calle Dalia", description = "Descripción textual de los límites físicos o calles que delimitan el punto de venta.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("delimitaciones")
  public JsonNullable<@Size(max = 500) String> getDelimitaciones() {
    return delimitaciones;
  }

  public void setDelimitaciones(JsonNullable<String> delimitaciones) {
    this.delimitaciones = delimitaciones;
  }

  public PuntoDeVentaBase coloniaId(Integer coloniaId) {
    this.coloniaId = coloniaId;
    return this;
  }

  /**
   * Identificador de la colonia donde se ubica el punto de venta. Debe existir en GET /colonias.
   * @return coloniaId
  */
  @NotNull 
  @Schema(name = "colonia_id", example = "12", description = "Identificador de la colonia donde se ubica el punto de venta. Debe existir en GET /colonias.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("colonia_id")
  public Integer getColoniaId() {
    return coloniaId;
  }

  public void setColoniaId(Integer coloniaId) {
    this.coloniaId = coloniaId;
  }

  public PuntoDeVentaBase referencia(String referencia) {
    this.referencia = JsonNullable.of(referencia);
    return this;
  }

  /**
   * Referencia geográfica o punto de referencia cercano para localizar el punto de venta.
   * @return referencia
  */
  @Size(max = 300) 
  @Schema(name = "referencia", example = "A un costado de las canchas", description = "Referencia geográfica o punto de referencia cercano para localizar el punto de venta.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("referencia")
  public JsonNullable<@Size(max = 300) String> getReferencia() {
    return referencia;
  }

  public void setReferencia(JsonNullable<String> referencia) {
    this.referencia = referencia;
  }

  public PuntoDeVentaBase delegacion(Delegacion delegacion) {
    this.delegacion = delegacion;
    return this;
  }

  /**
   * Get delegacion
   * @return delegacion
  */
  @NotNull @Valid 
  @Schema(name = "delegacion", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("delegacion")
  public Delegacion getDelegacion() {
    return delegacion;
  }

  public void setDelegacion(Delegacion delegacion) {
    this.delegacion = delegacion;
  }

  public PuntoDeVentaBase poligono(String poligono) {
    this.poligono = JsonNullable.of(poligono);
    return this;
  }

  /**
   * Geometría del área del punto de venta en formato WKT (Well-Known Text), compatible con PostGIS. Ejemplo: POLYGON((lon1 lat1, lon2 lat2, ...)). No se acepta formato GeoJSON en este campo. 
   * @return poligono
  */
  
  @Schema(name = "poligono", example = "POLYGON((100.0 0.0, 101.0 0.0, 101.0 1.0, 100.0 0.0))", description = "Geometría del área del punto de venta en formato WKT (Well-Known Text), compatible con PostGIS. Ejemplo: POLYGON((lon1 lat1, lon2 lat2, ...)). No se acepta formato GeoJSON en este campo. ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("poligono")
  public JsonNullable<String> getPoligono() {
    return poligono;
  }

  public void setPoligono(JsonNullable<String> poligono) {
    this.poligono = poligono;
  }

  public PuntoDeVentaBase imagenUrl(URI imagenUrl) {
    this.imagenUrl = JsonNullable.of(imagenUrl);
    return this;
  }

  /**
   * URL pública de la imagen representativa del punto de venta. Gestionada externamente vía CDN.
   * @return imagenUrl
  */
  @Valid 
  @Schema(name = "imagen_url", example = "https://cdn.vdcp.mx/imagenes/tianguis-calle-nueva.jpg", description = "URL pública de la imagen representativa del punto de venta. Gestionada externamente vía CDN.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("imagen_url")
  public JsonNullable<URI> getImagenUrl() {
    return imagenUrl;
  }

  public void setImagenUrl(JsonNullable<URI> imagenUrl) {
    this.imagenUrl = imagenUrl;
  }

  public PuntoDeVentaBase diasOperacion(List<DiaSemana> diasOperacion) {
    this.diasOperacion = JsonNullable.of(diasOperacion);
    return this;
  }

  public PuntoDeVentaBase addDiasOperacionItem(DiaSemana diasOperacionItem) {
    if (this.diasOperacion == null || !this.diasOperacion.isPresent()) {
      this.diasOperacion = JsonNullable.of(new ArrayList<>());
    }
    this.diasOperacion.get().add(diasOperacionItem);
    return this;
  }

  /**
   * Lista de días de la semana en que opera el punto de venta.
   * @return diasOperacion
  */
  @Valid 
  @Schema(name = "dias_operacion", example = "[\"sabado\",\"domingo\"]", description = "Lista de días de la semana en que opera el punto de venta.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dias_operacion")
  public JsonNullable<List<DiaSemana>> getDiasOperacion() {
    return diasOperacion;
  }

  public void setDiasOperacion(JsonNullable<List<DiaSemana>> diasOperacion) {
    this.diasOperacion = diasOperacion;
  }

  public PuntoDeVentaBase horario(String horario) {
    this.horario = JsonNullable.of(horario);
    return this;
  }

  /**
   * Descripción textual del horario de operación. Formato recomendado: HH:MM - HH:MM.
   * @return horario
  */
  @Size(max = 100) 
  @Schema(name = "horario", example = "De 7 a 2 pm", description = "Descripción textual del horario de operación. Formato recomendado: HH:MM - HH:MM.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("horario")
  public JsonNullable<@Size(max = 100) String> getHorario() {
    return horario;
  }

  public void setHorario(JsonNullable<String> horario) {
    this.horario = horario;
  }

  public PuntoDeVentaBase tipoHorario(TipoHorario tipoHorario) {
    this.tipoHorario = JsonNullable.of(tipoHorario);
    return this;
  }

  /**
   * Franja horaria predominante de operación. Ver schema TipoHorario.
   * @return tipoHorario
  */
  @Valid 
  @Schema(name = "tipo_horario", description = "Franja horaria predominante de operación. Ver schema TipoHorario.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tipo_horario")
  public JsonNullable<TipoHorario> getTipoHorario() {
    return tipoHorario;
  }

  public void setTipoHorario(JsonNullable<TipoHorario> tipoHorario) {
    this.tipoHorario = tipoHorario;
  }

  public PuntoDeVentaBase asociacion(String asociacion) {
    this.asociacion = JsonNullable.of(asociacion);
    return this;
  }

  /**
   * Nombre de la asociación u organización civil a la que pertenece el punto de venta, si aplica.
   * @return asociacion
  */
  @Size(max = 200) 
  @Schema(name = "asociacion", example = "Unión de Comerciantes de San Antonio de la Punta, A.C.", description = "Nombre de la asociación u organización civil a la que pertenece el punto de venta, si aplica.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("asociacion")
  public JsonNullable<@Size(max = 200) String> getAsociacion() {
    return asociacion;
  }

  public void setAsociacion(JsonNullable<String> asociacion) {
    this.asociacion = asociacion;
  }

  public PuntoDeVentaBase afiliacionId(Integer afiliacionId) {
    this.afiliacionId = afiliacionId;
    return this;
  }

  /**
   * Identificador de la afiliación gremial del punto de venta. Debe existir en GET /afiliaciones.
   * @return afiliacionId
  */
  @NotNull 
  @Schema(name = "afiliacion_id", example = "3", description = "Identificador de la afiliación gremial del punto de venta. Debe existir en GET /afiliaciones.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("afiliacion_id")
  public Integer getAfiliacionId() {
    return afiliacionId;
  }

  public void setAfiliacionId(Integer afiliacionId) {
    this.afiliacionId = afiliacionId;
  }

  public PuntoDeVentaBase representanteGeneral(String representanteGeneral) {
    this.representanteGeneral = JsonNullable.of(representanteGeneral);
    return this;
  }

  /**
   * Nombre completo del representante legal o delegado del punto de venta.
   * @return representanteGeneral
  */
  @Size(max = 150) 
  @Schema(name = "representante_general", example = "Felipe Carrillo Puerto", description = "Nombre completo del representante legal o delegado del punto de venta.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("representante_general")
  public JsonNullable<@Size(max = 150) String> getRepresentanteGeneral() {
    return representanteGeneral;
  }

  public void setRepresentanteGeneral(JsonNullable<String> representanteGeneral) {
    this.representanteGeneral = representanteGeneral;
  }

  public PuntoDeVentaBase estructura(String estructura) {
    this.estructura = JsonNullable.of(estructura);
    return this;
  }

  /**
   * Descripción del tipo de infraestructura física del punto de venta (lonas, puestos fijos, etc.).
   * @return estructura
  */
  @Size(max = 500) 
  @Schema(name = "estructura", example = "Puestos semifijos con lonas", description = "Descripción del tipo de infraestructura física del punto de venta (lonas, puestos fijos, etc.).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("estructura")
  public JsonNullable<@Size(max = 500) String> getEstructura() {
    return estructura;
  }

  public void setEstructura(JsonNullable<String> estructura) {
    this.estructura = estructura;
  }

  public PuntoDeVentaBase observaciones(String observaciones) {
    this.observaciones = JsonNullable.of(observaciones);
    return this;
  }

  /**
   * Notas adicionales relevantes para inspección o supervisión del punto de venta.
   * @return observaciones
  */
  @Size(max = 1000) 
  @Schema(name = "observaciones", example = "Opera solo en temporada de lluvia", description = "Notas adicionales relevantes para inspección o supervisión del punto de venta.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("observaciones")
  public JsonNullable<@Size(max = 1000) String> getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(JsonNullable<String> observaciones) {
    this.observaciones = observaciones;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PuntoDeVentaBase puntoDeVentaBase = (PuntoDeVentaBase) o;
    return Objects.equals(this.nombre, puntoDeVentaBase.nombre) &&
        Objects.equals(this.tipoInstalacion, puntoDeVentaBase.tipoInstalacion) &&
        Objects.equals(this.estatus, puntoDeVentaBase.estatus) &&
        equalsNullable(this.delimitaciones, puntoDeVentaBase.delimitaciones) &&
        Objects.equals(this.coloniaId, puntoDeVentaBase.coloniaId) &&
        equalsNullable(this.referencia, puntoDeVentaBase.referencia) &&
        Objects.equals(this.delegacion, puntoDeVentaBase.delegacion) &&
        equalsNullable(this.poligono, puntoDeVentaBase.poligono) &&
        equalsNullable(this.imagenUrl, puntoDeVentaBase.imagenUrl) &&
        equalsNullable(this.diasOperacion, puntoDeVentaBase.diasOperacion) &&
        equalsNullable(this.horario, puntoDeVentaBase.horario) &&
        equalsNullable(this.tipoHorario, puntoDeVentaBase.tipoHorario) &&
        equalsNullable(this.asociacion, puntoDeVentaBase.asociacion) &&
        Objects.equals(this.afiliacionId, puntoDeVentaBase.afiliacionId) &&
        equalsNullable(this.representanteGeneral, puntoDeVentaBase.representanteGeneral) &&
        equalsNullable(this.estructura, puntoDeVentaBase.estructura) &&
        equalsNullable(this.observaciones, puntoDeVentaBase.observaciones);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, tipoInstalacion, estatus, hashCodeNullable(delimitaciones), coloniaId, hashCodeNullable(referencia), delegacion, hashCodeNullable(poligono), hashCodeNullable(imagenUrl), hashCodeNullable(diasOperacion), hashCodeNullable(horario), hashCodeNullable(tipoHorario), hashCodeNullable(asociacion), afiliacionId, hashCodeNullable(representanteGeneral), hashCodeNullable(estructura), hashCodeNullable(observaciones));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PuntoDeVentaBase {\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    tipoInstalacion: ").append(toIndentedString(tipoInstalacion)).append("\n");
    sb.append("    estatus: ").append(toIndentedString(estatus)).append("\n");
    sb.append("    delimitaciones: ").append(toIndentedString(delimitaciones)).append("\n");
    sb.append("    coloniaId: ").append(toIndentedString(coloniaId)).append("\n");
    sb.append("    referencia: ").append(toIndentedString(referencia)).append("\n");
    sb.append("    delegacion: ").append(toIndentedString(delegacion)).append("\n");
    sb.append("    poligono: ").append(toIndentedString(poligono)).append("\n");
    sb.append("    imagenUrl: ").append(toIndentedString(imagenUrl)).append("\n");
    sb.append("    diasOperacion: ").append(toIndentedString(diasOperacion)).append("\n");
    sb.append("    horario: ").append(toIndentedString(horario)).append("\n");
    sb.append("    tipoHorario: ").append(toIndentedString(tipoHorario)).append("\n");
    sb.append("    asociacion: ").append(toIndentedString(asociacion)).append("\n");
    sb.append("    afiliacionId: ").append(toIndentedString(afiliacionId)).append("\n");
    sb.append("    representanteGeneral: ").append(toIndentedString(representanteGeneral)).append("\n");
    sb.append("    estructura: ").append(toIndentedString(estructura)).append("\n");
    sb.append("    observaciones: ").append(toIndentedString(observaciones)).append("\n");
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

