# Projeto Blog Pessoal - Backend

<h2>1. Diagrama de Classes</h2> 

O diagrama abaixo representa a estrutura do projeto Blog Pessoal:

<div align="center"><img src="https://i.imgur.com/G71SCJ0.png" title="source: imgur.com" /></div>

<br />

O projeto é composto por 3 recursos principais e uma classe auxiliar:

| Classe           | Descrição                                                    |
| ---------------- | ------------------------------------------------------------ |
| **Postagem**     | Recurso responsável por definir Objeto Postagem (posts) do Blog Pessoal |
| **Tema**         | Recurso responsável por classificar as postagens através do Objeto Tema |
| **Usuario**      | Recurso responsável por definir o Objeto Usuário, que poderá acessar e criar postagens no Blog Pessoal |
| **UsuarioLogin** | Classe auxiliar, que será utilizada para efetuar login no Blog Pessoal |


Cada recurso será mapeado como uma tabela no banco de dados da aplicação. A classe auxiliar não gerará uma tabela no banco de dados, pois ela será utilizada apenas como uma classe auxiliar para a implementação da segurança da aplicação.

<h2>2. Diagrama de Entidade e Relacionamentos</h2>

O diagrama abaixo representa o modelo de entidade e relacionamentos do projeto Blog Pessoal:

<div align="center"><img src="https://i.imgur.com/zmzehFU.png" title="source: imgur.com" /></div>

Antes de começar a criar as classes, vamos configurar o nosso projeto Spring Boot no Spring Initializr dentro do STS e configurar o banco de dados da aplicação.


<h2>3. Como executar o Projeto Blog Pessoal</h2>

### Pré-requisitos

Certifique-se de que você tenha o seguinte instalado em seu sistema:

       [Spring Tool Suite 4], [MySQL]

***
<h3>👣 Passo 1: Clonar o Repositório</h3>

Abra um terminal ou prompt de comando. <br/>
Navegue até o diretório onde você deseja clonar o repositório. <br/>
Execute o seguinte comando para clonar o repositório:

```
git clone https://github.com/RitaAlmeidah/ContaBancaria.git
```

Aguarde até que o processo de clonagem seja concluído.

***
<h3>👣 Passo 2: Configuração do Projeto Spring Boot</h3>

Para iniciar o projeto Spring Boot, siga os passos abaixo:

1. Acesse o Spring Initializr (https://start.spring.io/) no seu navegador.
2. Configure as seguintes opções:
   - Project: Spring Boot
   - Language: Java
   - Spring Boot: (versão desejada)
   - Group: com.generation.blogpessoal
   - Artifact: blogpessoal
   - Packaging: Jar
   - Java: (versão desejada)
   - Dependencies: Spring Web, Spring Data JPA, Spring Boot Dev Tools, Validation, MySQL Driver, Lombok(opcional);
3. Clique no botão "Generate" para baixar o arquivo ZIP contendo o projeto.
4. Importe o projeto ZIP no seu ambiente de desenvolvimento (por exemplo, STS, IntelliJ, etc.).
5. Configure o banco de dados da aplicação de acordo com as necessidades do projeto.

***
<h3>👣 Passo 3: Executar o projeto Spring a partir da Classe principal:</h3>

1. No **STS**, na **Package Explorer**, clique na pasta **src/main/java** e na sequência clique no pacote principal **com.generation.blogpessoal**.
2. Clique com o botão direito do mouse sobre o arquivo **BlogpessoalApplication.java**.
3. No menu que será aberto, clique na opção **Run AS 🡪 Spring Boot App**.
   
<br />

***
<h2>Aprendizados</h2>

### Métodos da classe Optional e suas descrições:

| Método                       | Descrição                                                                                                       |
|------------------------------|----------------------------------------------------------------------------------------------------------------|
| `of(T value)`                | Cria um `Optional` com um valor não nulo.                                                                       |
| `ofNullable(T value)`        | Cria um `Optional` com um valor que pode ser nulo.                                                              |
| `empty()`                    | Retorna um `Optional` vazio.                                                                                    |
| `isPresent()`                | Verifica se um valor está presente no `Optional`.                                                              |
| `get()`                      | Retorna o valor presente no `Optional`.                                                                         |
| `orElse(T other)`            | Retorna o valor presente no `Optional`, ou um valor padrão fornecido como parâmetro.                             |
| `orElseGet(Supplier other)`  | Retorna o valor presente no `Optional`, ou executa uma função para obter um valor alternativo.                   |
| `orElseThrow(Exception)`     | Retorna o valor presente no `Optional`, ou lança uma exceção fornecida como parâmetro.                           |
| `map(Function mapper)`       | Transforma o valor presente no `Optional` usando uma função fornecida e retorna um novo `Optional`.             |
| `flatMap(Function mapper)`   | Similar ao `map`, mas a função fornecida retorna um `Optional`. Se o valor presente for vazio, retorna vazio.   |

***

## Autora:

- Rita Almeida(https://github.com/RitaAlmeidah))
