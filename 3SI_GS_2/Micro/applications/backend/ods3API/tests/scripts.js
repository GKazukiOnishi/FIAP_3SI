import GetObjetivo from "./scenarios/Get-Objetivo.js";
import GetIndicador from "./scenarios/Get-Indicador.js"; 
import GetCategoria from "./scenarios/Get-Categoria.js"; 
import {group, sleep} from "k6";

export const options = {
    vus: 10,
    duration: '10s',
  };

export default function () {
    group('Endpoint Get Objetivo - Controller Categoria - API', () => {
        GetObjetivo();
    });
    sleep(1);

    group('Endpoint Get Categoria - Controller Categoria - API', () => {
        GetCategoria();
    });
    sleep(1);
    
    group('Endpoint Get Indicador - Controller Categoria - API', () => {
        GetIndicador();
    });
    sleep(3);
}