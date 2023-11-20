const dao = require('./dao');
const helper = require('./helper');

async function countMeta() {
  const rows = await dao.query(
    `SELECT COUNT(*) total FROM meta`
  );
  return rows[0].total;
}

async function getMetas(page) {
  const total = await countMeta();

  const offsetQuery = helper.getOffsetQuery(page);
  const rows = await dao.query(
    `SELECT cod_meta codMeta FROM meta ${offsetQuery}`
  );
  const metas = helper.emptyOrRows(rows);

  return {
    data: metas,
    total,
    page
  };
}

module.exports = {
  getMetas
}