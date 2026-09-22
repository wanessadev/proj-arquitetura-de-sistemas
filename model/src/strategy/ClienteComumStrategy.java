package strategy;

public class ClienteComumStrategy implements DescontoClienteStrategy {

    @Override
    public double aplicarDesconto(double valor) {
        return valor;
    }
}
