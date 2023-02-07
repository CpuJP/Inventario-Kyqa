package com.inventario.parque.kyqa.InventarioKyqa.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.inventario.parque.kyqa.InventarioKyqa.Entity.Persona} entity
 */
@Data
public class PersonaDto implements Serializable {
    private final Integer id;
    @Size(max = 20)
    @NotNull
    private final String documento;
    @Size(max = 45)
    @NotNull
    private final String primerNombre;
    @Size(max = 100)
    private final String segundoNombre;
    @Size(max = 45)
    @NotNull
    private final String primerApellido;
    @Size(max = 100)
    private final String segundoApellido;
    @Size(max = 15)
    private final String celular;
}