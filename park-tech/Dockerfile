FROM amazoncorretto:17-alpine as build
WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
# https://aws.amazon.com/pt/blogs/containers/start-spring-boot-applications-faster-on-aws-fargate-using-soci/
# Dar permissões de execução ao arquivo mvnw
RUN chmod +x mvnw

RUN ./mvnw package -DskipTests -Pnative
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM amazoncorretto:17-alpine-jdk

ENV EXPOSE_PORT=8080

# Adicione dependências do sistema necessárias para o GraalVM
#RUN apk --no-cache add libstdc++ libgcc

ARG DEPENDENCY=/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

EXPOSE $EXPOSE_PORT

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -cp app:app/lib/* br.com.fsales.parktech.ParkTechApplication ${0} ${@}"]
#ENTRYPOINT ["java","-cp","app:app/lib/*","br.com.fsales.parktech.ParkTechApplication"]

# mkdir target/extracted
# java -Djarmode=layertools -jar target/*.jar extract --destination target/extracted
# docker build -t fosales/park-tech:latest -t fosales/park-tech:0.0.1-SNAPSHOT .
# docker  build -f ./park-tech/Dockerfile -t fosales/park-tech:latest ./park-tech/