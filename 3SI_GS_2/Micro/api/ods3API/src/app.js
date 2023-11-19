const express = require('express');
const app = express();

//Rotas
const index = require('./routes/index');
const objetivoRoute = require('./routes/objetivoRoute');

app.use('/', index);
app.use('/objetivos', objetivoRoute);

module.exports = app;