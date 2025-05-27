# Projeto JavaFX com JDBC

Este projeto tem como objetivo desenvolver uma aplicação JavaFX integrada ao MySQL utilizando JDBC para acesso e manipulação de dados. É projetado para proporcionar uma experiência prática de desenvolvimento, abordando conceitos fundamentais de JavaFX, orientação a objetos, padrões de projeto (DAO e MVC), manipulação de banco de dados e boas práticas de programação.

## Tecnologias Utilizadas

* **JavaFX:** Para a criação da interface gráfica interativa e responsiva.
* **JDBC (Java Database Connectivity):** Para a comunicação com o banco de dados MySQL.
* **MySQL:** Banco de dados relacional utilizado para armazenar e gerenciar as informações.
* **DAO (Data Access Object):** Padrão utilizado para separação da lógica de acesso aos dados.
* **Java:** Linguagem de programação principal para a implementação do projeto.
* **Git:** Controle de versão para gerenciar o código-fonte.

## Objetivos do Projeto

1. **Desenvolver uma aplicação desktop utilizando JavaFX.**

   * Aplicação responsável por gerenciar informações de vendedores e departamentos.
2. **Implementar a conexão com banco de dados MySQL via JDBC.**

   * Realizar operações CRUD (Create, Read, Update, Delete).
3. **Aplicar padrões de projeto e boas práticas de programação.**

   * Seguir o padrão DAO para acesso aos dados.
   * Utilizar padrão MVC (Model-View-Controller) para organização do código.
4. **Criar um sistema modular e escalável.**

   * Integração fácil com novos módulos e funcionalidades.

## Funcionalidades Principais

1. **Interface de Usuário:**

   * Menu de navegação com opções para "Sellers" (Vendedores) e "Departments" (Departamentos).
   * Design intuitivo e responsivo utilizando arquivos FXML.

2. **Operações CRUD:**

   * **Create:** Adicionar novos vendedores e departamentos.
   * **Read:** Visualizar listas e detalhes de vendedores e departamentos.
   * **Update:** Atualizar informações existentes.
   * **Delete:** Remover registros do banco de dados com confirmação de usuário.

3. **Validações:**

   * Validação de campos obrigatórios e tipos de dados.
   * Exibição de mensagens de erro claras e objetivas para o usuário.

4. **Interação com Banco de Dados:**

   * Integração com MySQL para armazenamento e recuperação de dados.
   * Consulta eficiente de informações utilizando o padrão DAO.

5. **Customização e Expansão:**

   * Capacidade de adicionar novos campos ou módulos conforme necessário.

## Estrutura do Projeto

1. **Camada de Apresentação (View):**

   * Arquivos FXML para criar a interface.
   * Controle de eventos em arquivos de controlador dedicados.

2. **Camada de Negócio (Model):**

   * Entidades como `Department` e `Seller`.
   * Validação de regras de negócio.

3. **Camada de Dados (DAO):**

   * Classe de conexão com banco de dados.
   * Implementação das operações CRUD.

## Requisitos

* Conhecimento em:

  * **Orientação a Objetos**
  * **Expressões Lambda**
  * **JDBC**
  * **JavaFX**
* Ambiente de desenvolvimento configurado com:

  * JDK 17+.
  * JavaFX SDK.
  * MySQL Server.

## Contribuição

Este projeto segue boas práticas de desenvolvimento colaborativo. Contribuições são bem-vindas e podem ser feitas via Pull Requests no repositório oficial.

