import http from 'k6/http';
import { sleep } from 'k6';
import {Trend, Rate, Counter} from 'k6/metrics';

export let GetObjetivoDuration = new Trend('get_objetivo_duration');
export let GetObjetivoFailRate = new Rate('get_objetivo_fail_rate');
export let GetObjetivoSuccessRate = new Rate('get_objetivo_success_rate');
export let GetObjetivoReqs = new Rate('get_objetivo_reqs');

export const options = {
  vus: 10,
  duration: '10s',
};

export default function () {
  let res = http.get('http://localhost:3000/objetivos');

  GetObjetivoDuration.add(res.timings.duration);
  GetObjetivoReqs.add(1);
  GetObjetivoFailRate.add(res.status == 0 || res.status > 399);
  GetObjetivoSuccessRate.add(res.status < 399);


  sleep(1);
}