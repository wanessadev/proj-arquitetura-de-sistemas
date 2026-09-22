# Doces Tia Bita — Sistema de Gerenciamento 🍰

> **Projeto 1 da disciplina Projeto e Arquitetura de Sistemas (AV1)**  
> **Professor:** Prof. Américo  
> **Equipe:** Wanessa Vieira, Luis Gustavo e Manuelly Rodrigues  

---

## 🎯 Sobre o Sistema

O **Doces Tia Bita** é um sistema orientado a objetos desenvolvido em Java para auxiliar no gerenciamento operacional de uma confeitaria artesanal, controlando o catálogo de **Produtos**, a base de **Clientes** e o estoque de **Ingredientes / Insumos**.

---

## 📦 Cadastros Implementados (CRUDs)

### 1. Cadastro de Produtos
- Atributos: `ID`, `Nome`, `Categoria`, `Sabor`, `Preço`
- CRUD completo (Create, Read [listar e buscar por ID], Update e Delete).
- Validação de integridade e cálculo de preços promocionais via Strategy.

### 2. Cadastro de Clientes
- Atributos: `ID`, `Nome`, `Telefone`, `E-mail`
- CRUD completo (Create, Read [listar e buscar por ID], Update e Delete).
- Validação de campos obrigatórios e simulação de fidelidade via Strategy.

### 3. Cadastro de Ingredientes
- Atributos: `ID`, `Nome`, `Categoria`, `Quantidade`, `Unidade de Medida`
- CRUD completo (Create, Read [listar e buscar por ID], Update e Delete).
- Validação de consistência e avaliação de níveis críticos de estoque via Strategy.

---

## 🏛️ Padrões de Projeto Utilizados

Em conformidade com a exigência da disciplina (mínimo de 2 padrões GRASP e 2 GoF por cadastro):

| Cadastro | Padrões GRASP | Padrões GoF |
| :--- | :--- | :--- |
| **Produtos** | • **Controller** (`ProdutoController`)<br>• **Information Expert** (`Produto.dadosValidos()`) | • **Factory** (`ProdutoFactory`)<br>• **Strategy** (`PrecoStrategy`, `PrecoNormalStrategy`, `PrecoPromocionalStrategy`) |
| **Clientes** | • **Controller** (`ClienteController`)<br>• **Information Expert** (`Cliente.dadosValidos()`) | • **Factory** (`ClienteFactory`)<br>• **Strategy** (`DescontoClienteStrategy`, `ClienteComumStrategy`, `ClienteFidelidadeStrategy`) |
| **Ingredientes** | • **Controller** (`IngredienteController`)<br>• **Information Expert** (`Ingrediente.dadosValidos()`) | • **Factory** (`IngredienteFactory`)<br>• **Strategy** (`EstoqueStrategy`, `AlertaEstoqueMinimoStrategy`) |

---

## 🚀 Como Executar

### Pré-requisitos
- JDK 17 ou superior (ou JDK 21).

### Compilação
```bash
javac -d model/out/production/model $(find model/src -name "*.java")
```

### Executar Menu Interativo
```bash
java -cp model/out/production/model Main
```

### Executar Demonstração Completa (Ideal para Captura de Telas / Prints para o AVA)
```bash
java -cp model/out/production/model Main --demo
```

---

## 📄 Documentação Completa da Entrega
Para a descrição detalhada do sistema, propósito, requisitos funcionais, regras de negócio e fundamentação dos padrões de projeto exigidos na avaliação (Itens 2.1 e 2.2), consulte o arquivo [`DOCUMENTO_DESCRICAO_SISTEMA.md`](DOCUMENTO_DESCRICAO_SISTEMA.md).
