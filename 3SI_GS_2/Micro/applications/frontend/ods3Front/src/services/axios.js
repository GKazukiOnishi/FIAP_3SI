import axios from "axios";

export const ods3Service = axios.create({
  baseURL: "http://localhost:3000/",
});
