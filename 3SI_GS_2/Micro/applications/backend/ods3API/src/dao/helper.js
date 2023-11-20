const config = require("../config/databaseConfig");

function getOffsetQuery(page, listPerPage = config.listPerPage) {
  if (page) {
    return `LIMIT ${getOffset(page, listPerPage)},${listPerPage}`;
  }
  return "";
}

function getOffset(currentPage = 1, listPerPage) {
  return (currentPage - 1) * [listPerPage];
}

function emptyOrRows(rows) {
  if (!rows) {
    return [];
  }
  return rows;
}

module.exports = {
  getOffsetQuery,
  getOffset,
  emptyOrRows
}