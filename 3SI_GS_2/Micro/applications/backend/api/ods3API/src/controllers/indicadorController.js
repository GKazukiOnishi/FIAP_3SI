const indicadorDao = require('../dao/indicadorDao');

exports.get = async (req, res, next) => {
  try {
    const indicador = await indicadorDao.getIndicador(req.params?.codIndicador);

    if (!indicador) {
      res.status(404).send("Indicador inexistente");
      return;
    }

    const dados = await indicadorDao.getDadosIndicador(indicador.codIndicador);
    indicador.dados = dados;

    res.status(200).send(indicador);
  } catch (e) {
    next(e);
  }
};