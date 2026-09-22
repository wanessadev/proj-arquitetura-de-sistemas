package strategy;

public class AlertaEstoqueMinimoStrategy implements EstoqueStrategy {

    private final double limiteMinimo;

    public AlertaEstoqueMinimoStrategy(double limiteMinimo) {
        this.limiteMinimo = limiteMinimo;
    }

    @Override
    public String avaliarEstoque(double quantidade) {
        if (quantidade <= limiteMinimo) {
            return "ALERTA CRÍTICO: Estoque baixo (" + quantidade + ")! Reabastecimento necessário.";
        }
        return "Estoque regular (" + quantidade + "). Nível suficiente para produção.";
    }
}
