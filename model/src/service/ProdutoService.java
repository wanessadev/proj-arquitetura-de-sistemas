package service;

import model.Produto;
import repository.ProdutoRepository;

import java.util.List;

public class ProdutoService {

    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public boolean adicionar(Produto produto) {

        if (produto.getNome() == null || produto.getNome().isBlank()) {
            return false;
        }

        if (produto.getPreco() <= 0) {
            return false;
        }

        if (repository.buscarPorId(produto.getId()) != null) {
            return false;
        }

        repository.adicionar(produto);
        return true;
    }

    // READ - listar todos
    public List<Produto> listarTodos() {
        return repository.listarTodos();
    }

    // READ - buscar por ID
    public Produto buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    // UPDATE
    public boolean atualizar(Produto produto) {

        if (produto.getNome() == null || produto.getNome().isBlank()) {
            return false;
        }

        if (produto.getPreco() <= 0) {
            return false;
        }

        if (repository.buscarPorId(produto.getId()) == null) {
            return false;
        }

        return repository.atualizar(produto);
    }

    // DELETE
    public boolean excluir(int id) {

        if (repository.buscarPorId(id) == null) {
            return false;
        }

        return repository.excluir(id);
    }
}