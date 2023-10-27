FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Dar permissões de execução ao arquivo mvnw
RUN chmod +x mvnw
# Imprimir informações de debug
RUN ls -la

RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

EXPOSE 8080

ENTRYPOINT ["java","-cp","app:app/lib/*","br.com.fsales.parktech.ParkTechApplication"]


#mkdir target/extracted
#java -Djarmode=layertools -jar target/*.jar extract --destination target/extracted
#docker build -t fosales/parktech:latest -t fosales/parktech:0.0.1-SNAPSHOT .
# docker  build -f ./park-tech/Dockerfile -t fosales/parktech:latest ./park-tech/