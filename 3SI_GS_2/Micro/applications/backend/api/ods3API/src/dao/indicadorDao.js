const dao = require('./dao');
const helper = require('./helper');

async function getIndicadoresByMeta(codMeta) {
  const rows = await dao.query(
    `SELECT cod_indicador codIndicador, descricao FROM indicador WHERE cod_meta = ?`,
    [codMeta]
  );
  return helper.emptyOrRows(rows);
}

async function getIndicador(codIndicador) {
  const rows = await dao.query(
    `SELECT cod_meta codMeta, cod_indicador codIndicador, descricao, observacao, nm_coluna_x nmColunaX, nm_coluna_y nmColunaY FROM indicador WHERE cod_indicador = ?`,
    [codIndicador]
  );
  return rows[0];
}

async function getDadosIndicador(codIndicador) {
  const rows = await dao.query(
    `SELECT num_categoria numCategoria, num_dado numDado, vl_x vlX, vl_y vlY FROM dado_indicador WHERE cod_indicador = ?`,
    [codIndicador]
  );
  return helper.emptyOrRows(rows);
}

module.exports = {
  getIndicadoresByMeta,
  getIndicador,
  getDadosIndicador
}