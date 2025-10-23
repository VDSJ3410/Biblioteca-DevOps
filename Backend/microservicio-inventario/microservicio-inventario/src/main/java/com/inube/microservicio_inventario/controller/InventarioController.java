package com.inube.microservicio_inventario.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.inube.microservicio_inventario.model.Inventario;
import com.inube.microservicio_inventario.service.InventarioService;

@RestController
@RequestMapping("/inventarios")
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    public List<Inventario> listar() {
        return inventarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Inventario> obtenerPorId(@PathVariable Long id) {
        return inventarioService.buscarPorId(id);
    }

    @PostMapping
    public Inventario crear(@RequestBody Inventario inventario) {
        return inventarioService.guardar(inventario);
    }

    @PutMapping("/{id}")
    public Inventario actualizar(@PathVariable Long id, @RequestBody Inventario inventario) {
        inventario.setIdInventario(id);
        return inventarioService.guardar(inventario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        inventarioService.eliminar(id);
    }
}


