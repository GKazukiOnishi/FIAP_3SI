const express = require("express");
const router = express.Router();
const controller = require("../controllers/indicadorController");

router.get("/", controller.getIndicadores);
router.get("/:codIndicador", controller.getIndicador);

module.exports = router;
