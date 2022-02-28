FROM postgres

ENV TZ=Asia/Seoul
ENV POSTGRES_PASSWORD=12345
ENV POSTGRES_INITDB_ARGS="--encoding=UTF-8"

 RUN \
    apt-get update && \
    apt-get install -y postgis  postgresql-14-postgis-3