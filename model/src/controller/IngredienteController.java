package controller;

import model.Ingrediente;
import service.IngredienteService;

import java.util.List;

public class IngredienteController {

    private final IngredienteService service;

    public IngredienteController(IngredienteService service) {
        this.service = service;
    }

    // CREATE
    public Ingrediente cadastrarIngrediente(String nome, String categoria, Double quantidade, String unidadeMedida) {
        return service.cadastrarIngrediente(nome, categoria, quantidade, unidadeMedida);
    }

    public Ingrediente cadastrarIngrediente(Ingrediente ingrediente) {
        return service.cadastrarIngrediente(ingrediente);
    }

    // READ
    public List<Ingrediente> listarIngredientes() {
        return service.listarTodos();
    }

    public Ingrediente buscarIngrediente(Long id) {
        return service.buscarPorId(id);
    }

    // UPDATE
    public boolean atualizarIngrediente(Ingrediente ingrediente) {
        return service.atualizarIngrediente(ingrediente);
    }

    // DELETE
    public boolean excluirIngrediente(Long id) {
        return service.removerIngrediente(id);
    }
}
