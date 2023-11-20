const mysql = require("mysql2/promise");

const config = {
  pool: {
    host: "localhost",
    user: "main",
    password: "1234",
    database: "ODS3",
    connectTimeout: 60000,
    waitForConnections: true,
    connectionLimit: 20,
    maxIdle: 10,
    idleTimeout: 60000,
    enableKeepAlive: true,
  },
  listPerPage: 10,
};

const dbPool = mysql.createPool(config.pool);

module.exports = config;
module.exports = dbPool;
