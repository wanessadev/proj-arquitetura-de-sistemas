package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private List<Cliente> clientes;

    public ClienteRepository() {
        clientes = new ArrayList<>();
    }

    // CREATE
    public void adicionar(Cliente cliente) {
        clientes.add(cliente);
    }

    // READ - listar todos
    public List<Cliente> listarTodos() {
        return clientes;
    }

    // READ - buscar por ID
    public Cliente buscarPorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    // UPDATE
    public boolean atualizar(Cliente clienteAtualizado) {
        Cliente cliente = buscarPorId(clienteAtualizado.getId());
        if (cliente != null) {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            cliente.setEmail(clienteAtualizado.getEmail());
            return true;
        }
        return false;
    }

    // DELETE
    public boolean excluir(int id) {
        Cliente cliente = buscarPorId(id);
        if (cliente != null) {
            clientes.remove(cliente);
            return true;
        }
        return false;
    }
}
