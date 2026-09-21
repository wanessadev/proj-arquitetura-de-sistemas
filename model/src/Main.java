import controller.ProdutoController;
import model.Produto;
import repository.ProdutoRepository;
import service.ProdutoService;

public class Main {

    public static void main(String[] args) {

        // Criando as partes do sistema
        ProdutoRepository repository = new ProdutoRepository();
        ProdutoService service = new ProdutoService(repository);
        ProdutoController controller = new ProdutoController(service);

        // ==============================
        // CREATE - Cadastrar produto
        // ==============================

        Produto produto1 = new Produto(
                1,
                "Bolo de Cenoura",
                "Bolo",
                "Cenoura com Chocolate",
                45.00
        );

        boolean cadastrado = controller.cadastrarProduto(produto1);

        if (cadastrado) {
            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Não foi possível cadastrar o produto.");
        }


        // ==============================
        // READ - Listar produtos
        // ==============================

        System.out.println("\n=== PRODUTOS CADASTRADOS ===");

        for (Produto produto : controller.listarProdutos()) {
            System.out.println(produto);
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

        Produto produtoAtualizado = new Produto(
                1,
                "Bolo de Cenoura",
                "Cenoura com Chocolate",
                "Bolo",
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
            for (Produto produto : controller.listarProdutos()) {
                System.out.println(produto);
            }
        }
    }
}