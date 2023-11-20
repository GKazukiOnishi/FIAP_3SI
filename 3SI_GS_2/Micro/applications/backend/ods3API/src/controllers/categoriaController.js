const categoriaDao = require('../dao/categoriaDao');

exports.get = async (req, res, next) => {
  const categorias = await categoriaDao.getCategorias();

  res.status(200).send(categorias);
};