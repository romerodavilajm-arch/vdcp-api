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

### Estructura del Proyecto

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

## Desarrollo con Docker

El proyecto incluye una configuración de Docker optimizada para desarrollo. Esta configuración permite trabajar sin necesidad de instalar Java o Maven localmente, garantizando un entorno consistente para todo el equipo.

### Arquitectura de Desarrollo

- **Dockerfile**: Configura una imagen con Java 25 JDK y Maven 3.9.9
- **docker-compose.yml**: Define el servicio `dev` con montaje de volumen para desarrollo en caliente
- **Estrategia**: El contenedor permanece vivo con `tail -f /dev/null` mientras desarrollas

### Flujo de Desarrollo Diario

#### Iniciar Sesión de Desarrollo

```bash
# 1. Construir la imagen (solo la primera vez o cuando cambie pom.xml)
docker compose build

# 2. Levantar el contenedor en segundo plano
docker compose up -d

# 3. Verificar que el contenedor está corriendo
docker compose ps

# 4. Acceder al contenedor con una terminal interactiva
docker compose exec dev bash
```

#### Dentro del Contenedor

Una vez dentro del contenedor (bash), puedes ejecutar los comandos habituales de Maven:

```bash
# Compilar el proyecto
mvn compile

# Ejecutar tests
mvn test

# Ejecutar la aplicación Spring Boot
mvn spring-boot:run

# Empaquetar la aplicación
mvn package

# Instalar dependencias nuevas (después de modificar pom.xml)
mvn clean install
```

#### Desarrollo con el IDE

1. **Edición de código**: Usa tu IDE favorito en el host para editar los archivos
2. **Cambios automáticos**: Los cambios se reflejan inmediatamente dentro del contenedor gracias al volumen montado
3. **Ejecución continua**: Puedes mantener `mvn spring-boot:run` corriendo y ver los cambios en caliente (Spring Boot DevTools recomendado)
4. **Acceso a la API**: La aplicación estará disponible en `http://localhost:8080`

#### Finalizar Sesión de Desarrollo

```bash
# Detener el contenedor (conserva el contenedor e imagen)
docker compose stop

# Para iniciar nuevamente después de un stop
docker compose start

# Acceder nuevamente al contenedor después de un stop/start
docker compose exec dev bash
```

### ¿Debo Borrar el Contenedor e Imagen al Finalizar?

**No es necesario hacerlo diariamente.** Aquí están las recomendaciones:

#### Conservar contenedor e imagen (uso diario)
- ✅ **Recomendado para desarrollo diario**: Simplemente usa `docker compose stop` al terminar
- ✅ El contenedor conserva el estado, caché de Maven y dependencias
- ✅ Al día siguiente, solo ejecuta `docker compose start` y continúas trabajando
- ✅ La imagen ya está construida, no necesitas reconstruir

#### Limpiar completamente (casos específicos)
- **Cuando cambias el Dockerfile**: Necesitas reconstruir la imagen con `docker compose build`
- **Cuando modificas pom.xml**: Debes reconstruir para precargar nuevas dependencias
- **Para liberar espacio en disco**: Si tienes muchos contenedores/imágenes acumulados
- **Al finalizar un sprint o feature**: Limpieza periódica recomendada

```bash
# Detener y eliminar el contenedor (conserva la imagen)
docker compose down

# Eliminar también la imagen
docker compose down --rmi local

# Limpieza completa (contenedor + imagen + volúmenes huérfanos)
docker compose down --rmi local --volumes
```

### Comandos Útiles de Docker

```bash
# Ver estado de los contenedores
docker compose ps

# Ver logs en tiempo real
docker compose logs -f dev

# Ejecutar un comando específico sin entrar al bash
docker compose exec dev mvn test

# Reconstruir la imagen sin usar caché (limpieza total)
docker compose build --no-cache

# Acceder al contenedor como usuario root (útil para instalar paquetes)
docker compose exec -u root dev bash
```

### Flujo de Trabajo Recomendado

#### Inicio del Día
```bash
# 1. Ir al directorio del proyecto
cd vdcp-api

# 2. Levantar el contenedor (si está detenido)
docker compose start

# Si el contenedor no existe (primera vez o después de limpieza)
docker compose up -d

# 3. Acceder al entorno de desarrollo
docker compose exec dev bash
```

#### Durante el Desarrollo
- Edita código en el IDE
- Dentro del contenedor: `mvn spring-boot:run` para pruebas
- Prueba la API en `http://localhost:8080`
- Ejecuta tests específicos: `mvn test -Dtest=NombreTest`

#### Fin del Día
```bash
# Salir del bash (si estás dentro)
exit

# Detener el contenedor (conserva todo para mañana)
docker compose stop
```

#### Limpieza Periódica (Cada 1-2 semanas)
```bash
# Verificar contenedores detenidos
docker container ls -a

# Verificar imágenes no utilizadas
docker image ls

# Limpieza segura (elimina contenedores detenidos e imágenes no etiquetadas)
docker system prune

# Limpieza más agresiva (elimina también volúmenes no utilizados)
docker system prune -a --volumes
```

### Beneficios de Este Flujo

1. **No necesitas Java/Maven local**: Todo está dentro del contenedor
2. **Entorno consistente**: Todos los desarrolladores usan las mismas versiones
3. **Inicio rápido**: Solo necesitas Docker instalado
4. **Cambios en caliente**: Editas en el IDE y los cambios están disponibles inmediatamente
5. **Sin pérdida de trabajo**: El contenedor detenido conserva su estado
6. **Aislamiento**: No contaminas tu máquina con dependencias

### Solución de Problemas Comunes

| Problema                         | Solución                                                                    |
|----------------------------------|-----------------------------------------------------------------------------|
| `mvn: command not found`         | Verifica que entraste al contenedor con `docker compose exec dev bash`      |
| El puerto 8080 ya está en uso    | Cambia el mapeo en `docker-compose.yml`: `"8081:8080"`                      |
| Cambios en código no se reflejan | Verifica que el volumen está montado: `docker compose exec dev ls -la /app` |
| Error de permisos en archivos    | Usa `docker compose exec -u root dev bash` y ajusta permisos                |
| Dependencias no descargan        | Reconstruye la imagen: `docker compose build --no-cache`                    |
| Contenedor no inicia             | Verifica logs: `docker compose logs dev`                                    |

### Personalización para Diferentes Necesidades

#### Agregar una Base de Datos
```yaml
# docker-compose.yml
services:
  dev:
    # ... configuración existente
    depends_on:
      - postgres
  
  postgres:
    image: postgis/postgis:15-3.4
    environment:
      POSTGRES_DB: vdcp_db
      POSTGRES_USER: vdcp_user
      POSTGRES_PASSWORD: vdcp_pass
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:
```

#### Usar Spring Boot DevTools
Agrega al `pom.xml` para recarga automática:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

---

**Nota**: Este flujo está optimizado para desarrollo. Para producción, se debe crear una imagen multi-stage que copie solo el JAR resultante y lo ejecute directamente.
```