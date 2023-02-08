package com.inventario.parque.kyqa.InventarioKyqa.Controller;

import com.inventario.parque.kyqa.InventarioKyqa.Entity.Inventario;
import com.inventario.parque.kyqa.InventarioKyqa.Repository.InventarioRepository;
import com.inventario.parque.kyqa.InventarioKyqa.Service.InventarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
@Slf4j
public class InventarioController {

    private InventarioRepository inventarioRepository;
    private InventarioService inventarioService;

    public InventarioController(InventarioRepository inventarioRepository, InventarioService inventarioService) {
        this.inventarioRepository = inventarioRepository;
        this.inventarioService = inventarioService;
    }

    @GetMapping("/all")
    public List<Inventario> findAll() {
        return inventarioService.findAll();
    }

    @GetMapping("/findinventariobyarea/{area}")
    public List<Inventario> findByAreaInventario(@PathVariable String area) {
        return inventarioService.findByAreaInventario(area);
    }

    @GetMapping("/findinventariobynombre/{nombre}")
    public List<Inventario> findByNombreObjeto(@PathVariable String nombre) {
        return inventarioService.findByNombreObjeto(nombre);
    }

    @GetMapping("/findinventariobyobservacion/{observacion}")
    public List<Inventario> findByObservacion(@PathVariable String observacion) {
        return inventarioService.findByObservacion(observacion);
    }

    @GetMapping("/findinventariobydescripcion/{descripcion}")
    public List<Inventario> findByDescripcion(@PathVariable String descripcion) {
        return inventarioService.findByDescripcion(descripcion);
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Inventario> findById(@PathVariable Integer id) {
        return inventarioService.findById(id);
    }

    @GetMapping("/existbyid/{id}")
    public ResponseEntity<Inventario> existsById(@PathVariable Integer id) {
        return inventarioService.existsById(id);
    }

    @PostMapping("/createinventario")
    public ResponseEntity<Inventario> save(@RequestBody Inventario inventario, @RequestHeader HttpHeaders headers) {
        return inventarioService.createInventario(inventario, headers);
    }

    @PutMapping("/updateinventario")
    public ResponseEntity<Inventario> updateInventario(@RequestBody Inventario inventario) {
        return inventarioService.updateInventario(inventario);
    }

    @DeleteMapping("/deleteinventario/{id}")
    public ResponseEntity<Inventario> deleteInventario(@PathVariable Integer id) {
        return inventarioService.deleteInventario(id);
    }
}
