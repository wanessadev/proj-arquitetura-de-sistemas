package strategy;

public class PrecoPromocionalStrategy implements PrecoStrategy {

    private double desconto;

    public PrecoPromocionalStrategy(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public double calcularPreco(double preco) {
        return preco - (preco * desconto);
    }
}