package model;

public class Produto {

    private int id;
    private String nome;
    private String categoria;
    private String sabor;
    private double preco;

    public Produto(int id, String nome, String categoria, String sabor, double preco) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.sabor = sabor;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getSabor() {
        return sabor;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // GRASP Information Expert
    public boolean dadosValidos() {
        return nome != null
                && !nome.isBlank()
                && preco > 0;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", sabor='" + sabor + '\'' +
                ", preco=" + preco +
                '}';
    }
}