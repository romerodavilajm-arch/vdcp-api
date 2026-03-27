# Base: Java 25 JDK
# Usamos la imagen oficial de Eclipse Temurin con Java 25 JDK como base
# Temurin es el OpenJDK de Adoptium, una distribución open source confiable
FROM eclipse-temurin:25-jdk

# Instalar Maven 3.9.9 desde Apache
# Definimos argumentos de build que pueden sobrescribirse al construir la imagen
# ARG se usa solo durante el build, no persiste en la imagen final como ENV
ARG MAVEN_VERSION=3.9.9
ARG MAVEN_HOME=/opt/maven

# Variables de entorno que persistirán en la imagen final
# MAVEN_HOME: directorio raíz de instalación de Maven
ENV MAVEN_HOME=${MAVEN_HOME}
# PATH: añadimos el directorio bin de Maven al PATH del sistema
# Esto permite ejecutar 'mvn' desde cualquier ubicación
ENV PATH=${MAVEN_HOME}/bin:${PATH}

# Instalación de Maven en múltiples pasos dentro de una sola capa (RUN)
# Usamos una sola instrucción RUN para minimizar el número de capas en la imagen
RUN apt-get update && \
    # Instalamos wget temporalmente para descargar Maven \
    apt-get install -y wget && \
    # Descargamos Maven desde el archivo histórico de Apache (archive.apache.org)
    # -q: modo silencioso, solo muestra errores
    wget -q https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
    # Extraemos el archivo tar.gz en /opt
    tar -xzf apache-maven-${MAVEN_VERSION}-bin.tar.gz -C /opt && \
    # Movemos y renombramos la carpeta extraída a la ubicación definida en MAVEN_HOME
    mv /opt/apache-maven-${MAVEN_VERSION} ${MAVEN_HOME} && \
    # Eliminamos el archivo descargado para liberar espacio
    rm apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
    # Eliminamos wget ya que ya no lo necesitamos
    apt-get remove -y wget && \
    # Eliminamos dependencias automáticas que ya no se necesitan
    apt-get autoremove -y && \
    # Limpiamos la caché de apt para reducir el tamaño de la imagen
    # /var/lib/apt/lists/* contiene la lista de paquetes disponibles
    rm -rf /var/lib/apt/lists/*

# Establecemos el directorio de trabajo para las siguientes instrucciones
# Si no existe, Docker lo crea automáticamente
WORKDIR /app

# Copiar solo el pom.xml para precargar dependencias (capa cacheable)
# Esta estrategia aprovecha el sistema de capas de Docker:
# - Primero copiamos solo pom.xml (el archivo de configuración de Maven)
# - Luego descargamos las dependencias
# - Esto crea una capa cacheable que solo se invalida si cambia pom.xml
# - Las dependencias no se redescargarán en cada build si pom.xml no cambia
COPY pom.xml .
# Descargamos todas las dependencias del proyecto offline
# dependency:go-offline descarga todas las dependencias necesarias para el build
# Esto incluye dependencias directas, transitivas y plugins de Maven
# El objetivo es tener todas las dependencias en caché antes de copiar el código fuente
RUN mvn dependency:go-offline

# El resto del código se montará como volumen para poder modificarlo en caliente
# En lugar de copiar el código fuente, usamos un volumen montado desde el host
# Esto permite editar el código en el IDE y ver los cambios reflejados sin reconstruir
# CMD ejecuta 'tail -f /dev/null' que mantiene el contenedor vivo indefinidamente
# Esto es útil para desarrollo: el contenedor se mantiene en ejecución
# y podemos conectarnos a él con 'docker exec' para ejecutar comandos manualmente
# También permite que herramientas como IDEs se conecten al contenedor
CMD ["tail", "-f", "/dev/null"]