# Jcommerce (Plano do Projeto)
- OBJETIVO
- Introdução
    - Justificativa
    - Restrições
- Relação dos Envolvidos
- Planejamento
    - Escopo
    - Escopo não incluído
    - Estrutura Analítica do Projeto (EAP)
    - Entregáveis
    - Story Mapping
    - Cronograma Inicial
    - Orçamento (BUDGET)
    - Aquisições
    - Plano de Comunicação
- Riscos
    - Riscos e mitigação
    - Matriz de Riscos
- Gestão de Mudanças
- Resumo
- Informações da mudança
- Planos da mudança
- Tarefas de implementação da mudança
- Comunicações
- Acompanhamento do Projeto
- Metodologia
    - Metodologia de Gestão de Projetos SCRUM
- Anexo

## **OBJETIVO**

Entregar um software no formato de e-commerce no qual seja possível cadastrar os produtos à venda da loja, disponibilizá-los para compra via interface web e ofertar a entrega do produto via delivery ou reservas os mesmos para busca na loja física, proporcionando melhor experiência e velocidade de compra para os clientes.

| Projeto | J-Commerce |
| --- | --- |
| Gerente | Guilherme Feitosa Cruz Milhomem |
| Aprovador | Marinaldo Oliveira Santos |
| Solicitante | Fagno Alves Fonseca |
| Documento de Solicitação | TAP |
| Início | 16/08 |
| Término | 13/12 |
| Status | Em andamento |

## **Introdução**

Um e-commerce funciona como uma loja virtual e representa um excelente canal de venda online para as empresas. Na prática, significa que o lojista pode comercializar os seus produtos por meio de um site exclusivo e personalizado e, se preferir, centralizar ali as suas operações.

## **Justificativa**

Com o advento da pandemia, viu-se a necessidade de descentralizar as atividades das lojas físicas, diminuindo portanto a aglomeração e o fluxo de clientes. Aponta-se, tendo em vista tal problemática, uma solução web de venda dos produtos da loja virtualmente, possibilitando a compra, reserva e entrega dos produtos via interface web, proporcionando a solução ideal para o solicitante.

## **Restrições**

1. As aplicações backend e frontend devem ser construídas separadamente;
2. A aplicação backend deve ser desenvolvida em Java com framework Spring;
3. A aplicação frontend deve ser desenvolvida com React;
4. A aplicação deve utilizar um banco de dados relacional;
5. A aplicação deve possuir uma infraestrutura distribuída na AWS, possibilitando o acesso de 10.000 (dez mil) usuários simultâneos, dentro de um orçamento de até R$ 300,00 (trezentos reais) mensais para hospedagem;
6. O projeto deve estar entregue e hospedado até o dia 13 (treze) de dezembro.

## **Relação dos Envolvidos**

| Nome | Email | Telefone | Papel |
| --- | --- | --- | --- |
| Guilherme Milhomem | guilherme.milhomem2@estudante.ifto.edu.br | 63 992913656 | Gerente |
| Marinaldo Oliveira | marinaldo.oliveira@gmail.com | 63 984444444 | Stakeholder |
| Fátima Daniele | danifcf0@gmail.com | 63 992525873 | Product owner |
| Leonardo Gonçalves | analista@dominio.com | 63 99999999 | Analista de Requisitos |
| Eli Soares | frontend@dominio.com | 63 999999999 | Desenvolvedor Frontend |
| Guilherme Feitosa | backend@dominio.com | 63 999999999 | Desenvolvedor Backend |
| Marcos Nunes | qa@dominio.com | 63 99999999 | Tester |

## **Planejamento**

### **Escopo**

O sistema em questão deve possuir um **cadastro de usuários**, sendo informado primeiramente o e-mail e em seguida, caso não haja nenhum cadastro com este e-mail, o nome e sobrenome, data de nascimento, CPF e por fim senha e confirmação da senha, no qual, após o **login** deste **clientes**, informando e-mail e senha corretamente, seja possível a visualização da lista de produtos disponíveis na loja e adicioná-los ao carrinho de compras, podendo finalizar sua compra posteriormente. 	

Este sistema deve também possibilitar o **cadastro de funcionários** somente para o **usuário "administrador"** do sistema, informando primeiramente o e-mail e em seguida, caso não haja nenhum cadastro com este e-mail, o nome e sobrenome, data de nascimento, CPF, CEP e endereço e por fim senha e confirmação da senha.	

O sistema deve possibilitar que funcionários possam **cadastrar produtos**, informando o código, nome, descrição e valor e a imagem do produto. Para **finalizar a compra**, o sistema deve permitir que o usuário informe a forma de pagamento que deseja, sendo cartão de crédito ou pix, e se deseja retirar o produto na loja ou informar o CEP e endereço de entrega do produto.

### **Escopo não incluído**

Não será implementado ao sistema a acessibilidade para usuários com deficiências visuais.

## **Estrutura Analítica do Projeto (EAP)**

<img src="https://lh4.googleusercontent.com/OGsfY6gDGYE3UsUZfP1hMDVlNlenw_cI2jLggvyrmKFvdtfdptjrfr9rtDUk0ZHUbrCvzFclFqa6FpooEHkvXpYaackBmmYaQQo-WObGVfzxwS-9YawNiQkQaLmkDvAyj26PdfvtAblS9LYm87ot4KO66HFV884TdO_BsKqguZpqqINZf5ZydA0zGw"></img>

### **Entregáveis**

| EAP | Entrega | Tipo | Responsável |
| --- | --- | --- | --- |
| 1 | J-Commerce | Project |  |
| 1-1 | Planejamento | Fase |  |
| 1-1-1 | Elaborar plano de projeto | Tarefa | Gerente de Projeto |
| 1-1-1-1 | Elaborar orçamento do projeto | Subtarefa | Gerente de Projeto |
| 1-1-1-2 | Elaborar plano de aquisições | Subtarefa | Gerente de Projeto |
| 1-1-2 | Elaborar EAP | Tarefa | Gerente de Projeto |
| 1-1-3 | Elaborar mapa de entregas | Tarefa | Gerente de Projeto |
| 1-1-4 | Elaborar cronograma | Tarefa | Gerente de Projeto |
| 1-1-5 | Elaborar mapa de riscos | Tarefa | Gerente de Projeto |
| 1-1-6 | Elaborar template de solicitação de mudança | Tarefa | Gerente de Projeto |
|  |  |  |  |
| 1-2 | Iniciação | Fase |  |
| 1-2-1 | Elaborar Product Backlog | Tarefa | Scrum Master |
| 1-2-2 | Planejar a arquitetura da aplicação | Tarefa | Arquiteto |
| 1-2-3 | Configurar a ferramenta de controle de versão | Tarefa | Arquiteto |
| 1-2-4 | Configurar integração contínua | Tarefa | Arquiteto |
| 1-2-5 | Elaborar estratégia de versionamento para entrega contínua | Tarefa | Arquiteto |
| 1-2-6 | Configurar automação de deploy | Tarefa | Arquiteto |
| 1-2-7 | Configurar ferramenta para versionamento de scripts de BD | Tarefa | Arquiteto |
| 1-2-8 | Elaborar template de especificação de casos de usos | Tarefa | Analista de Requisitos |
| 1-2-9 | Elaborar template do plano de testes | Tarefa | Líder de Testes |
| 1-2-10 | Configurar ambiente de desenvolvimento em containers | Tarefa | Arquiteto |
|  |  |  |  |
| 1-3 | Execução | Fase |  |
| 1-3-1 | Sprint Backlog | Tarefa | Scrum Master |
| 1-3-2 | Especificação de casos de usos da Sprint | Tarefa | Analista de Requisitos |
| 1-3-3 | Protótipos de telas | Tarefa | Analista UX |
| 1-3-4 | Codificação | Tarefa | Developers |
| 1-3-5 | Testes funcionais | Tarefa | Testers |
| 1-3-6 | Empacotamento e deploy | Tarefa | Developers |
| 1-3-7 | Atualizar a Product Backlog | Tarefa | Scrum Master |
|  |  |  |  |
| 1-4 | Monitoramento e Controle | Fase |  |
| 1-4-1 | Atas de reuniões quinzenais | Tarefa | Gerente de Projeto |
| 1-4-2 | Relatório de Status Reports | Tarefa | Gerente de Projeto |
| 1-4-3 | Relatório de acompanhamento das atividades | Tarefa | Gerente de Projeto |
|  |  |  |  |
| 1-5 | Encerramento | Fase |  |
| 1-5-1 | Relatório de entrega do produto | Fase | Gerente de Projeto |
| 1-5-2 | Termo de aceite e encerramento do projeto | Fase | Gerente de Projeto |

### **Story Mapping e Cronograma**
![image](https://user-images.githubusercontent.com/54874044/194129226-1f8506db-889c-44da-adb1-38f3d406021f.png)

### **Product Backlog**
![image](https://user-images.githubusercontent.com/54874044/197667258-aef89fca-4730-4aad-b9a4-49c0c63942af.png)

### User Story

> 🔐 Como usuário, gostaria de **efetuar login** no sistema utilizando meu e-mail e senha cadastrados, para que eu possa visualizar os produtos à venda e efetuar minhas compras.
> - O cliente somente poderá efetuar login após efetuar seu cadastro na loja;
> - O login aceita somente dados válidos de e-mail e senha compatível;
> - A tela de login deve possibilitar que o usuário acesse um link para alteração de senha, caso a esqueça.
---
> 🛒 Como usuário, desejo adicionar produtos à venda ao meu **carrinho de compras**, para armazenar os produtos que desejo finalizar a compra posteriormente.
> - É possível adicionar ao carrinho somente os produtos que estão cadastrados no sistema;
> - É possível adicionar ao carrinho somente os produtos que possuem em estoque;
> - Ao adicionar o produto ao carrinho, ele deve possuir automaticamente uma quantidade igual a 1, sendo possível alterar esta quantidade dentro do carrinho de compras.
---
> 💳 Como usuário, desejo **efetivar a compra** dos produtos adicionados ao carrinho, cadastrando dados do meu cartão, para aquisição dos produtos informados.
> - É possível apenas adicionar formas de pagamento válidas ao sistema;
> - Deve-se encaminhar um e-mail ao cliente confirmando a efetivação da compra.
---
> 📋 Como administrador, gostaria de **cadastrar os funcionários** da loja, para possibilitar acesso destes funcionários ao sistema.
> - O cadastro de funcionários deve gerar um usuário no sistema com nível de acesso mais avançado que os demais clientes;
