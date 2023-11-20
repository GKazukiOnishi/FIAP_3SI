const config = require("../config/databaseConfig");

function mountPaginationHeaders(res, result) {
  if (result.page) {
    res.header("page", result.page).header("total", result.total).header("perPage", config.listPerPage);
  }
}

module.exports = {
  mountPaginationHeaders
}