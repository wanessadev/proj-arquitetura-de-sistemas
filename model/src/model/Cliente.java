package model;

import strategy.DescontoClienteStrategy;

public class Cliente {

    private int id;
    private String nome;
    private String telefone;
    private String email;

    public Cliente(int id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // GoF Strategy - Cálculo de valor com desconto com base no perfil do cliente
    public double calcularTotalComDesconto(DescontoClienteStrategy strategy, double total) {
        return strategy.aplicarDesconto(total);
    }

    // GRASP Information Expert - O próprio Cliente conhece suas informações e valida seus dados
    public boolean dadosValidos() {
        return nome != null && !nome.isBlank()
                && telefone != null && !telefone.isBlank();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
