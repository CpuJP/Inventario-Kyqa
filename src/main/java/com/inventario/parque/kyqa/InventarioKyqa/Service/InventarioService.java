package com.inventario.parque.kyqa.InventarioKyqa.Service;

import com.inventario.parque.kyqa.InventarioKyqa.Entity.Inventario;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

public interface InventarioService {
    List<Inventario> findAll();
    List<Inventario> findByAreaInventario(@PathVariable String areaInventario);
    List<Inventario> findByNombreObjeto(@PathVariable String nombreObjeto);
    List<Inventario> findByObservacion(@PathVariable String observacion);
    List<Inventario> findByDescripcion(@PathVariable String descripcion);
    ResponseEntity<Inventario> findById(@PathVariable Integer id);
    ResponseEntity<Inventario> existsById(@PathVariable Integer id);
    ResponseEntity<Inventario> createInventario(@RequestBody Inventario inventario, @RequestHeader HttpHeaders headers);
    ResponseEntity<Inventario> updateInventario(@RequestBody Inventario inventario);
    ResponseEntity<Inventario> deleteInventario(@RequestBody Integer id);
}
