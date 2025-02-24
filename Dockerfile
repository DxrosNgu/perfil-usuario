FROM amazoncorretto:21-alpine-jdk
WORKDIR /app

ADD ./target/perfil-usuario-0.0.1-SNAPSHOT.jar perfil-usuario.jar

ENTRYPOINT [ "java", "-jar", "perfil-usuario.jar" ]
