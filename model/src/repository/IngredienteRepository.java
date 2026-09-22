package repository;

import model.Ingrediente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IngredienteRepository {

    private final List<Ingrediente> tabelaIngredientes = new ArrayList<>();
    private Long idSequence = 1L;

    // Create / Save
    public Ingrediente salvar(Ingrediente ingrediente) {
        if (ingrediente.getId() == null) {
            ingrediente.setId(idSequence++);
            tabelaIngredientes.add(ingrediente);
        } else {
            atualizar(ingrediente);
        }
        return ingrediente;
    }

    // Read All
    public List<Ingrediente> buscarTodos() {
        return new ArrayList<>(tabelaIngredientes);
    }

    // Read by ID
    public Optional<Ingrediente> buscarPorId(Long id) {
        return tabelaIngredientes.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }

    // Update
    public void atualizar(Ingrediente ingredienteAtualizado) {
        buscarPorId(ingredienteAtualizado.getId()).ifPresent(ingrediente -> {
            ingrediente.setNome(ingredienteAtualizado.getNome());
            ingrediente.setCategoria(ingredienteAtualizado.getCategoria());
            ingrediente.setQuantidade(ingredienteAtualizado.getQuantidade());
            ingrediente.setUnidadeMedida(ingredienteAtualizado.getUnidadeMedida());
        });
    }

    // Delete
    public boolean deletar(Long id) {
        return tabelaIngredientes.removeIf(i -> i.getId().equals(id));
    }
}
