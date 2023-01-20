package com.inventario.parque.kyqa.InventarioKyqa.Repository;

import com.inventario.parque.kyqa.InventarioKyqa.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonaRepository extends JpaRepository<Persona, Long>, JpaSpecificationExecutor<Persona> {
}