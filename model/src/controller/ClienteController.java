package controller;

import model.Cliente;
import service.ClienteService;

import java.util.List;

public class ClienteController {

    private ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    // CREATE
    public boolean cadastrarCliente(Cliente cliente) {
        return service.adicionar(cliente);
    }

    // READ - listar
    public List<Cliente> listarClientes() {
        return service.listarTodos();
    }

    // READ - buscar
    public Cliente buscarCliente(int id) {
        return service.buscarPorId(id);
    }

    // UPDATE
    public boolean atualizarCliente(Cliente cliente) {
        return service.atualizar(cliente);
    }

    // DELETE
    public boolean excluirCliente(int id) {
        return service.excluir(id);
    }
}
