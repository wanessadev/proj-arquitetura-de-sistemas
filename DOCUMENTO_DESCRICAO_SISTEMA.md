# DOCUMENTO DE DESCRIÇÃO DO SISTEMA

## Projeto 1 — Projeto e Arquitetura de Sistemas (AV1)

**Universidade de Fortaleza (UNIFOR)**
**Docente:** Prof. Américo Sampaio
**Equipe:** Wanessa Vieira & Luís Guilherme
**Sistema:** Doces Tia Bita — Sistema de Gerenciamento
**Repositório GitHub:** `proj-arquitetura-de-sistemas`

---

## 1. Propósito do Sistema

O **Doces Tia Bita — Sistema de Gerenciamento** foi desenvolvido para apoiar e otimizar a gestão operacional básica de uma confeitaria artesanal. O objetivo primordial da solução é fornecer um controle ágil, centralizado e confiável das informações relativas ao catálogo de produtos e à base de clientes da empresa.

Com uma interface direta e orientada a menus, o sistema permite realizar todo o ciclo de vida dos dados essenciais (operações de CRUD: criação, consulta, atualização e remoção), garantindo a integridade e a consistência das informações por meio de validações de regras de negócio e aplicando boas práticas consolidadas da Engenharia de Software e da Arquitetura Orientada a Objetos.

---

## 2. Usuários do Sistema

Para atender ao escopo acadêmico sem complexidade desnecessária de controle de acesso, o sistema foi desenhado com um perfil de usuário unificado:

- **Administrador / Gerente da Confeitaria:**Usuário responsável por todas as operações administrativas da loja, incluindo:
  - Cadastro, alteração, consulta e exclusão de produtos do cardápio;
  - Definição e consulta de preços promocionais;
  - Cadastro, manutenção, consulta e remoção de clientes da confeitaria;
  - Simulação de planos de fidelidade e descontos personalizados.

---

## 3. Principais Funcionalidades (CRUDs)

Conforme a exigência para equipes em dupla, o sistema implementa integralmente **2 cadastros**:

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
  - **Cálculo Estratégico de Preço:** Aplicação de descontos promocionais via Strategy.

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
  - **Simulação de Fidelidade:** Aplicação de regras de fidelidade via Strategy.
 
### 3.3. Cadastro 3: Ingredientes

Permite o controle de estoques e insumos utilizados na fábrica dos doces.

- **Atributos:**
  - `id` (Identificador numérico único)
  - `nome` (Nome do insumo/Ingrediente)
  - `categoria` (Classificação do insumo, ex: Laticínios, Secos, Chocolates)
  - `quantidade` (Quantidade disponível em estoque)
  - `unidadeMedia` (Unidade de medida, ex: unidades, kg, g, ml)

 - **Operações:**
  - **CREATE:** Registro de novos ingredientes com validação de dados.
  - **READ:** Listagem geral do estoque e consulta pontual por ID.
  - **UPDATE:** Alteração de dados (nome, categoria, quantidade e unidade de medida).
  - **DELETE:** Remoção de insumos do sistema pelo ID.
  - **Simulação de Fidelidade:** Atualização e verificação contínua dos níveis de insumos em estoque.

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
- **RF12:** O sistema deve perimitir listar todos os ingredientes cadastrados.
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
- **RN09:** A quantidade do ingrediente não pode ser negativa( deve ser maior ou igual a zero).

---

## 5. Padrões de Projeto Aplicados (GoF e GRASP)

Em estrito atendimento ao critério da disciplina (*mínimo de 2 padrões GRASP e 2 padrões GoF por cadastro*), o projeto utilizou padrões consolidados para promover baixo acoplamento, alta coesão e facilidade de manutenção:

### 5.1. Padrões no Cadastro de Produtos

#### Padrões GRASP:

1. **Controller (`ProdutoController`):**
   - **Justificativa:** Atua como o primeiro objeto além da camada de interface (Console/Main) a receber e coordenar as mensagens de operação do sistema. Não executa regras de negócio diretamente; delega as solicitações para o `ProdutoService`, desacoplando a UI do domínio.
2. **Information Expert (`Produto.dadosValidos()`):**
   - **Justificativa:** A classe `Produto` possui toda a informação necessária sobre seus próprios atributos (`nome`, `preco`). Portanto, é atribuída a ela a responsabilidade especialista de validar se os seus dados atendem às condições mínimas de consistência (nome preenchido e preço positivo).
3. *(Bônus)* **Low Coupling & High Cohesion:**
   - Separação em camadas bem delimitadas: `ProdutoRepository` (persistência em memória), `ProdutoService` (validações e regras de negócio) e `ProdutoController` (orquestração).

#### Padrões GoF:

1. **Simple Factory / Factory (`ProdutoFactory`):**
   - **Tipo:** Criacional.
   - **Justificativa:** Centraliza e encapsula a instanciação de objetos `Produto`. Isola o restante do sistema da chamada direta ao operador `new`, facilitando extensões futuras na construção de produtos complexos.
2. **Strategy (`PrecoStrategy`, `PrecoNormalStrategy`, `PrecoPromocionalStrategy`):**
   - **Tipo:** Comportamental.
   - **Justificativa:** Define uma família de algoritmos para precificação, encapsulando cada política de preço em uma classe separada e tornando-as intercambiáveis em tempo de execução. Permite aplicar descontos promocionais sem alterar a classe `Produto`.

---

### 5.2. Padrões no Cadastro de Clientes

#### Padrões GRASP:

1. **Controller (`ClienteController`):**
   - **Justificativa:** Ponto de entrada das requisições de clientes originadas da interface. Intermedia o fluxo entre a UI e a lógica de negócio do `ClienteService`, preservando a independência da apresentação.
2. **Information Expert (`Cliente.dadosValidos()`):**
   - **Justificativa:** O objeto `Cliente` detém os dados de `nome` e `telefone`. Seguindo o princípio do especialista na informação, ele próprio verifica se seus campos obrigatórios foram devidamente preenchidos.
3. *(Bônus)* **Creator / Repository:**
   - O `ClienteRepository` encapsula e gerencia a coleção de instâncias de `Cliente`, preservando o princípio de baixo acoplamento e separação de responsabilidades.

#### Padrões GoF:

1. **Simple Factory / Factory (`ClienteFactory`):**
   - **Tipo:** Criacional.
   - **Justificativa:** Padroniza a criação de instâncias de `Cliente`, garantindo que todas as criações ocorram por meio de um ponto único e controlado.
2. **Strategy (`DescontoClienteStrategy`, `ClienteComumStrategy`, `ClienteFidelidadeStrategy`):**
   - **Tipo:** Comportamental.
   - **Justificativa:** Permite variar a estratégia de concessão de descontos e benefícios conforme o perfil do cliente (ex: cliente regular sem desconto vs. cliente cadastrado no programa de fidelidade com percentual de abatimento), sem necessidade de instruções condicionais complexas (`if/else`) espalhadas pelo código.

### 5.3. Padrões no Cadastro de Ingredientes

#### Padrões GRASP:
1. **Controller(`IngredienteService`):**
  - **Justificativa:** Atua como o ponto focal para tratar as regras de negócio e coordenar as requisições do sistema antes de repassá-las na camada de dados.
2. **Creator(`IngredienteService`)**
  - **Justificativa:** Assume a responsabilidade de instanciar objetos da classe Ingrediente, pois ela possui informações necessárias para validar e registrar novos elementos.

#### Padrões GoF:
1. **Repository Pattern / Padrão Estrutural (`IngredienteRepository`):**
   - **Tipo:** Estrutural.
   - **Justificativa:** Encapsula a lógica de acesso e manipulação dos dados da coleção na classe `IngredienteRepository`, isolando o restante da aplicação dos detalhes de armazenamento.

2. **Dependency Injection / Injeção de Dependencia (`IngredienteRepository`):**
   - **Tipo:** Dependencia.
   - **Justificativa:** A dependencia de `IngredienteRepository` é passada pelo construtor em `IngredienteService` reduzindo o acoplamento entre os componentes e facilitando testes únitários.

---

## 6. Arquitetura e Estrutura de Pacotes

O código está estruturado em pacotes coesos:

```
model/src/
├── Main.java                          # Interface de console, menu interativo e modo demo
├── model/
│   ├── Produto.java                   # Entidade de Produto (Information Expert)
│   └── Cliente.java                   # Entidade de Cliente (Information Expert)
├── factory/
│   ├── ProdutoFactory.java            # GoF Factory para Produto
│   └── ClienteFactory.java            # GoF Factory para Cliente
├── strategy/
│   ├── PrecoStrategy.java             # GoF Strategy de preços
│   ├── PrecoNormalStrategy.java       # Estratégia concreta
│   ├── PrecoPromocionalStrategy.java  # Estratégia concreta com desconto
│   ├── DescontoClienteStrategy.java   # GoF Strategy de fidelidade
│   ├── ClienteComumStrategy.java      # Estratégia concreta sem desconto
│   └── ClienteFidelidadeStrategy.java # Estratégia concreta com fidelidade
├── repository/
│   ├── ProdutoRepository.java         # Persistência em memória (CRUD Produto)
│   └── ClienteRepository.java         # Persistência em memória (CRUD Cliente)
├── service/
│   ├── ProdutoService.java            # Regras de negócio de Produtos (RN01-RN03)
│   └── ClienteService.java            # Regras de negócio de Clientes (RN04-RN06)
└── controller/
    ├── ProdutoController.java         # GRASP Controller de Produtos
    └── ClienteController.java         # GRASP Controller de Clientes
```

---

## 7. Instruções para Compilação e Execução

### Compilação:

```bash
javac -d model/out/production/model $(find model/src -name "*.java")
```

### Execução em Modo Interativo (Navegação pelos Menus):

```bash
java -cp model/out/production/model Main
```

### Execução em Modo Demonstração:

```bash
java -cp model/out/production/model Main --demo
```
