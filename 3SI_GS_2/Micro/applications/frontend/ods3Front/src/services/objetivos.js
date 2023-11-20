import { ods3Service } from "./axios";

export const getObjetivos = async () => {
  const response = await ods3Service.get("/objetivos");
  console.log(response);
};
