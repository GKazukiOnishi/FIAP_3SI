const request = require('supertest');
const app = require('../../src/app');

describe("Objetivo Controller", ()=>{

    test('Checa conexão da API de Objetivos', async () => {
        const response = await request(app).get('/objetivos');   
        expect(response.statusCode).toBe(200);
    })    

    test('Verifica se a API retorna todas propriedades estabelecidas para Objetivos', async () => {
        const response = await request(app).get('/objetivos');
        //retorna o status code
        expect(response.statusCode).toBe(200);
        //retorna se é um array que o body está trazendo
        expect(response.body).toBeInstanceOf(Array)
        //verifica se o body tem todas as propriedades
        response.body.forEach(element => {
            expect(element).toHaveProperty('codMeta');
            expect(element).toHaveProperty('objetivos');
            expect(element).toHaveProperty('indicadores');
            element.objetivos.forEach(objetivo => {
                expect(objetivo).toHaveProperty('origem');
                expect(objetivo).toHaveProperty('objetivo');
            })  
            element.indicadores.forEach(objetivo => {
                expect(objetivo).toHaveProperty('codIndicador');
                expect(objetivo).toHaveProperty('descricao');
            })      
        });       
        
      });
   
})

describe("Categoria Controller", ()=>{

    test('Checa conexão da API de Categoria', async () => {
        const response = await request(app).get('/categorias');   
        expect(response.statusCode).toBe(200);
    }) 

    test('Verifica se a API retorna todas propriedades estabelecidas para Categorias', async () => {
        const response = await request(app).get('/categorias');   
        expect(response.statusCode).toBe(200);
        expect(response.body).toBeInstanceOf(Array)
        response.body.forEach(element => {
            expect(element).toHaveProperty('numCategoria');
            expect(element).toHaveProperty('nmCategoria');
            expect(element).toHaveProperty('nivel');
        })
    }) 
})

describe("Indicador Controller", ()=>{
    test('Checa conexão da API de Indicadores', async () => {
        const response = await request(app).get('/indicador');   
        expect(response.statusCode).toBe(200);
        expect(response.body).toBeInstanceOf(Array)
        response.body.forEach(element => {
            expect(element).toHaveProperty('codIndicador');
            expect(element).toHaveProperty('descricao');
        })
    }) 

    test('Verifica se a API retorna todas propriedades estabelecidas para Indicadores', async () => {
        const response = await request(app).get('/indicador');   
        expect(response.statusCode).toBe(200);
        expect(response.body).toBeInstanceOf(Array)
        response.body.forEach(element => {
            expect(element).toHaveProperty('codIndicador');
            expect(element).toHaveProperty('descricao');
        })
    }) 

    test('A API retorna todas as propriedades estabelecidas', async () => {
        const response = await request(app).get('/indicador/3.1.1');
      
        // Verificar as propriedades principais
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        for (const dado of response.body) {
          expect(dado).toHaveProperty('numCategoria');
          expect(dado).toHaveProperty('numDado');
          expect(dado).toHaveProperty('vlX');
          expect(dado).toHaveProperty('vlY');
        }

    })
})






