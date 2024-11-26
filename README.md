Tabela FIPE - Aplicação de Análise 🚗
Este repositório contém uma aplicação Spring Boot desenvolvida em Java para realizar consultas e análises utilizando dados da Tabela FIPE. A aplicação consome a API oficial da Tabela FIPE para buscar informações de veículos como marcas, modelos e anos, oferecendo uma base sólida para análises detalhadas.

📋 Funcionalidades
Consultar marcas de veículos disponíveis.
Consultar modelos de veículos por marca.
Consultar anos de fabricação para um modelo específico.
Analisar os dados obtidos diretamente no terminal.
Organizar as consultas de maneira estruturada, utilizando boas práticas com Spring Boot.
🛠️ Tecnologias Utilizadas
Java 17: Linguagem principal do projeto.
Spring Boot: Framework utilizado para criar a aplicação.
Spring Web: Para integração com APIs REST.
Gson: Manipulação de JSON.
Lombok: Para reduzir boilerplate no código.
Maven: Gerenciador de dependências e build.
API Tabela FIPE: Fonte oficial dos dados.
🚀 Como Executar o Projeto
Pré-requisitos
Java 17 ou superior instalado.
Maven configurado no ambiente.
Acesso à internet para consumir os dados da API Tabela FIPE.
Passo a Passo
Clone este repositório:

bash
Copiar código
git clone https://github.com/giovanasilverio/tabelafipe.git
cd tabelafipe
Compile o projeto:

bash
Copiar código
mvn clean install
Execute a aplicação:

bash
Copiar código
mvn spring-boot:run
Acesse a aplicação:

As funcionalidades estão disponíveis no terminal interativo (ou no endpoint REST, caso implementado).
🗂️ Estrutura do Projeto
src/main/java/com/desafio/cursojava:

modelo: Classes de domínio (como Marca, Modelo, Ano).
servico: Camada de serviço responsável por consumir a API da Tabela FIPE.
controlador: Controladores REST (caso necessário).
aplicacao: Classe principal que inicia a aplicação.
src/main/resources:

Arquivos de configuração do Spring Boot, como application.properties.
