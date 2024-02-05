FROM node:18.19.0 as build

WORKDIR /usr/local/app

COPY ./ /usr/local/app

RUN npm install

RUN npm run build

FROM nginx:latest

COPY --from=build /usr/local/app/dist/lab5-ng-app /usr/share/nginx/html

LABEL org.opencontainers.image.title="lab5-ng-app"
LABEL build_version=""
LABEL maintainer=""

ENV API_URL http://localhost:8080/api

EXPOSE 80

ADD dist/lab5-ng-app /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
