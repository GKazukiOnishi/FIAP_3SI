const objetivoDao = require('../dao/objetivoDao');
const config = require('../config/databaseConfig');

exports.get = async (req, res, next) => {
  const result = await objetivoDao.getObjetivos(req.query?.page);

  res.status(200).header("page", result.page).header("total", result.total).header("perPage", config.listPerPage).send(result.data);
};