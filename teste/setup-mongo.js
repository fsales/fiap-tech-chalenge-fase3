// setup-mongo.js
const users = JSON.parse(process.env.MONGO_USERS);

// Conecta ao banco de dados de admin
db = db.getSiblingDB('admin');

// Verifica se o usuário "admin" já existe
const adminUser = db.getUser(process.env.MONGO_INITDB_ROOT_USERNAME);

if (adminUser) {
    // Se o usuário "admin" já existe, atualiza a senha
    db.changeUserPassword(process.env.MONGO_INITDB_ROOT_USERNAME, process.env.MONGO_INITDB_ROOT_PASSWORD);
} else {
    // Se o usuário "admin" não existe, cria com a senha fornecida
    db.createUser({
        user: process.env.MONGO_INITDB_ROOT_USERNAME,
        pwd: process.env.MONGO_INITDB_ROOT_PASSWORD,
        roles: ['root']
    });
}

// Conecta ao banco de dados especificado
db = db.getSiblingDB(process.env.MONGO_INITDB_DATABASE);

// Cria ou atualiza usuários personalizados
users.forEach(user => {
    const existingUser = db.getUser(user.username);
    if (existingUser) {
        // Se o usuário já existe, atualiza a senha e as permissões se necessário
        db.changeUserPassword(user.username, user.password);
        // Também é possível alterar as permissões aqui, se necessário
    } else {
        // Se o usuário não existe, cria com a senha fornecida e as permissões especificadas
        db.createUser({
            user: user.username,
            pwd: user.password,
            roles: user.roles
        });
    }
});
