const dbPool = require("../config/databaseConfig");

async function query(sql, params) {
  try {
    const [results] = await dbPool.execute(sql, params);

    return results;
  } catch (e) {
    console.log(`Ocorreu algum erro na interface com o banco de dados`, e);
    throw e;
  }
}

module.exports = {
  query,
};
