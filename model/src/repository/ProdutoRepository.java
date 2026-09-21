package repository;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    private List<Produto> produtos;

    public ProdutoRepository() {
        produtos = new ArrayList<>();
    }

    // CREATE
    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    // READ - listar todos
    public List<Produto> listarTodos() {
        return produtos;
    }

    // READ - buscar por ID
    public Produto buscarPorId(int id) {

        for (Produto produto : produtos) {

            if (produto.getId() == id) {
                return produto;
            }
        }

        return null;
    }

    // UPDATE
    public boolean atualizar(Produto produtoAtualizado) {

        Produto produto = buscarPorId(produtoAtualizado.getId());

        if (produto != null) {

            produto.setNome(produtoAtualizado.getNome());
            produto.setCategoria(produtoAtualizado.getCategoria());
            produto.setSabor(produtoAtualizado.getSabor());
            produto.setPreco(produtoAtualizado.getPreco());

            return true;
        }

        return false;
    }

    // DELETE
    public boolean excluir(int id) {

        Produto produto = buscarPorId(id);

        if (produto != null) {
            produtos.remove(produto);
            return true;
        }

        return false;
    }
}