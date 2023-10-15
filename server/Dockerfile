FROM --platform=linux/amd64 eclipse-temurin:17-jdk-alpine as builder

ARG WORKSPACE=/workspace/app/server
ARG BUILD_TARGET=${WORKSPACE}/build/libs
WORKDIR ${WORKSPACE}

COPY . .
RUN ./gradlew clean bootJar

WORKDIR ${BUILD_TARGET}
RUN jar -xf *.jar



FROM --platform=linux/amd64 eclipse-temurin:17-jdk-alpine

ARG WORKSPACE=/workspace/app/server
ARG BUILD_TARGET=${WORKSPACE}/build/libs
ARG DEPLOY_PATH=${WORKSPACE}/deploy

COPY --from=builder ${BUILD_TARGET}/org ${DEPLOY_PATH}/org
COPY --from=builder ${BUILD_TARGET}/BOOT-INF/lib ${DEPLOY_PATH}/BOOT-INF/lib
COPY --from=builder ${BUILD_TARGET}/META-INF ${DEPLOY_PATH}/META-INF
COPY --from=builder ${BUILD_TARGET}/BOOT-INF/classes ${DEPLOY_PATH}/BOOT-INF/classes

WORKDIR ${DEPLOY_PATH}

ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]