package com.inventario.parque.kyqa.InventarioKyqa.Repository;

import com.inventario.parque.kyqa.InventarioKyqa.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Integer>, JpaSpecificationExecutor<Persona> {
    @Transactional(readOnly = true)
    Optional<Persona> findByDocumento(String documento);

    @Transactional(readOnly = true)
    List<Persona> findByPrimerApellidoLike(String lastname);

    @Transactional(readOnly = true)
    Boolean existsPersonaByDocumento(String documento);

    @Transactional(readOnly = true)
    Boolean existsPersonaByCelular(String celular);
}