package com.inventario.controller;

import com.inventario.model.Proveedor;
import com.inventario.model.Categoria;
import com.inventario.model.Producto;
import com.inventario.repository.CategoriaRepository;
import com.inventario.repository.ProductoRepository;
import com.inventario.repository.ProveedorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@Valid @RequestBody Producto producto) {
       Proveedor proveedorCompleto = proveedorRepository.findById(producto.getProveedor().getId())
                       .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Proveedor no válido o inexistente."));

       Categoria categoriaCompleta = categoriaRepository.findById(producto.getCategoria().getId())
                       .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoría no válida o inexistente."));

        producto.setProveedor(proveedorCompleto);
        producto.setCategoria(categoriaCompleta);

        Producto productoGuardado = productoRepository.save(producto);

        return ResponseEntity.status(HttpStatus.CREATED).body(productoGuardado);

    }
    @GetMapping
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        return productoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Long id, @Valid @RequestBody Producto productoActualizado) {
        return productoRepository.findById(id)
                .map(producto -> {
                    producto.setNombre(productoActualizado.getNombre());
                    producto.setPrecio(productoActualizado.getPrecio());
                    producto.setCantidad(productoActualizado.getCantidad());

                    if (productoActualizado.getProveedor() != null && productoActualizado.getProveedor().getId() != null) {
                        proveedorRepository.findById(productoActualizado.getProveedor().getId())
                                .ifPresent(producto::setProveedor);
                    }

                    if (productoActualizado.getCategoria() != null && productoActualizado.getCategoria().getId() != null) {
                        categoriaRepository.findById(productoActualizado.getCategoria().getId())
                                .ifPresent(producto::setCategoria);
                    }

                    return ResponseEntity.ok(productoRepository.save(producto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/proveedor/{proveedorId}")
    public ResponseEntity<List<Producto>> obtenerProductosPorProveedor(@PathVariable Long proveedorId) {
        List<Producto> productos = productoRepository.findByProveedorId(proveedorId);
        return ResponseEntity.ok(productos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        return productoRepository.findById(id)
                .map(producto -> {
                    productoRepository.delete(producto);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
