package controller;

import model.Produto;
import service.ProdutoService;

import java.util.List;

public class ProdutoController {

    private ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    // CREATE
    public boolean cadastrarProduto(Produto produto) {
        return service.adicionar(produto);
    }

    // READ - listar
    public List<Produto> listarProdutos() {
        return service.listarTodos();
    }

    // READ - buscar
    public Produto buscarProduto(int id) {
        return service.buscarPorId(id);
    }

    // UPDATE
    public boolean atualizarProduto(Produto produto) {
        return service.atualizar(produto);
    }

    // DELETE
    public boolean excluirProduto(int id) {
        return service.excluir(id);
    }
}