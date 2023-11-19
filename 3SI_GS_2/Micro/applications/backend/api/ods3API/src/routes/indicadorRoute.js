const express = require('express');
const router = express.Router();
const controller = require('../controllers/indicadorController')

router.get('/:codIndicador', controller.get);

module.exports = router;