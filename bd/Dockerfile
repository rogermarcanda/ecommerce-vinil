FROM postgres:11-alpine

ADD ./01.init-bd.sh /docker-entrypoint-initdb.d/
ADD ./02.init-tables.sh /docker-entrypoint-initdb.d/
ADD ./03.insert-cashback.sh /docker-entrypoint-initdb.d/

EXPOSE 5432


