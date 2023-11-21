import http from 'k6/http';
import { sleep } from 'k6';
import {Trend, Rate, Counter} from 'k6/metrics';

export let GetIndicadorDuration = new Trend('get_indicador_duration');
export let GetIndicadorFailRate = new Rate('get_indicador_fail_rate');
export let GetIndicadorSuccessRate = new Rate('get_indicador_success_rate');
export let GetIndicadorReqs = new Rate('get_indicador_reqs');

export const options = {
    vus: 10,
    duration: '10s',
};

export default function () {
    let res = http.get('http://localhost:3000/indicador');
    
    GetIndicadorDuration.add(res.timings.duration);
    GetIndicadorReqs.add(1);
    GetIndicadorFailRate.add(res.status == 0 || res.status > 399);
    GetIndicadorSuccessRate.add(res.status < 399);
    
    sleep(1);
}