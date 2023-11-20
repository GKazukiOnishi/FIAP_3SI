import { get } from "./axios";

export const getIndicadores = async () => {
  const indicadores = await get("/indicador");
  return indicadores;
};

export const getIndicador = async (codIndicador) => {
  const indicador = await get(`/indicador/${codIndicador}`);
  return indicador;
};
