package model;

import strategy.EstoqueStrategy;

public class Ingrediente {

    private Long id;
    private String nome;
    private String categoria;
    private Double quantidade;
    private String unidadeMedida;

    public Ingrediente() {}

    public Ingrediente(Long id, String nome, String categoria, Double quantidade, String unidadeMedida) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    // GoF Strategy - Avaliação de status do estoque com base em estratégia dinâmica
    public String verificarStatusEstoque(EstoqueStrategy strategy) {
        return strategy.avaliarEstoque(this.quantidade != null ? this.quantidade : 0.0);
    }

    // GRASP Information Expert - O próprio Ingrediente conhece e valida seus atributos
    public boolean dadosValidos() {
        return nome != null && !nome.isBlank()
                && quantidade != null && quantidade >= 0
                && unidadeMedida != null && !unidadeMedida.isBlank();
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", quantidade=" + quantidade +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                '}';
    }
}
