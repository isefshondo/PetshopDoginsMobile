# Petshop Dogin's Mobile 🐶💙
Dogin's é um petshop online com um design AUUdacioso 🐶💙 Nele, você pode visualizar produtos em destaque na Home, ver mais detalhes do seu produto favorito e adicionar ao carrinho! É claro, você também pode comprar os produtos mais AUUdacioso para seu pet 💙💙💙

### Bora conhecer?
<p align="center">
  <img src="https://github.com/isefshondo/PetshopDoginsMobile/assets/85968113/8525146f-cf99-4990-b1a6-38fb7c270f33" width="800" height="" alt="imagens interfaces">
</p>

<p align="center">
  <img src="https://github.com/isefshondo/petshopDogins/assets/85968113/4abe3b7d-6bc7-4bbc-b77a-11c1df1f7de9" width="250" height="" alt="imagens interfaces">
  <img src="https://github.com/isefshondo/petshopDogins/assets/85968113/9ea32c10-bed2-4558-acf0-a6b3cbf73b13" width="250" height="" alt="imagens interfaces">
  <img src="https://github.com/isefshondo/petshopDogins/assets/85968113/fd1330f7-d3eb-46e8-867f-c06fda6cd4b3" width="250" height="" alt="imagens interfaces">
</p>

<h6 align="center">(Imagens do Protótipo da Interface)</h6>

###### Descrição
<p> O projeto consiste em um ecommerce versão mobile desenvolvido no framework Kotlin. O app permite a compra de um produto, fazendo comunicação direta com o banco de dados em MongoDb do ecommerce Web por meio de uma API em Java Spring Boot. Para o consumo da API na aplicação Kotlin foi utilizado o client do Retrofit para chamar os endpoints de comunicação. </p><br>

<br> Opa, o Dogin's tem a <strong> 💙 versão Web 💙 </strong> mais AUUdaciosa que já se viu, [venha conhecer](https://github.com/isefshondo/petshopDogins) 🐶💙

###### Scrum Agile
<aside>Este projeto tem como intuito colocar em prática a metodologia Scrum, uma abordagem ágil de gerenciamento de projetos que se baseia em sprints, 
reuniões diárias e retrospectivas para entregar um produto de alta qualidade de forma eficiente e eficaz.</aside>

## Estrutura de Arquivos 🐶💙

<li><strong>📁 app/</strong>:  Diretório contendo a implementação do E-commerce.</li><br>
<li><strong>📁 config/</strong>: Contém o arquivo responsável por estabelecer a conexão com o banco de dados utilizado pela API.</li><br>

```
📁 config/  
   ├── 📁 composer/     <!-- Gerenciador de depêndencias para manipulação do MongoDB com PHP -->
   ├── 📄 conn.php      <!-- Arquivo de conexão com o banco de dados -->
   ├── 📄 products.json <!-- Exportação dos documentos da coleção 'products' -->
   └── 📄 users.php     <!-- Exportação dos documentos da coleção 'users' -->
```


## Como rodar este projeto? 🐶💙

### Requisitos de Software 🐶💙

<li>MongoDB</li>
<li>Java SDK 17</li>
<li>Android Studio</li>
<li>Plugin do Kotlin</li>

### Dependências 🐶💙

Este projeto depende da seguinte API:

* [Dogins Mobile API](https://github.com/mandis-ncs/dogins_api)
<br>

### Configurando o MongoDB 🐶💙
É recomendado que a máquina tenha o MongoDB Compass instalado. Após rodar a API Dogins, uma nova coleção deverá ser criada automaticamente com o nome `dogin`. Para mais informações, acesse o repositório indicado anteriormente em Dependências.

### Play no app 🐶💙
1. <p>Clone os seguintes repositórios em seu computador utilizando o comando:</p>
Aplicativo Kotlin:
```
git clone https://github.com/isefshondo/PetshopDoginsMobile.git
```
API Spring Boot:
```
git clone https://github.com/mandis-ncs/dogins_api.git
```

2. Abra o projeto pelo Android Studio

3. Certifique-se de que o JDK está instalado e configurado corretamente

4. Certifique-se de ter realizado a configuração correta do MongoDB

5. Abra a API Dogins pelo VS Code ou IntelliJ, certifique-se de iniciar a API que estará rodando em `http://localhost:8080` durante a execução do app android. Para mais informações de como rodar a API, acesse seu repositório.

6. Execute o Emulador do Android Studio


## Problemas Conhecidos 🐶💙

### Erro de Caracteres Não-ASCII 

Se você encontrar um erro relacionado a caracteres não-ASCII durante a execução ou compilação do projeto, existem duas soluções possíveis:

1. **Mover o projeto para um diretório diferente**: Certifique-se de que o novo diretório não contém caracteres não-ASCII no caminho.

2. **Adicionar uma linha ao arquivo gradle.properties**: Você pode adicionar a linha 'android.overridePathCheck=true' ao arquivo gradle.properties no diretório do projeto. Isso desativará a verificação do caminho do projeto.
<br>

## User Interface (UI) 🐶💙
A interface do usuário deste aplicativo foi construída usando **Jetpack Compose** e **Material 3**.

O Jetpack Compose é uma moderna toolkit de UI para Android que simplifica e acelera o desenvolvimento da interface do usuário. Ele permite a criação de interfaces de usuário concisas e idiomáticas com menos código e ferramentas poderosas para visualização de layout.

<div>O Material 3 é a mais recente versão do Material Design, que introduz novos componentes, estilos e recursos para ajudar a criar experiências de usuário mais expressivas e dinâmicas.
<br> </div>


## Nosso Team AUUdacioso 🐶💙
You can see more about us in our profile:
* [Isabelle](https://github.com/isefshondo)
* [Amanda](https://github.com/mandis-ncs)
* [Junior](https://github.com/aasjunior)
* [Elizama](https://github.com/Eliz-ama)
* [Nayara](https://github.com/NahAzevedo)
* André
* Eliana

###### Aviso
Esta é uma iniciativa acadêmica, sendo assim, não possui todas as funcionalidades e características de uma aplicação real.
