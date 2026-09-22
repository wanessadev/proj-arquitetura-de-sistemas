# Doces Tia Bita — Sistema de Gerenciamento 🍰

> **Projeto 1 da disciplina Projeto e Arquitetura de Sistemas (AV1)**  
> **Professor:** Américo Sampaio — UNIFOR  
> **Equipe:** Wanessa Vieira & Luís Guilherme  

---

## 🎯 Sobre o Sistema

O **Doces Tia Bita** é um sistema orientado a objetos desenvolvido em Java para auxiliar no gerenciamento operacional de uma confeitaria artesanal, controlando o catálogo de **Produtos** e o cadastro de **Clientes**.

---

## 📦 Cadastros Implementados (CRUDs)

### 1. Cadastro de Produtos
- Atributos: `ID`, `Nome`, `Categoria`, `Sabor`, `Preço`
- CRUD completo (Create, Read [listar e buscar por ID], Update e Delete).
- Validação de integridade e cálculo de preços promocionais.

### 2. Cadastro de Clientes
- Atributos: `ID`, `Nome`, `Telefone`, `E-mail`
- CRUD completo (Create, Read [listar e buscar por ID], Update e Delete).
- Validação de campos obrigatórios e simulação de benefícios do programa de fidelidade.

---

## 🏛️ Padrões de Projeto Utilizados

| Cadastro | Padrões GRASP | Padrões GoF |
| :--- | :--- | :--- |
| **Produtos** | • **Controller** (`ProdutoController`)<br>• **Information Expert** (`Produto.dadosValidos()`) | • **Factory** (`ProdutoFactory`)<br>• **Strategy** (`PrecoStrategy`, `PrecoNormalStrategy`, `PrecoPromocionalStrategy`) |
| **Clientes** | • **Controller** (`ClienteController`)<br>• **Information Expert** (`Cliente.dadosValidos()`) | • **Factory** (`ClienteFactory`)<br>• **Strategy** (`DescontoClienteStrategy`, `ClienteComumStrategy`, `ClienteFidelidadeStrategy`) |

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

### Executar Demonstração Completa (Ideal para Captura de Telas / Prints)
```bash
java -cp model/out/production/model Main --demo
```

---

## 📄 Documentação Completa da Entrega
Para a descrição detalhada do sistema, propósito, requisitos funcionais, regras de negócio e fundamentação dos padrões de projeto exigidos na avaliação (Itens 2.1 e 2.2), consulte o arquivo [`DOCUMENTO_DESCRICAO_SISTEMA.md`](DOCUMENTO_DESCRICAO_SISTEMA.md).
