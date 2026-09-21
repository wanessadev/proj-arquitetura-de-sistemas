package factory;

import model.Produto;

public class ProdutoFactory {

    public Produto criarProduto(
            int id,
            String nome,
            String categoria,
            String sabor,
            double preco) {

        return new Produto(
                id,
                nome,
                categoria,
                sabor,
                preco
        );
    }
}