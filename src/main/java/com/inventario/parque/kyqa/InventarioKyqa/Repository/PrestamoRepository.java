package com.inventario.parque.kyqa.InventarioKyqa.Repository;

import com.inventario.parque.kyqa.InventarioKyqa.Entity.Prestamo;
import com.inventario.parque.kyqa.InventarioKyqa.Entity.PrestamoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrestamoRepository extends JpaRepository<Prestamo, PrestamoId>, JpaSpecificationExecutor<Prestamo> {
}