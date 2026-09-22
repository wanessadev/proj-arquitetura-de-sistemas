package service;

import model.Ingrediente;
import repository.IngredienteRepository;

import java.util.List;

public class IngredienteService {

    private final IngredienteRepository repository;

    public IngredienteService(IngredienteRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Ingrediente cadastrarIngrediente(String nome, String categoria, Double quantidade, String unidadeMedida) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do ingrediente é obrigatório.");
        }

        if (quantidade == null || quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }

        Ingrediente novoIngrediente = new Ingrediente(null, nome, categoria, quantidade, unidadeMedida);
        return repository.salvar(novoIngrediente);
    }

    public Ingrediente cadastrarIngrediente(Ingrediente ingrediente) {
        if (ingrediente == null || !ingrediente.dadosValidos()) {
            throw new IllegalArgumentException("Dados do ingrediente inválidos.");
        }
        return repository.salvar(ingrediente);
    }

    // READ ALL
    public List<Ingrediente> listarTodos() {
        return repository.buscarTodos();
    }

    // READ BY ID
    public Ingrediente buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Ingrediente não encontrado com ID: " + id));
    }

    // UPDATE
    public boolean atualizarIngrediente(Ingrediente ingrediente) {
        if (ingrediente == null || ingrediente.getId() == null) {
            return false;
        }

        if (ingrediente.getNome() == null || ingrediente.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do ingrediente é obrigatório.");
        }

        if (ingrediente.getQuantidade() == null || ingrediente.getQuantidade() < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }

        if (repository.buscarPorId(ingrediente.getId()).isEmpty()) {
            return false;
        }

        repository.atualizar(ingrediente);
        return true;
    }

    // DELETE
    public boolean removerIngrediente(Long id) {
        return repository.deletar(id);
    }
}
