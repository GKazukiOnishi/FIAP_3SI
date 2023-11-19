const mysql = require('mysql2/promise');
const config = require('../config/databaseConfig');

async function query(sql, params) {
  try {
    const connection = await mysql.createConnection(config.db);
    const [results, ] = await connection.execute(sql, params);
  
    return results;
  } catch (e) {
    console.log(`Ocorreu algum erro na interface com o banco de dados`, e);
    throw e;
  }
}

module.exports = {
  query
}