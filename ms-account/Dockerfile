# Usar una imagen base de JDK
FROM openjdk:17-jdk-alpine

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR del microservicio al contenedor
COPY ms-account/target/ms-account-0.0.1-SNAPSHOT.jar /app/ms-account.jar

# Expone el puerto en el que corre la aplicación
EXPOSE 9090

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "ms-account.jar"]