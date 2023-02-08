package com.inventario.parque.kyqa.InventarioKyqa.Service;

import com.inventario.parque.kyqa.InventarioKyqa.Entity.Inventario;
import com.inventario.parque.kyqa.InventarioKyqa.Exception.MessageBadRequestException;
import com.inventario.parque.kyqa.InventarioKyqa.Exception.MessageNotFoundException;
import com.inventario.parque.kyqa.InventarioKyqa.Repository.InventarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service(value = "inventarioService")
@Slf4j
public class InventarioServiceimpl implements InventarioService{

    private InventarioRepository inventarioRepository;

    public InventarioServiceimpl(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }
    @Override
    public List<Inventario> findAll() {
        return inventarioRepository.findAll();
    }

    @Override
    public List<Inventario> findByAreaInventario(String areaInventario) {
        return inventarioRepository.findInventariosByAreaInventarioContainingIgnoreCase(areaInventario);
    }

    @Override
    public List<Inventario> findByNombreObjeto(String nombreObjeto) {
        return inventarioRepository.findInventariosByNombreObjetoContainingIgnoreCase(nombreObjeto);
    }

    @Override
    public List<Inventario> findByObservacion(String observacion) {
        return inventarioRepository.findInventariosByObservacionesContainingIgnoreCase(observacion);
    }

    @Override
    public List<Inventario> findByDescripcion(String descripcion) {
        return inventarioRepository.findInventariosByDescripcionContainingIgnoreCase(descripcion);
    }

    @Override
    public ResponseEntity<Inventario> findById(Integer id) {
        Optional<Inventario> inventario = inventarioRepository.findById(id);
        return inventario.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Inventario> existsById(Integer id) {
        if (!inventarioRepository.existsById(id)) {
            log.warn("Inventario no encontrado");
            throw new MessageNotFoundException("Inventario no encontrado");
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Inventario> createInventario(Inventario inventario, HttpHeaders headers) {
        log.info(Objects.requireNonNull(headers.get("User-Agent")).toString());
        if (inventario.getAreaInventario() == null || inventario.getNombreObjeto() == null) {
            log.warn("El nombre y el área del inventario son obligatorios");
            throw new MessageBadRequestException("El nombre y el área del inventario son obligatorios");
        }
        Inventario result = inventarioRepository.save(inventario);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Inventario> updateInventario(Inventario inventario) {
        if (inventario.getId() == null) {
            log.warn("Intentando actualizar el inventario sin id");
            throw new MessageBadRequestException("Intentando actualizar el inventario sin id");
        }
        if (!inventarioRepository.existsById(inventario.getId())) {
            log.warn("El id " + inventario.getId() + " no existe");
            throw new MessageBadRequestException("El id " + inventario.getId() + " no existe");
        }
        Inventario result = inventarioRepository.save(inventario);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Inventario> deleteInventario(Integer id) {
        if (!inventarioRepository.existsById(id)) {
            log.warn("Intentando eliminar un inventario que no existe");
            throw new MessageBadRequestException("Intentando eliminar un inventario que no existe");
        }
        inventarioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
