# DOCUMENTO DE DESCRIÇÃO DO SISTEMA

## Projeto 1 — Projeto e Arquitetura de Sistemas (AV1)

**Universidade de Fortaleza (UNIFOR)**  
**Docente:** Prof. Américo  
**Equipe:** Wanessa Vieira, Luis Gustavo e Manuelly Rodrigues  
**Sistema:** Doces Tia Bita — Sistema de Gerenciamento  
**Repositório GitHub:** `proj-arquitetura-de-sistemas` | **Linguagem:** Java 21 (OO)  

---

## 1. Propósito do Sistema

O **Doces Tia Bita — Sistema de Gerenciamento** foi desenvolvido para apoiar e otimizar a gestão operacional de uma confeitaria artesanal. O objetivo primordial da solução é fornecer um controle ágil, centralizado e confiável das informações relativas ao catálogo de **produtos**, à base de **clientes** e ao estoque de **ingredientes/insumos** da empresa.

Com uma interface direta e orientada a menus no console, o sistema permite realizar todo o ciclo de vida dos dados essenciais (operações de CRUD: criação, consulta, atualização e remoção), garantindo a integridade e a consistência das informações por meio de validações de regras de negócio e aplicando boas práticas consolidadas da Engenharia de Software e da Arquitetura Orientada a Objetos (padrões GoF e GRASP).

---

## 2. Usuários do Sistema

Para atender ao escopo acadêmico sem complexidade desnecessária de controle de acesso, o sistema adota um perfil de usuário unificado:

- **Administrador / Gestor da Confeitaria:** Usuário responsável por todas as operações administrativas da loja, incluindo:
  - Cadastro, alteração, consulta e exclusão de produtos do cardápio;
  - Definição de preços normais e promocionais;
  - Cadastro, manutenção, consulta e remoção de clientes da confeitaria;
  - Simulação de planos de fidelidade e benefícios aos clientes;
  - Controle de insumos e monitoramento de alertas de níveis críticos de estoque de ingredientes.

---

## 3. Principais Funcionalidades (Cadastros CRUD)

Conforme a diretriz da disciplina para equipes compostas por **trio**, o sistema implementa integralmente **3 cadastros** com operações de CRUD completo:

### 3.1. Cadastro 1: Produtos
Permite manter o catálogo de doces e sobremesas da confeitaria.
- **Atributos:**
  - `id` (Identificador numérico único)
  - `nome` (Nome comercial do produto, ex: *Bolo de Cenoura*)
  - `categoria` (Classificação, ex: *Bolo*, *Torta*, *Cupcake*)
  - `sabor` (Sabor característico, ex: *Cenoura com Chocolate*)
  - `preco` (Valor unitário em reais)
- **Operações:**
  - **CREATE:** Cadastramento de novos itens com validação prévia.
  - **READ:** Listagem geral do catálogo e busca pontual por ID.
  - **UPDATE:** Alteração dos dados (nome, categoria, sabor e preço).
  - **DELETE:** Remoção de itens do cardápio pelo ID.
  - **Cálculo Estratégico de Preço:** Aplicação de descontos promocionais via GoF Strategy.

### 3.2. Cadastro 2: Clientes
Permite o gerenciamento dos clientes para contato e programas de fidelização.
- **Atributos:**
  - `id` (Identificador numérico único)
  - `nome` (Nome completo do cliente)
  - `telefone` (Telefone para contato / WhatsApp)
  - `email` (Endereço eletrônico do cliente)
- **Operações:**
  - **CREATE:** Inserção de novos clientes com checagem de unicidade.
  - **READ:** Listagem de todos os clientes e consulta detalhada por ID.
  - **UPDATE:** Atualização cadastral (nome, telefone e e-mail).
  - **DELETE:** Descadastramento de clientes pelo ID.
  - **Simulação de Fidelidade:** Concessão de benefícios com base no perfil via GoF Strategy.

### 3.3. Cadastro 3: Ingredientes
Permite o controle de estoque dos insumos utilizados na fabricação das sobremesas.
- **Atributos:**
  - `id` (Identificador numérico único gerado sequencialmente)
  - `nome` (Nome do insumo/ingrediente, ex: *Farinha de Trigo*)
  - `categoria` (Classificação do insumo, ex: *Secos*, *Laticínios*, *Chocolates*)
  - `quantidade` (Quantidade disponível em estoque)
  - `unidadeMedida` (Unidade de medida, ex: *kg*, *g*, *l*, *unidades*)
- **Operações:**
  - **CREATE:** Registro de novos ingredientes com validação obrigatória.
  - **READ:** Listagem geral do estoque e consulta detalhada por ID.
  - **UPDATE:** Alteração dos dados (nome, categoria, quantidade e unidade de medida).
  - **DELETE:** Remoção de insumos do estoque por ID.
  - **Avaliação de Estoque Mínimo:** Análise de nível de estoque e alertas de reabastecimento via GoF Strategy.

---

## 4. Requisitos Funcionais e Regras de Negócio

### 4.1. Requisitos Funcionais (RF)
- **RF01:** O sistema deve permitir cadastrar um produto.
- **RF02:** O sistema deve permitir listar todos os produtos cadastrados.
- **RF03:** O sistema deve permitir buscar um produto pelo seu ID.
- **RF04:** O sistema deve permitir atualizar os dados de um produto existente.
- **RF05:** O sistema deve permitir excluir um produto por ID.
- **RF06:** O sistema deve permitir cadastrar um cliente.
- **RF07:** O sistema deve permitir listar todos os clientes cadastrados.
- **RF08:** O sistema deve permitir buscar um cliente pelo seu ID.
- **RF09:** O sistema deve permitir atualizar os dados de um cliente existente.
- **RF10:** O sistema deve permitir excluir um cliente por ID.
- **RF11:** O sistema deve permitir cadastrar um ingrediente.
- **RF12:** O sistema deve permitir listar todos os ingredientes cadastrados.
- **RF13:** O sistema deve permitir buscar um ingrediente pelo seu ID.
- **RF14:** O sistema deve permitir atualizar os dados de um ingrediente existente.
- **RF15:** O sistema deve permitir excluir um ingrediente por ID.

### 4.2. Regras de Negócio (RN)
- **RN01:** Cada produto deve possuir um ID único no sistema.
- **RN02:** O nome do produto não pode ser nulo ou vazio.
- **RN03:** O preço do produto deve ser estritamente maior que zero.
- **RN04:** Cada cliente deve possuir um ID único no sistema.
- **RN05:** O nome do cliente não pode ser nulo ou vazio.
- **RN06:** O telefone do cliente não pode ser nulo ou vazio.
- **RN07:** Cada ingrediente deve possuir um ID único no sistema.
- **RN08:** O nome do ingrediente não pode ser nulo ou vazio.
- **RN09:** A quantidade do ingrediente não pode ser negativa (deve ser maior ou igual a zero).

---

## 5. Padrões de Projeto Aplicados (GoF e GRASP)

Em estrito atendimento ao critério da disciplina (*mínimo de 2 padrões GRASP e 2 padrões GoF por cadastro*), o projeto utilizou padrões consolidados para promover baixo acoplamento, alta coesão e manutenibilidade:

### 5.1. Padrões no Cadastro de Produtos

#### Padrões GRASP:
1. **Controller (`ProdutoController`):** Atua como o primeiro objeto além da camada de interface a receber e coordenar as mensagens de operação, desacoplando a UI da lógica de domínio.
2. **Information Expert (`Produto.dadosValidos()`):** A classe `Produto` detém os atributos do produto, sendo especialista em verificar se o nome está preenchido e o preço é maior que zero.

#### Padrões GoF:
1. **Factory (`ProdutoFactory`):** Centraliza e encapsula a instanciação de objetos `Produto`, isolando o restante do sistema do operador `new`.
2. **Strategy (`PrecoStrategy`, `PrecoNormalStrategy`, `PrecoPromocionalStrategy`):** Encapsula famílias de algoritmos de precificação, permitindo aplicar descontos de forma intercambiável sem alterar a classe `Produto`.

---

### 5.2. Padrões no Cadastro de Clientes

#### Padrões GRASP:
1. **Controller (`ClienteController`):** Orquestra o fluxo de requisições de clientes entre a apresentação e o `ClienteService`.
2. **Information Expert (`Cliente.dadosValidos()`):** A classe `Cliente` detém as informações do contato e valida internamente se `nome` e `telefone` estão preenchidos.

#### Padrões GoF:
1. **Factory (`ClienteFactory`):** Padroniza a criação de instâncias de `Cliente` em um ponto único do sistema.
2. **Strategy (`DescontoClienteStrategy`, `ClienteComumStrategy`, `ClienteFidelidadeStrategy`):** Varia as políticas de benefício e descontos de acordo com a fidelidade do cliente sem condicionais acopladas.

---

### 5.3. Padrões no Cadastro de Ingredientes

#### Padrões GRASP:
1. **Controller (`IngredienteController`):** Intermedeia as operações originadas da interface com o `IngredienteService`, assegurando a separação de responsabilidades.
2. **Information Expert (`Ingrediente.dadosValidos()`):** A própria entidade `Ingrediente` valida se possui nome válido, unidade de medida e se sua quantidade em estoque é não negativa.

#### Padrões GoF:
1. **Factory (`IngredienteFactory`):** Encapsula a criação de novos ingredientes no estoque, promovendo desacoplamento e flexibilidade.
2. **Strategy (`EstoqueStrategy`, `AlertaEstoqueMinimoStrategy`):** Modela algoritmos de controle de estoque dinâmicos, emitindo alertas de reposição urgente quando os insumos atingem níveis críticos configuráveis.

---

## 6. Arquitetura e Estrutura de Pacotes

O código está estruturado em pacotes modulares e de alta coesão:
```
model/src/
├── Main.java                          # Interface de console, menus e rotina de demonstração
├── model/
│   ├── Produto.java                   # Entidade de Produto (Information Expert)
│   ├── Cliente.java                   # Entidade de Cliente (Information Expert)
│   └── Ingrediente.java               # Entidade de Ingrediente (Information Expert)
├── factory/
│   ├── ProdutoFactory.java            # GoF Factory para Produto
│   ├── ClienteFactory.java            # GoF Factory para Cliente
│   └── IngredienteFactory.java        # GoF Factory para Ingrediente
├── strategy/
│   ├── PrecoStrategy.java             # GoF Strategy de preços
│   ├── PrecoNormalStrategy.java       # Estratégia de preço normal
│   ├── PrecoPromocionalStrategy.java  # Estratégia de preço com desconto
│   ├── DescontoClienteStrategy.java   # GoF Strategy de fidelidade de clientes
│   ├── ClienteComumStrategy.java      # Estratégia cliente comum
│   ├── ClienteFidelidadeStrategy.java # Estratégia cliente fidelidade
│   ├── EstoqueStrategy.java           # GoF Strategy de avaliação de estoque
│   └── AlertaEstoqueMinimoStrategy.java # Estratégia com alerta de estoque crítico
├── repository/
│   ├── ProdutoRepository.java         # Persistência em memória (CRUD Produto)
│   ├── ClienteRepository.java         # Persistência em memória (CRUD Cliente)
│   └── IngredienteRepository.java     # Persistência em memória (CRUD Ingrediente)
├── service/
│   ├── ProdutoService.java            # Regras de negócio de Produtos (RN01-RN03)
│   ├── ClienteService.java            # Regras de negócio de Clientes (RN04-RN06)
│   └── IngredienteService.java        # Regras de negócio de Ingredientes (RN07-RN09)
└── controller/
    ├── ProdutoController.java         # GRASP Controller de Produtos
    ├── ClienteController.java         # GRASP Controller de Clientes
    └── IngredienteController.java     # GRASP Controller de Ingredientes
```

---

## 7. Instruções para Compilação e Execução

### Compilação:
```bash
javac -d model/out/production/model $(find model/src -name "*.java")
```

### Execução em Modo Interativo:
```bash
java -cp model/out/production/model Main
```

### Execução em Modo Demonstração (Captura de Telas para o AVA):
```bash
java -cp model/out/production/model Main --demo
```
