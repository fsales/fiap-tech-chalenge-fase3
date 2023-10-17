db = db.getSiblingDB('park_tech')

db.createUser({
    user: 'park_tech',
    pwd: 'park_tech',
    roles: [
      {
        role: 'dbOwner',
      db: 'park_tech',
    },
  ],
});