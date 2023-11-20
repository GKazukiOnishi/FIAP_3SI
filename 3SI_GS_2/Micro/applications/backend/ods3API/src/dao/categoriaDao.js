const dao = require('./dao');
const helper = require('./helper');

async function getCategorias() {
  const rows = await dao.query(
    `SELECT num_categoria numCategoria, nm_categoria nmCategoria, nivel FROM categoria`
  );
  return helper.emptyOrRows(rows);
}

module.exports = {
  getCategorias
}