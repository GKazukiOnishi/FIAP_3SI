const express = require('express');
const router = express.Router();
const controller = require('../controllers/objetivoController')

router.get('/', controller.get);

module.exports = router;