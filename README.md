# VDCP API – Visor de Comercio Popular

API para la gestión del padrón comercial de puntos de venta del municipio de Querétaro.

## Configuración del Proyecto

El proyecto se inicializó utilizando [Spring Initializr](https://start.spring.io/) con la siguiente configuración:

### Tecnologías Base

| Campo       | Valor    |
|-------------|----------|
| Project     | Maven    |
| Language    | Java     |
| Spring Boot | 4.0.5    |
| Packaging   | Jar      |
| Java        | 25 (LTS) |

### Metadata del Proyecto

| Campo        | Valor               |
|--------------|---------------------|
| Group        | `tecnm.mx`          |
| Artifact     | `vdcp-api`          |
| Package name | `tecnm.mx.vdcp.api` |

### Dependencias Incluidas

| Dependencia          | Propósito                                       |
|----------------------|-------------------------------------------------|
| Spring Web           | Implementación de controladores REST            |
| Spring Boot Actuator | Observabilidad y monitoreo                      |
| Validation           | Validación de datos con Jakarta Bean Validation |

### Dependencias Futuras

Considerar agregar según necesidades del proyecto:

- **Spring Data JPA** – Persistencia de datos
- **PostgreSQL Driver** – Base de datos con soporte PostGIS
- **Hibernate Spatial** – Manejo de geometrías (campo `poligono`)
- **SpringDoc OpenAPI** – Generación automática de documentación
- **Lombok** – Reducción de código boilerplate

## Estructura del Proyecto

```
vdcp-api/
├── src/
│   ├── main/
│   │   ├── java/tecnm/mx/vdcp/api/
│   │   │   ├── VdcpApiApplication.java
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   └── service/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── ...
│   └── test/
├── pom.xml
└── README.md
```

## Referencia del API

La especificación completa del API se encuentra en .

## Ejecución Local

```bash
# Compilar el proyecto
./mvnw clean package

# Ejecutar la aplicación
./mvnw spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080/api/v1`
