FROM adoptopenjdk/openjdk11:alpine-jre

COPY ./target/artifacts/MedicalHistory_jar/MedicalHistory.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch MedicalHistory.jar'

ENTRYPOINT ["java","-cp","MedicalHistory.jar","com.example.demo.MedicalHistoryApplication"]