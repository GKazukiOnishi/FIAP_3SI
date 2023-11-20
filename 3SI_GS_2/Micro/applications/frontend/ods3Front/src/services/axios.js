import axios from "axios";

export const ods3Service = axios.create({
  baseURL: "http://localhost:3000/",
});

export const get = async (path, config) => {
  const response = await ods3Service.get(path, config);
  return response?.data;
};
