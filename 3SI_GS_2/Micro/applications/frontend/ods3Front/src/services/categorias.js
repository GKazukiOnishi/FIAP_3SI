import { get } from "./axios";

export const getCategorias = async () => {
  const categorias = await get("/categorias");
  return categorias;
};
