const metaDao = require('../dao/metaDao');
const objetivoDao = require('../dao/objetivoDao');
const indicadorDao = require('../dao/indicadorDao');
const helper = require('./helper');

exports.get = async (req, res, next) => {
  const metaResult = await metaDao.getMetas(req.query?.page);
  await loadRelations(metaResult.data);

  helper.mountPaginationHeaders(res, metaResult);
  res.status(200).send(metaResult.data);
};

async function loadRelations(metas) {
  const promisses = [];
  metas.forEach(meta => {
    promisses.push(loadObjetivos(meta));
    promisses.push(loadIndicadores(meta));
  });
  await Promise.all(promisses);
}

async function loadObjetivos(meta) {
  const objetivos = await objetivoDao.getObjetivosByMeta(meta.codMeta);
  meta.objetivos = objetivos;
}

async function loadIndicadores(meta) {
  const indicadores = await indicadorDao.getIndicadoresByMeta(meta.codMeta);
  meta.indicadores = indicadores;
}