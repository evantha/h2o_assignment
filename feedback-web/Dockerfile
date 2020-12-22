FROM node:14-alpine AS builder

WORKDIR /app

COPY package.json .

RUN npm install --only=dev

RUN npm install --only=prod

COPY . .

RUN npm run build

FROM nginx:stable-alpine

COPY --from=builder /app/dist/* /usr/share/nginx/html/

COPY --from=builder /app/nginx.conf /etc/nginx/conf.d/default.conf

VOLUME /var/log/nginx

CMD ["nginx", "-g", "daemon off;"]
