package com.inventario.parque.kyqa.InventarioKyqa.Repository;

import com.inventario.parque.kyqa.InventarioKyqa.Entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InventarioRepository extends JpaRepository<Inventario, Long>, JpaSpecificationExecutor<Inventario> {
}