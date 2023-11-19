const express = require('express');

const app = express();

//Rotas
const index = require('./routes/index');
const objetivoRoute = require('./routes/objetivoRoute');
const indicadorRoute = require('./routes/indicadorRoute');
const categoriaRoute = require('./routes/categoriaRoute');

app.use('/', index);
app.use('/objetivos', objetivoRoute);
app.use('/indicador', indicadorRoute);
app.use('/categorias', categoriaRoute);

module.exports = app;