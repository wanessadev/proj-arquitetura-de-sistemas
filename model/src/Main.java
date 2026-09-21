import controller.ProdutoController;
import factory.ProdutoFactory;
import model.Produto;
import repository.ProdutoRepository;
import service.ProdutoService;
import strategy.PrecoPromocionalStrategy;
import strategy.PrecoStrategy;

public class Main {

    public static void main(String[] args) {

        // Criando as partes do sistema
        ProdutoRepository repository = new ProdutoRepository();
        ProdutoService service = new ProdutoService(repository);
        ProdutoController controller = new ProdutoController(service);
        ProdutoFactory factory = new ProdutoFactory();

        // ==============================
        // CREATE - Cadastrar produto
        // ==============================

        Produto produto = factory.criarProduto(
                1,
                "Bolo de Cenoura",
                "Bolo",
                "Cenoura com Chocolate",
                50.00
        );

        PrecoStrategy estrategia = new PrecoPromocionalStrategy(0.10);

        double precoFinal = produto.calcularPreco(estrategia);

        System.out.println("Preço promocional: R$ " + precoFinal);

        boolean cadastrado = controller.cadastrarProduto(produto);

        if (cadastrado) {
            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Não foi possível cadastrar o produto.");
        }

        // ==============================
        // READ - Listar produtos
        // ==============================

        System.out.println("\n=== PRODUTOS CADASTRADOS ===");

        for (Produto p : controller.listarProdutos()) {
            System.out.println(p);
        }

        // ==============================
        // READ - Buscar produto
        // ==============================

        System.out.println("\n=== BUSCAR PRODUTO ===");

        Produto produtoEncontrado = controller.buscarProduto(1);

        if (produtoEncontrado != null) {
            System.out.println("Produto encontrado:");
            System.out.println(produtoEncontrado);
        } else {
            System.out.println("Produto não encontrado.");
        }

        // ==============================
        // UPDATE - Atualizar produto
        // ==============================

        Produto produtoAtualizado = factory.criarProduto(
                1,
                "Bolo de Cenoura",
                "Bolo",
                "Cenoura com Chocolate",
                50.00
        );

        boolean atualizado = controller.atualizarProduto(produtoAtualizado);

        if (atualizado) {
            System.out.println("\nProduto atualizado com sucesso!");
        } else {
            System.out.println("\nNão foi possível atualizar o produto.");
        }

        // ==============================
        // READ - Verificar atualização
        // ==============================

        System.out.println("\n=== PRODUTO APÓS ATUALIZAÇÃO ===");

        Produto produtoDepoisDaAtualizacao =
                controller.buscarProduto(1);

        System.out.println(produtoDepoisDaAtualizacao);

        // ==============================
        // DELETE - Excluir produto
        // ==============================

        boolean excluido = controller.excluirProduto(1);

        if (excluido) {
            System.out.println("\nProduto excluído com sucesso!");
        } else {
            System.out.println("\nNão foi possível excluir o produto.");
        }

        // ==============================
        // READ - Verificar exclusão
        // ==============================

        System.out.println("\n=== PRODUTOS APÓS EXCLUSÃO ===");

        if (controller.listarProdutos().isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto p : controller.listarProdutos()) {
                System.out.println(p);
            }
        }
    }
}