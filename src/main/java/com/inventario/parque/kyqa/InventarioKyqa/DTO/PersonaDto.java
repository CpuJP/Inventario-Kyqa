package com.inventario.parque.kyqa.InventarioKyqa.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.inventario.parque.kyqa.InventarioKyqa.Entity.Persona} entity
 */
@Data
public class PersonaDto implements Serializable {
    private final Long idPersona;
    private final String Documento;
    private final String PrimerNombre;
    private final String SegundoNombre;
    private final String PrimerApellido;
    private final String SegundoApellido;
}