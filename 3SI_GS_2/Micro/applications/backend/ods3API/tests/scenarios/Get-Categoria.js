import http from 'k6/http';
import { sleep } from 'k6';
import {Trend, Rate, Counter} from 'k6/metrics';

export let GetCategoriaDuration = new Trend('get_categoria_duration');
export let GetCategoriaFailRate = new Rate('get_categoria_fail_rate');
export let GetCategoriaSuccessRate = new Rate('get_categoria_success_rate');
export let GetCategoriaReqs = new Rate('get_categoria_reqs');

export const options = {
    vus: 10,
    duration: '10s',
}

export default function () {
    let res = http.get('http://localhost:3000/categorias');

    GetCategoriaDuration.add(res.timings.duration);
    GetCategoriaReqs.add(1);
    GetCategoriaFailRate.add(res.status == 0 || res.status > 399);
    GetCategoriaSuccessRate.add(res.status < 399);

    sleep(1);
}