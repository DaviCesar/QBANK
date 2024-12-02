# Projeto Bancário em Java (QBANK)

Este é um projeto bancário simples desenvolvido em Java. O objetivo do projeto é implementar funcionalidades básicas de um sistema bancário, como criação de contas, depósitos, saques e consultas de saldo.

## Funcionalidades

Módulo de Contas: 
Aqui o usuário terá a opção de criar contas, visualizá-las, atualizá-las e excluí-las.
 • Módulo de transações: Uma vez criada a conta, o usuário poderá
 realizar diversas transações, como transferências para contas
 próprias, transferências para terceiros e transferências para outros
 bancos.
 • Módulo Empréstimo: 
 Neste módulo o usuário pode solicitar um
 empréstimo anexando todas as informações necessárias e
 preenchendo o formulário correspondente. O sistema calculará o
 valor que o usuário poderá emprestar e o plano de pagamento.
 Além disso, você pode efetuar o pagamento mensal de suas
 parcelas ou agendá-las caso queira o débito automático.
 
Estrutura modular do Sistema Bancário

 • Módulo Cartão de Crédito: 
 Neste módulo o usuário pode solicitar seu cartão de crédito preenchendo o formulário de inscrição. O
 sistema calculará o limite de crédito que o usuário poderá acessar. Assim que o cartão for aprovado, o usuário poderá
 realizar compras e também terá a opção de pagar manualmente a dívida ou agendar pagamentos caso queira o débito automático.
 
 • Módulo de Pagamento de Serviços: 
 Este módulo permitirá ao usuário efetuar pagamentos de serviços externos, como
 mensalidades universitárias, despesas de gerais ou serviços telefônicos, entre outros. Para tal, o utilizador deverá registar o
 serviço ao qual pretende efetuar o pagamento, fornecendo os dados necessários, podendo efetuar pagamentos manuais ou
 agendá-los caso prefira o débito automático.

## Pré-requisitos

Antes de rodar o projeto, você precisa ter o seguinte instalado:

- [Java 17 ou superior](https://www.oracle.com/br/java/technologies/downloads/#java23)
- [Maven](https://maven.apache.org/) (opcional, caso use para gerenciamento de dependências)

## Como rodar o projeto

1. Clone o repositório para sua máquina local:

   ```bash
   git clone https://github.com/usuario/projeto-bancario.git
Navegue até o diretório do projeto:

bash
Copiar código
cd projeto-bancario
Compile o projeto:

Caso esteja usando Maven, execute o comando:

bash
Copiar código
mvn compile
Caso não use Maven, compile manualmente os arquivos .java:

bash
Copiar código
javac *.java
Execute a aplicação:

Se for um programa simples, pode rodar o arquivo principal diretamente. Por exemplo:

bash
Copiar código
java Main
Estrutura do projeto
src/ - Código-fonte do projeto.
Main.java - Arquivo principal que executa o sistema bancário.
Conta.java - Classe que representa uma conta bancária.
Banco.java - Classe que gerencia as contas e as transações.
Contribuindo
Faça um fork do repositório.
Crie uma nova branch para sua feature (git checkout -b feature/nova-feature).
Faça as alterações e commit (git commit -am 'Adiciona nova feature').
Envie para o branch remoto (git push origin feature/nova-feature).
Abra um pull request.

Licença

Este projeto está licenciado sob a MIT License.

csharp
Copiar código

Esse README inclui informações sobre as funcionalidades do projeto, como rodá-lo e como contribuir. Você pode personalizar conforme os detalhes específicos do seu projeto bancário em Java.
