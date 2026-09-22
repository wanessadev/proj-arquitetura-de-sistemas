package service;

import model.Cliente;
import repository.ClienteRepository;

import java.util.List;

public class ClienteService {

    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    // CREATE - Valida regras RN04, RN05 e RN06
    public boolean adicionar(Cliente cliente) {
        if (!cliente.dadosValidos()) {
            return false;
        }

        // RN04 - Cada cliente deve possuir um ID único
        if (repository.buscarPorId(cliente.getId()) != null) {
            return false;
        }

        repository.adicionar(cliente);
        return true;
    }

    // READ - listar todos
    public List<Cliente> listarTodos() {
        return repository.listarTodos();
    }

    // READ - buscar por ID
    public Cliente buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    // UPDATE
    public boolean atualizar(Cliente cliente) {
        if (!cliente.dadosValidos()) {
            return false;
        }

        if (repository.buscarPorId(cliente.getId()) == null) {
            return false;
        }

        return repository.atualizar(cliente);
    }

    // DELETE
    public boolean excluir(int id) {
        if (repository.buscarPorId(id) == null) {
            return false;
        }

        return repository.excluir(id);
    }
}
