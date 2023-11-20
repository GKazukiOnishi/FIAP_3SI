import { get } from "./axios";

export const getMetas = async () => {
  const metas = await get("/objetivos");
  return metas;
};
