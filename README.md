# 📚 Gerenciador de Livros

Aplicativo Android desenvolvido como parte da atividade **AC2 – Mobile**, com o objetivo de gerenciar uma coleção de livros utilizando operações CRUD e integração com Firebase Cloud Firestore.

## 🎯 Objetivo do Projeto

Desenvolver um aplicativo mobile que permita ao usuário cadastrar, visualizar, editar, excluir e organizar livros, com armazenamento persistente em banco de dados na nuvem.

## 🛠️ Tecnologias Utilizadas

- **Java:** linguagem utilizada no desenvolvimento da aplicação.
- **XML:** criação das interfaces gráficas.
- **Firebase Cloud Firestore:** banco de dados NoSQL para armazenamento das informações.
- **RecyclerView:** componente utilizado para exibição dos livros.
- **Android Studio:** ambiente de desenvolvimento.

## 📱 Funcionalidades

- **Cadastrar livros:** permite adicionar novos livros informando seus dados.
- **Listar livros:** exibe os livros cadastrados na tela principal.
- **Editar livros:** permite alterar as informações de um livro selecionado.
- **Excluir livros:** permite remover livros cadastrados, com confirmação da ação.
- **Buscar livros:** realiza pesquisas pelo título.
- **Filtrar por gênero:** permite visualizar livros de determinados gêneros.
- **Favoritar livros:** possibilita marcar livros como favoritos.

## 🗂️ Estrutura do Projeto

```text
app/
├── java/
│   └── com.example/
│       ├── MainActivity.java
│       ├── Livro.java
│       └── LivroAdapter.java
│
├── res/
│   ├── layout/
│   │   ├── activity_main.xml
│   │   └── item_livro.xml
│   │
│   ├── drawable/
│   └── values/
│
└── AndroidManifest.xml
```

## 🔥 Banco de Dados – Firebase

O projeto utiliza o **Cloud Firestore** para armazenar os dados dos livros.

A coleção utilizada é:

`livros`

Cada documento representa um livro cadastrado e armazena suas respectivas informações.

Os dados são mantidos na nuvem, permitindo que as operações realizadas no aplicativo sejam persistidas no banco de dados.

## ⚙️ Como Executar o Projeto

1. Clone ou baixe este repositório.
2. Abra o projeto no Android Studio.
3. Configure um projeto no Firebase Console.
4. Adicione o aplicativo Android ao projeto Firebase.
5. Baixe o arquivo `google-services.json`.
6. Coloque o arquivo na pasta `app/` do projeto.
7. Habilite o Cloud Firestore no Firebase Console.
8. Sincronize o Gradle.
9. Execute o aplicativo em um emulador ou dispositivo Android.

## 💡 Funcionamento

O aplicativo permite gerenciar livros por meio de uma interface simples e intuitiva.

As operações de cadastro, edição e exclusão são integradas ao Firebase Cloud Firestore. A listagem utiliza RecyclerView para apresentar os registros, enquanto os recursos de busca, filtros e favoritos facilitam a organização da coleção.

## 🎓 Contexto Acadêmico

Projeto desenvolvido para a disciplina de **Mobile**, como parte da atividade avaliativa AC2 da UniFacens.

**Desenvolvimento:** Ana Laura Biagio de Oliveira 248706 e Miguel Zardetto Carrilho 251744
