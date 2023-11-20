const dao = require('./dao');
const helper = require('./helper');

async function getObjetivosByMeta(codMeta) {
  const rows = await dao.query(
    `SELECT origem, objetivo FROM objetivo WHERE cod_meta = ?`,
    [codMeta]);
  return helper.emptyOrRows(rows);
}

module.exports = {
  getObjetivosByMeta
}