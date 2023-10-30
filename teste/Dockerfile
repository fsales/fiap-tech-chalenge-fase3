FROM mongo

# Defina variáveis de ambiente
ENV MONGO_INITDB_ROOT_USERNAME=admin
ENV MONGO_INITDB_ROOT_PASSWORD=admin
ENV MONGO_INITDB_DATABASE=admin_db
ENV MONGO_USERS='[{"username": "user1", "password": "password1", "roles": ["readWrite", "dbAdmin"]}]'

# Copie o script de configuração para o diretório de scripts de inicialização do MongoDB
COPY ./setup-mongo.js /docker-entrypoint-initdb.d/setup-mongo.js
