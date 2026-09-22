package factory;

import model.Ingrediente;

public class IngredienteFactory {

    public Ingrediente criarIngrediente(Long id, String nome, String categoria, Double quantidade, String unidadeMedida) {
        return new Ingrediente(id, nome, categoria, quantidade, unidadeMedida);
    }
}
