const dao = require('./dao');
const helper = require('./helper');
const config = require('../config/databaseConfig');

async function countObjetivos() {
  const rows = await dao.query(
    `SELECT COUNT(*) total FROM meta`
  );
  return rows[0].total;
}

async function getObjetivos(page = 1) {
  const total = await countObjetivos();

  const offset = helper.getOffset(page, config.listPerPage);
  const rows = await dao.query(
    `SELECT cod_meta FROM meta LIMIT ${offset},${config.listPerPage}`
  );
  const objetivos = helper.emptyOrRows(rows);

  return {
    data: objetivos,
    total: total,
    page: page
  };
}

module.exports = {
  getObjetivos
}