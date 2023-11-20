const request = require('supertest');
const app = require('../../src/app');

describe("Objetivo Controller", ()=>{
    test('Checa conexão da API', async () => {
        const response = await request(app).get('/objetivos');   
        expect(response.statusCode).toBe(200);
    })    

    test('Verifica se a API retorna todas propriedades estabelecida', async () => {
        const response = await request(app).get('/objetivos');
        expect(response.statusCode).toBe(200);
        expect(response.body).toBeInstanceOf(Array)
        expect(response.body[0]).toHaveProperty('codMeta')
        response.body.forEach(element => {
            expect(element).toHaveProperty('codMeta');
            expect(element).toHaveProperty('objetivos');
            expect(element).toHaveProperty('indicadores');
            element.objetivos.forEach(objetivo => {
                expect(objetivo).toHaveProperty('origem');
                expect(objetivo).toHaveProperty('objetivo');
            })      
        });       
        
      });
   
})

