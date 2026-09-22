package factory;

import model.Cliente;

public class ClienteFactory {

    public Cliente criarCliente(int id, String nome, String telefone, String email) {
        return new Cliente(id, nome, telefone, email);
    }
}
