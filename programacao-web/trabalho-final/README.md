# [AN34A-N14] Programação Web

Seguem nesse repositório as instruções para a entrega do trabalho final da disciplina Programação Web [AN34A-N14]

Este trabalho tem por objetivo testar as principais habilidades do aluno com relação ao mercado de trabalho. Para isso, dividimos o trabalho final em duas etapas.

1. Desenvolvimento do Back-End;
2. Desenvolvimento do Front-End;

O __Back-End__ compreende toda a regra de negócios da aplicação implementada no lado do servidor. Já o __Front-End__ diz respeito as implementações que serão exibidas no navegador do usuário, ou seja, toda a interface que enviará os dados para o servidor.

Todo o projeto deverá ser feito de forma colaborativa em equipes.

Cada equipe deverá desenvolver a regra de negócios da sua aplicação __Back-End__ e uma outra equipe desenvolverá a interface de seu aplicativo.

O __Back-End__ poderá ser desenvolvido em PHP ou NodeJS. Com os padrões mínimos vistos durante a disciplina: Templates, Roteamento, MVC;

Deve-se preencher o seguinte documento com as equipes e suas relações:

https://docs.google.com/spreadsheets/d/1TJeV0tXWeejdk9ZLIfbkDtlTFYVDtTlMzb7tvxdpgwM/edit?usp=sharing

Cada equipe deve identificar qual será a outra equipe que irá construir seu __Front-End__;

O número de equipes obviamente deve ser par, e cada equipe deverá desenvolver apenas o __Front-End__ de uma outra equipe;

# Como deve ser entregue?

## Individual

1. Preencha **CORRETAMENTE** nome, email, biografia, company (utilizem @seugrupo), location e foto do perfil do GitHub;

## Grupo

1. Alguém do grupo deve cria uma __nova organização__, como se fosse a empresa a desenvolver o aplicativo em questão;
2. Essa organização deve possuir também: nome, email, e foto do perfil;
3. Adicione os membros da equipe na organização;

# Criando os Repositórios

1. Crie um repositório para o __Front-End__ a ser desenvolvido pela outra equipe;
2. Crie um repositório para o __Back-End__ a ser desenvolvido por vocês;

Lembrando que a equipe que for desenvolver o __Front-End__ deverá enviar os arquivos via **pull-request** pela pasta respectiva designada ao __Front-End__;

No repositório de __Front-End__ deverão ser enviados apenas:

+ HTML
+ CSS
+ JavaScript
+ Assets (imagens, svgs, etc...)

Todos os membros do grupo deverão fazer commits no repositório destinado a regra de negócios da aplicação.

# Entrega dos Protótipos de Tela

Todas equipes deverão criar um documento com os protótipos de todas as telas que deverão ser implementadas pela equipe parceira.

Neste documento deve-se criar:

1. Wireframe de __TODAS__ as telas a serem desenvolvidas;
2. Descrição detalhadas de cada um dos campos, funcionalidades e validações dos formulários;
3. Entrega do nome/logo a ser utilizado pela equipe em SVG;

Este documento deverá ser entregue impresso, e será conferido pelo professor no dia da entrega.

# Tecnologias a Serem Apresentadas

Todas as equipes deverão apresentar no mínimo o trabalho contendo as seguintes tecnologias:

## Front-End

+ CSS3;
	+ Utilização de Bootstrap para melhorar a compatibilidade e responsividade;
	+ Todo o CSS deve ser escrito em __SASS__ e compilado para CSS;
	+ Animações;
	+ Houvers;
	+ Pseudo-seletores;
	+ Utilização das estruturas modernas: Flex ou Grid;
+ HTML5;
	+ Organização Corretas dos Blocos com os novos elementos do HTML5;
	+ MetaTags;
	+ FavIcon;
	+ Otimizações para SEO;
+ JavaScript;
	+ Validação dos campos e formulários;
	+ Efeitos e animações da página;
	+ Utilização de AJAX para interações com o servidor;
	+ Estão liberados frameworks front-end: Angular, React, Vue.JS;
+ SVG;
	+ Ícones em SVG;
+ Gulp;
	+ Utilizado para compilar o SASS;
	+ Utilizado para minificar o CSS;
	+ Utilizado para minificar os JS;

Podem utilizar templates de HTML e Painéis Administrativos para agilizar o desenvolvimento; (MAS CUIDADO, DEVE-SE ADAPTAR AS NECESSIDADES DO APLICATIVO A SER DESENVOLVIDO).

## Back-End

+ Organização das Rotas;
+ Organização dos Templates (se for aplicável);
+ Acesso a banco de dados;
	+ Organização Orientada a Objetos;
	+ Utilização de Bibliotecas externas com Composer ou NPM;
	+ MVC;
	+ Utilização livre de Frameworks;

## DICAS

A grande ideia deste trabalho é fornecer uma base para entendimento de como funciona a integração entre __Front-End__ e __Back-End__;

Por isso é interessante que:

Ao desenvolver o __Back-End__ a equipe tente ao máximo trabalhar com as tecnologias __RESTFULL__ na qual o que são retornados são paneas JSONS (a serem tratados no __Front-End__)

A integração entre __Front-End__ e __Back-End__ será de responsabilidade da equipe que fará o __Back-End__

# Cronograma

A seguir define-se um cronograma para a realização das tarefas.

+ 21/05/2018 - Entrega dos Protótipos de Tela;
+ 05/06/2018 - Apresentação do Andamento;
+ 12/06/2018 - Apresentação Final;
+ 18/06/2018 - Apresentação Final;

A apresentação será por ordem dos grupos definidos no documento citado anteriomente.

# Entrega do Front-End

+ Todo o projeto deve utilizar o Framework CSS Bootstrap (ou outro framework correpondente);
+ Utilizem o sistema de grids para tornar o sistema responsivo;
+ Trabalhem com cuidado o menu, para ser adaptável a celulares;
+ Pode-se utilizar plugins JQuery para melhorar os efeitos visuais;
+ O Front-End deverá ser apresentado para o professor;
+ As possíveis correções deverão se feitas e re-enviadas por pull-request para a outra equipe;

# Apresentação do Andamento

Deve-se apresentar como está o andamento do projeto. O que já foi implementado, o que já foi integrado com o __Front-End__ e quais são as funcionalidades que devem ser desenvolvidas.

# Entrega Final

Apresentação para a Turma do Aplicativo Desenvolvido;

+ Apresentação de 15 minutos;
+ Todos Integrantes devem falar;
+ Apresentação das funcionalidades do programa;
+ Apresentação dos códigos fonte;
+ O que será avaliado?
	+ Objetividade com relação as explicações;
	+ Tempo suficiente para apresentação de todo o conteúdo;
	+ Postura e desinvoltura na apresentação;
	+ Respostas as possíveis perguntas;
	+ Design e aparência do software;
	+ Usabilidade do software;
	+ Estruturação do Código;
	+ Indentação;
	+ Comentários e anotações;
	+ Documentação;
	+ Estrutura de Pastas e Arquivos;
	+ Fidelidade aos padrões de projetos escolhidos;