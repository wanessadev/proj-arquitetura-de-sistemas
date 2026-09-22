package strategy;

public class ClienteFidelidadeStrategy implements DescontoClienteStrategy {

    private double taxaDesconto;

    public ClienteFidelidadeStrategy(double taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    @Override
    public double aplicarDesconto(double valor) {
        return valor - (valor * taxaDesconto);
    }
}
