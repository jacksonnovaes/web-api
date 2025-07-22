FROM gradle:8.0-jdk17 AS build
WORKDIR /app

# Copia apenas arquivos necessários para cache melhor
COPY gradlew .
COPY gradle ./gradle
COPY build.gradle.kts settings.gradle.kts ./

# Baixa dependências para acelerar build final
RUN chmod +x ./gradlew && ./gradlew build -x test --no-daemon || true

# Copia o restante do projeto
COPY . .

# Agora sim o build completo
RUN ./gradlew clean build -x test --no-daemon

# Etapa 2: Imagem leve para produção
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia o jar gerado da etapa anterior
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
