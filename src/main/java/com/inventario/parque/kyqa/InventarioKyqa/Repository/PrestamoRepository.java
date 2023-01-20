package com.inventario.parque.kyqa.InventarioKyqa.Repository;

import com.inventario.parque.kyqa.InventarioKyqa.Entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long>, JpaSpecificationExecutor<Prestamo> {
}