import controller.ClienteController;
import controller.ProdutoController;
import factory.ClienteFactory;
import factory.ProdutoFactory;
import model.Cliente;
import model.Produto;
import repository.ClienteRepository;
import repository.ProdutoRepository;
import service.ClienteService;
import service.ProdutoService;
import strategy.ClienteComumStrategy;
import strategy.ClienteFidelidadeStrategy;
import strategy.PrecoNormalStrategy;
import strategy.PrecoPromocionalStrategy;
import strategy.PrecoStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static ProdutoController produtoController;
    private static ClienteController clienteController;
    private static ProdutoFactory produtoFactory;
    private static ClienteFactory clienteFactory;
    private static Scanner scanner;

    public static void main(String[] args) {
        // Inicialização dos componentes (Injeção de dependências)
        ProdutoRepository produtoRepository = new ProdutoRepository();
        ProdutoService produtoService = new ProdutoService(produtoRepository);
        produtoController = new ProdutoController(produtoService);
        produtoFactory = new ProdutoFactory();

        ClienteRepository clienteRepository = new ClienteRepository();
        ClienteService clienteService = new ClienteService(clienteRepository);
        clienteController = new ClienteController(clienteService);
        clienteFactory = new ClienteFactory();

        scanner = new Scanner(System.in);

        // Se passado argumento "--demo", roda apenas a demonstração automática
        if (args.length > 0 && args[0].equalsIgnoreCase("--demo")) {
            executarDemonstracaoCompleta();
            return;
        }

        int opcao = -1;
        while (opcao != 0) {
            exibirMenuPrincipal();
            System.out.print("Digite uma opção: ");
            String entrada = scanner.nextLine().trim();

            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1:
                    menuProdutos();
                    break;
                case 2:
                    menuClientes();
                    break;
                case 3:
                    executarDemonstracaoCompleta();
                    break;
                case 0:
                    System.out.println("\nSaindo do sistema Doces Tia Bita. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n+-------------------------------------+");
        System.out.println("|           DOCES TIA BITA            |");
        System.out.println("|       Sistema de Gerenciamento      |");
        System.out.println("+-------------------------------------+");
        System.out.println("| 1. Gerenciar Produtos               |");
        System.out.println("| 2. Gerenciar Clientes               |");
        System.out.println("| 3. Executar Demonstracao Completa   |");
        System.out.println("| 0. Sair                             |");
        System.out.println("+-------------------------------------+");
    }

    // ==========================================================
    // MENU GERENCIAR PRODUTOS (CRUD + GoF Strategy)
    // ==========================================================
    private static void menuProdutos() {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- [ GERENCIAR PRODUTOS ] ---");
            System.out.println("1. Cadastrar Produto (CREATE)");
            System.out.println("2. Listar Produtos (READ)");
            System.out.println("3. Buscar Produto por ID (READ)");
            System.out.println("4. Atualizar Produto (UPDATE)");
            System.out.println("5. Excluir Produto (DELETE)");
            System.out.println("6. Calcular Preço Promocional (GoF Strategy)");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                op = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida.");
                continue;
            }

            switch (op) {
                case 1:
                    cadastrarProdutoConsole();
                    break;
                case 2:
                    listarProdutosConsole();
                    break;
                case 3:
                    buscarProdutoConsole();
                    break;
                case 4:
                    atualizarProdutoConsole();
                    break;
                case 5:
                    excluirProdutoConsole();
                    break;
                case 6:
                    calcularPrecoPromocionalConsole();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarProdutoConsole() {
        System.out.println("\n-- Cadastrar Produto --");
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();
            System.out.print("Categoria: ");
            String categoria = scanner.nextLine().trim();
            System.out.print("Sabor: ");
            String sabor = scanner.nextLine().trim();
            System.out.print("Preço (ex: 45.00): ");
            double preco = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));

            Produto p = produtoFactory.criarProduto(id, nome, categoria, sabor, preco);
            if (produtoController.cadastrarProduto(p)) {
                System.out.println(" Produto cadastrado com sucesso!");
            } else {
                System.out.println(" Falha ao cadastrar: verifique se o ID já existe e se nome/preço são válidos.");
            }
        } catch (Exception e) {
            System.out.println(" Dados inválidos: " + e.getMessage());
        }
    }

    private static void listarProdutosConsole() {
        System.out.println("\n-- Lista de Produtos --");
        List<Produto> lista = produtoController.listarProdutos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto p : lista) {
                System.out.println(p);
            }
        }
    }

    private static void buscarProdutoConsole() {
        System.out.print("\nDigite o ID do produto: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            Produto p = produtoController.buscarProduto(id);
            if (p != null) {
                System.out.println("Produto encontrado: " + p);
            } else {
                System.out.println("Produto com ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("ID inválido.");
        }
    }

    private static void atualizarProdutoConsole() {
        System.out.println("\n-- Atualizar Produto --");
        try {
            System.out.print("ID do produto a atualizar: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Novo Nome: ");
            String nome = scanner.nextLine().trim();
            System.out.print("Nova Categoria: ");
            String categoria = scanner.nextLine().trim();
            System.out.print("Novo Sabor: ");
            String sabor = scanner.nextLine().trim();
            System.out.print("Novo Preço: ");
            double preco = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));

            Produto p = produtoFactory.criarProduto(id, nome, categoria, sabor, preco);
            if (produtoController.atualizarProduto(p)) {
                System.out.println(" Produto atualizado com sucesso!");
            } else {
                System.out.println(" Falha ao atualizar: produto não encontrado ou dados inválidos.");
            }
        } catch (Exception e) {
            System.out.println(" Dados inválidos: " + e.getMessage());
        }
    }

    private static void excluirProdutoConsole() {
        System.out.print("\nDigite o ID do produto a excluir: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            if (produtoController.excluirProduto(id)) {
                System.out.println(" Produto excluído com sucesso!");
            } else {
                System.out.println(" Produto não encontrado para exclusão.");
            }
        } catch (Exception e) {
            System.out.println("ID inválido.");
        }
    }

    private static void calcularPrecoPromocionalConsole() {
        System.out.print("\nDigite o ID do produto: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            Produto p = produtoController.buscarProduto(id);
            if (p == null) {
                System.out.println("Produto não encontrado.");
                return;
            }
            System.out.print("Digite o percentual de desconto (ex: 10 para 10%): ");
            double pct = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
            PrecoStrategy promo = new PrecoPromocionalStrategy(pct / 100.0);
            double precoPromo = p.calcularPreco(promo);
            System.out.println("Preço original: R$ " + String.format("%.2f", p.getPreco()));
            System.out.println("Preço com desconto (GoF Strategy): R$ " + String.format("%.2f", precoPromo));
        } catch (Exception e) {
            System.out.println("Valor inválido.");
        }
    }

    // ==========================================================
    // MENU GERENCIAR CLIENTES (CRUD + GoF Strategy)
    // ==========================================================
    private static void menuClientes() {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- [ GERENCIAR CLIENTES ] ---");
            System.out.println("1. Cadastrar Cliente (CREATE)");
            System.out.println("2. Listar Clientes (READ)");
            System.out.println("3. Buscar Cliente por ID (READ)");
            System.out.println("4. Atualizar Cliente (UPDATE)");
            System.out.println("5. Excluir Cliente (DELETE)");
            System.out.println("6. Simular Desconto Fidelidade (GoF Strategy)");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                op = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida.");
                continue;
            }

            switch (op) {
                case 1:
                    cadastrarClienteConsole();
                    break;
                case 2:
                    listarClientesConsole();
                    break;
                case 3:
                    buscarClienteConsole();
                    break;
                case 4:
                    atualizarClienteConsole();
                    break;
                case 5:
                    excluirClienteConsole();
                    break;
                case 6:
                    simularDescontoClienteConsole();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarClienteConsole() {
        System.out.println("\n-- Cadastrar Cliente --");
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine().trim();
            System.out.print("E-mail: ");
            String email = scanner.nextLine().trim();

            Cliente c = clienteFactory.criarCliente(id, nome, telefone, email);
            if (clienteController.cadastrarCliente(c)) {
                System.out.println(" Cliente cadastrado com sucesso!");
            } else {
                System.out.println(" Falha ao cadastrar: verifique se o ID já existe e se nome e telefone foram preenchidos.");
            }
        } catch (Exception e) {
            System.out.println(" Dados inválidos: " + e.getMessage());
        }
    }

    private static void listarClientesConsole() {
        System.out.println("\n-- Lista de Clientes --");
        List<Cliente> lista = clienteController.listarClientes();
        if (lista.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente c : lista) {
                System.out.println(c);
            }
        }
    }

    private static void buscarClienteConsole() {
        System.out.print("\nDigite o ID do cliente: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            Cliente c = clienteController.buscarCliente(id);
            if (c != null) {
                System.out.println("Cliente encontrado: " + c);
            } else {
                System.out.println("Cliente com ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("ID inválido.");
        }
    }

    private static void atualizarClienteConsole() {
        System.out.println("\n-- Atualizar Cliente --");
        try {
            System.out.print("ID do cliente a atualizar: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Novo Nome: ");
            String nome = scanner.nextLine().trim();
            System.out.print("Novo Telefone: ");
            String telefone = scanner.nextLine().trim();
            System.out.print("Novo E-mail: ");
            String email = scanner.nextLine().trim();

            Cliente c = clienteFactory.criarCliente(id, nome, telefone, email);
            if (clienteController.atualizarCliente(c)) {
                System.out.println(" Cliente atualizado com sucesso!");
            } else {
                System.out.println(" Falha ao atualizar: cliente não encontrado ou dados em branco.");
            }
        } catch (Exception e) {
            System.out.println(" Dados inválidos: " + e.getMessage());
        }
    }

    private static void excluirClienteConsole() {
        System.out.print("\nDigite o ID do cliente a excluir: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            if (clienteController.excluirCliente(id)) {
                System.out.println(" Cliente excluído com sucesso!");
            } else {
                System.out.println(" Cliente não encontrado para exclusão.");
            }
        } catch (Exception e) {
            System.out.println("ID inválido.");
        }
    }

    private static void simularDescontoClienteConsole() {
        System.out.print("\nDigite o ID do cliente: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            Cliente c = clienteController.buscarCliente(id);
            if (c == null) {
                System.out.println("Cliente não encontrado.");
                return;
            }
            System.out.print("Valor total da compra: R$ ");
            double valor = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));

            double comum = c.calcularTotalComDesconto(new ClienteComumStrategy(), valor);
            double fidelidade = c.calcularTotalComDesconto(new ClienteFidelidadeStrategy(0.15), valor);

            System.out.println("Valor Normal (Cliente Comum): R$ " + String.format("%.2f", comum));
            System.out.println("Valor com Fidelidade (15% desc. - GoF Strategy): R$ " + String.format("%.2f", fidelidade));
        } catch (Exception e) {
            System.out.println("Valor inválido.");
        }
    }

    // ==========================================================
    // DEMONSTRAÇÃO COMPLETA AUTOMATIZADA (Ideal para Prints do AVA)
    // ==========================================================
    public static void executarDemonstracaoCompleta() {
        System.out.println("\n=======================================================");
        System.out.println("   INICIANDO DEMONSTRACAO COMPLETA - DOCES TIA BITA    ");
        System.out.println("=======================================================");

        // --------------------------------------------------
        // 1. CADASTRO DE PRODUTOS
        // --------------------------------------------------
        System.out.println("\n--- [1] DEMONSTRAÇÃO DO CRUD DE PRODUTOS ---");

        // CREATE
        System.out.println("\n[CREATE] Cadastrando produto com ProdutoFactory (GoF Factory)...");
        Produto produto1 = produtoFactory.criarProduto(1, "Bolo de Cenoura", "Bolo", "Cenoura com Chocolate", 45.00);
        Produto produto2 = produtoFactory.criarProduto(2, "Torta de Limão", "Torta", "Limão Siciliano", 35.00);
        produtoController.cadastrarProduto(produto1);
        produtoController.cadastrarProduto(produto2);
        System.out.println("Produtos cadastrados com sucesso!");

        // GoF Strategy - Preço Promocional
        System.out.println("\n[GoF Strategy] Calculando preço com PrecoPromocionalStrategy (10% desconto):");
        double precoComDesconto = produto1.calcularPreco(new PrecoPromocionalStrategy(0.10));
        System.out.println("Preço Original: R$ " + produto1.getPreco() + " -> Preço Promocional: R$ " + precoComDesconto);

        // READ - Listar
        System.out.println("\n[READ] Listando todos os produtos cadastrados:");
        for (Produto p : produtoController.listarProdutos()) {
            System.out.println("  " + p);
        }

        // READ - Buscar
        System.out.println("\n[READ] Buscando produto pelo ID 1:");
        Produto prodBuscado = produtoController.buscarProduto(1);
        System.out.println("  Resultado: " + prodBuscado);

        // UPDATE
        System.out.println("\n[UPDATE] Atualizando preço do Bolo de Cenoura para R$ 50.00:");
        Produto prodAtualizado = produtoFactory.criarProduto(1, "Bolo de Cenoura", "Bolo", "Cenoura com Chocolate", 50.00);
        produtoController.atualizarProduto(prodAtualizado);
        System.out.println("  Após atualização: " + produtoController.buscarProduto(1));

        // DELETE
        System.out.println("\n[DELETE] Excluindo produto de ID 2 (Torta de Limão)...");
        produtoController.excluirProduto(2);
        System.out.println("  Lista após exclusão do produto 2:");
        for (Produto p : produtoController.listarProdutos()) {
            System.out.println("  " + p);
        }

        // --------------------------------------------------
        // 2. CADASTRO DE CLIENTES
        // --------------------------------------------------
        System.out.println("\n--- [2] DEMONSTRAÇÃO DO CRUD DE CLIENTES ---");

        // CREATE
        System.out.println("\n[CREATE] Cadastrando clientes com ClienteFactory (GoF Factory)...");
        Cliente cliente1 = clienteFactory.criarCliente(1, "Maria Silva", "(85) 99999-9999", "maria@email.com");
        Cliente cliente2 = clienteFactory.criarCliente(2, "João Santos", "(85) 98888-8888", "joao@email.com");
        clienteController.cadastrarCliente(cliente1);
        clienteController.cadastrarCliente(cliente2);
        System.out.println("Clientes cadastrados com sucesso!");

        // GoF Strategy - Desconto Fidelidade
        System.out.println("\n[GoF Strategy] Calculando desconto para compra de R$ 100,00 da cliente Maria Silva:");
        double valorNormal = cliente1.calcularTotalComDesconto(new ClienteComumStrategy(), 100.00);
        double valorFidelidade = cliente1.calcularTotalComDesconto(new ClienteFidelidadeStrategy(0.15), 100.00);
        System.out.println("  Cliente Comum: R$ " + valorNormal);
        System.out.println("  Cliente Fidelidade (15% de desconto): R$ " + valorFidelidade);

        // READ - Listar
        System.out.println("\n[READ] Listando todos os clientes cadastrados:");
        for (Cliente c : clienteController.listarClientes()) {
            System.out.println("  " + c);
        }

        // READ - Buscar
        System.out.println("\n[READ] Buscando cliente pelo ID 1:");
        Cliente clienteBuscado = clienteController.buscarCliente(1);
        System.out.println("  Resultado: " + clienteBuscado);

        // UPDATE
        System.out.println("\n[UPDATE] Atualizando telefone e email da Maria Silva:");
        Cliente clienteAtualizado = clienteFactory.criarCliente(1, "Maria Silva Sauro", "(85) 97777-7777", "maria.sauro@email.com");
        clienteController.atualizarCliente(clienteAtualizado);
        System.out.println("  Após atualização: " + clienteController.buscarCliente(1));

        // DELETE
        System.out.println("\n[DELETE] Excluindo cliente de ID 2 (João Santos)...");
        clienteController.excluirCliente(2);
        System.out.println("  Lista após exclusão do cliente 2:");
        for (Cliente c : clienteController.listarClientes()) {
            System.out.println("  " + c);
        }

        System.out.println("\n=======================================================");
        System.out.println("    DEMONSTRAÇÃO CONCLUÍDA COM SUCESSO!                ");
        System.out.println("=======================================================\n");
    }
}