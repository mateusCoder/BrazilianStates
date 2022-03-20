<h1> Brazilian States API </h1>

API REST de todos os estados brasileiros e seus respectivos nomes, regiões, populações, capitais e areas.  
Endpoints desenvolvidos: <br>

- **POST**: /api/states
- **GET**: /api/states
- **GET**: /api/states/{id}
- **PUT**: /api/states/{id}
- **DELETE**: /api/states/{id}

O Endpoint **GET** possui os seguintes filtros:
- Filtrar os estados por região.
- Ordenar os estados com maior população.
- Ordenar os estados com a maior área.

<h3> Swagger </h3>

A pasta contém o arquivo BrazilianStatesApi de extensão yaml, com toda a documentação da API desenvolvida por meio do Swagger Editor. Para utilizar basta iniciar a aplicação por meio de uma IDE com suporte a Spring Boot no endereço: http://localhost:8080/ e inserir o código yaml no swagger editor, após isso os endpoints estarão disponiveis para uso. 

<h3> Postman </h3>

A pasta contém o arquivo BrazilianStatesRequests de extensão JSON, com as possiveis requests e tratamentos de erros desenvolvidos para a aplicação. Se preferir, é possível acessar o postman com as resquests pelo link da [workspace](https://app.getpostman.com/join-team?invite_code=83648d2e48c847a13eda852c3ffae191&target_code=4aa1ae8c811317facf32cd3dc347e7a9).

<h3> Fontes </h3>

[Estados do Brasil](https://brasilescola.uol.com.br/brasil/estados-brasil.htm)<br>

[Cidades e Estados](https://www.ibge.gov.br/cidades-e-estados)<br>

[Lista de unidades federativas do Brasil por população](https://pt.wikipedia.org/wiki/Lista_de_unidades_federativas_do_Brasil_por_popula%C3%A7%C3%A3o)<br>
