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


    var idIndicador = ["3.1.1","3.1.2","3.2.1","3.2.2","3.3.1","3.3.2","3.3.3","3.3.4","3.3.5","3.4.1","3.4.2","3.5.1","3.5.2","3.6.1","3.7.1","3.7.2","3.8.1","3.8.2","3.9.1","3.9.2","3.9.3","3.a.1","3.b.1","3.b.2","3.b.3","3.c.1","3.d.1"];

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[0], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[0]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toHaveProperty('numCategoria');
                expect(dado).toHaveProperty('numDado');
                expect(dado).toHaveProperty('vlX');
                expect(dado).toHaveProperty('vlY');
        })        

    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[1], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[1]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toHaveProperty('numCategoria');
                expect(dado).toHaveProperty('numDado');
                expect(dado).toHaveProperty('vlX');
                expect(dado).toHaveProperty('vlY');
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[2], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[2]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toHaveProperty('numCategoria');
                expect(dado).toHaveProperty('numDado');
                expect(dado).toHaveProperty('vlX');
                expect(dado).toHaveProperty('vlY');
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[3], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[3]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toHaveProperty('numCategoria');
                expect(dado).toHaveProperty('numDado');
                expect(dado).toHaveProperty('vlX');
                expect(dado).toHaveProperty('vlY');
        })
    })
    
    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[4], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[4]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body.observacao).toBeNull()
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body.nmColunaX).toBeNull()
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body.nmColunaY).toBeNull()
        expect(response.body).toHaveProperty('dados');
        
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toBeNull();
                expect(dado.length).toBe(0);
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[5], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[5]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toHaveProperty('numCategoria');
                expect(dado).toHaveProperty('numDado');
                expect(dado).toHaveProperty('vlX');
                expect(dado).toHaveProperty('vlY');
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[6], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[6]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toHaveProperty('numCategoria');
                expect(dado).toHaveProperty('numDado');
                expect(dado).toHaveProperty('vlX');
                expect(dado).toHaveProperty('vlY');
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[7], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[7]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toHaveProperty('numCategoria');
                expect(dado).toHaveProperty('numDado');
                expect(dado).toHaveProperty('vlX');
                expect(dado).toHaveProperty('vlY');
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[8], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[8]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toHaveProperty('numCategoria');
                expect(dado).toHaveProperty('numDado');
                expect(dado).toHaveProperty('vlX');
                expect(dado).toHaveProperty('vlY');
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[9], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[9]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toHaveProperty('numCategoria');
                expect(dado).toHaveProperty('numDado');
                expect(dado).toHaveProperty('vlX');
                expect(dado).toHaveProperty('vlY');
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[10], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[10]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toHaveProperty('numCategoria');
                expect(dado).toHaveProperty('numDado');
                expect(dado).toHaveProperty('vlX');
                expect(dado).toHaveProperty('vlY');
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/feito' + idIndicador[11], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[11]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body.observacao).toBeNull()
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body.nmColunaX).toBeNull()
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body.nmColunaY).toBeNull()
        expect(response.body).toHaveProperty('dados');
        
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toBeNull();
                expect(dado.length).toBe(0);
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[12], async () => {     
           
        const response = await request(app).get('/indicador/' + idIndicador[12]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toHaveProperty('numCategoria');
                expect(dado).toHaveProperty('numDado');
                expect(dado).toHaveProperty('vlX');
                expect(dado).toHaveProperty('vlY');
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[13], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[13]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toHaveProperty('numCategoria');
                expect(dado).toHaveProperty('numDado');
                expect(dado).toHaveProperty('vlX');
                expect(dado).toHaveProperty('vlY');
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/certo' + idIndicador[14], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[14]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body.observacao).toBeNull()
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body.nmColunaX).toBeNull()
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body.nmColunaY).toBeNull()
        expect(response.body).toHaveProperty('dados');
        
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toBeNull();
                expect(dado.length).toBe(0);
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[15], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[10]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toHaveProperty('numCategoria');
                expect(dado).toHaveProperty('numDado');
                expect(dado).toHaveProperty('vlX');
                expect(dado).toHaveProperty('vlY');
        })
    })
    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/feito' + idIndicador[16], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[16]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body.observacao).toBeNull()
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body.nmColunaX).toBeNull()
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body.nmColunaY).toBeNull()
        expect(response.body).toHaveProperty('dados');
        
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toBeNull();
                expect(dado.length).toBe(0);
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[17], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[19]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toHaveProperty('numCategoria');
                expect(dado).toHaveProperty('numDado');
                expect(dado).toHaveProperty('vlX');
                expect(dado).toHaveProperty('vlY');
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/feito' + idIndicador[18], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[18]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body.observacao).toBeNull()
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body.nmColunaX).toBeNull()
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body.nmColunaY).toBeNull()
        expect(response.body).toHaveProperty('dados');
        
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toBeNull();
                expect(dado.length).toBe(0);
        })
    })
    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[19], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[19]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toHaveProperty('numCategoria');
                expect(dado).toHaveProperty('numDado');
                expect(dado).toHaveProperty('vlX');
                expect(dado).toHaveProperty('vlY');
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[20], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[20]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body).toHaveProperty('dados');
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toHaveProperty('numCategoria');
                expect(dado).toHaveProperty('numDado');
                expect(dado).toHaveProperty('vlX');
                expect(dado).toHaveProperty('vlY');
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/feito' + idIndicador[21], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[21]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body.observacao).toBeNull()
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body.nmColunaX).toBeNull()
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body.nmColunaY).toBeNull()
        expect(response.body).toHaveProperty('dados');
        
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toBeNull();
                expect(dado.length).toBe(0);
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[22], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[22]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body.observacao).toBeNull()
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body.nmColunaX).toBeNull()
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body.nmColunaY).toBeNull()
        expect(response.body).toHaveProperty('dados');
        
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toBeNull();
                expect(dado.length).toBe(0);
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[23], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[23]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body.observacao).toBeNull()
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body.nmColunaX).toBeNull()
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body.nmColunaY).toBeNull()
        expect(response.body).toHaveProperty('dados');
        
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toBeNull();
                expect(dado.length).toBe(0);
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[24], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[24]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body.observacao).toBeNull()
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body.nmColunaX).toBeNull()
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body.nmColunaY).toBeNull()
        expect(response.body).toHaveProperty('dados');
        
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toBeNull();
                expect(dado.length).toBe(0);
        })
    })
    
    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[25], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[25]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body.observacao).toBeNull()
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body.nmColunaX).toBeNull()
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body.nmColunaY).toBeNull()
        expect(response.body).toHaveProperty('dados');
        
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toBeNull();
                expect(dado.length).toBe(0);
        })
    })

    test('A API retorna todas as propriedades estabelecidas para todos os Indicador/' + idIndicador[26], async () => {        
        const response = await request(app).get('/indicador/' + idIndicador[26]);
        //verificar o status code da url
        expect(response.statusCode).toBe(200);
        // Verificar as propriedades principais do body da API
        expect(response.body).toHaveProperty('codMeta');
        expect(response.body).toHaveProperty('codIndicador');
        expect(response.body).toHaveProperty('descricao');
        expect(response.body).toHaveProperty('observacao');
        expect(response.body.observacao).toBeNull()
        expect(response.body).toHaveProperty('nmColunaX');
        expect(response.body.nmColunaX).toBeNull()
        expect(response.body).toHaveProperty('nmColunaY');
        expect(response.body.nmColunaY).toBeNull()
        expect(response.body).toHaveProperty('dados');
        
      
        // Verificar as propriedades dentro do array 'dados'
        response.body.dados.forEach(dado => {            
                expect(dado).toBeNull();
                expect(dado.length).toBe(0);
        })
    })

    test('A API mensagem BadRequest caso o Indicador não exista', async () => {
        var id = '3.1.5';
        const response = await request(app).get('/indicador/'+ id);

        expect(response.statusCode).toBe(404);
        expect(response.text).toBe('Indicador inexistente');
    })

})






