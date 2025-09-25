package com.inventario.controller;

import com.inventario.model.Proveedor;
import com.inventario.repository.ProveedorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping
    public ResponseEntity<List<Proveedor>> getAll() {
        return ResponseEntity.ok(proveedorRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Proveedor> create(@Valid @RequestBody Proveedor proveedor) {
        Proveedor nuevoProveedor = proveedorRepository.save(proveedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProveedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(
            @PathVariable Long id,
            @Valid @RequestBody Proveedor proveedorActualizado) {

        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor no encontrado"));

        proveedor.setNombre(proveedorActualizado.getNombre());
        proveedor.setContacto(proveedorActualizado.getContacto());
        proveedor.setEmail(proveedorActualizado.getEmail());
        proveedor.setTelefono(proveedorActualizado.getTelefono());

        return ResponseEntity.ok(proveedorRepository.save(proveedor));
    }
}
