package com.inventario.parque.kyqa.InventarioKyqa.Repository;

import com.inventario.parque.kyqa.InventarioKyqa.Entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InventarioRepository extends JpaRepository<Inventario, Integer>, JpaSpecificationExecutor<Inventario> {
    @Transactional(readOnly = true)
    List<Inventario> findInventariosByAreaInventarioContainingIgnoreCase(String areaInventario);

    @Transactional(readOnly = true)
    List<Inventario> findInventariosByNombreObjetoContainingIgnoreCase(String nombreObjeto);

    @Transactional(readOnly = true)
    List<Inventario> findInventariosByObservacionesContainingIgnoreCase(String observaciones);

    @Transactional(readOnly = true)
    List<Inventario> findInventariosByDescripcionContainingIgnoreCase(String descripcion);
}