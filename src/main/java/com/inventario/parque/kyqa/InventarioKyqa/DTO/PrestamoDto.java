package com.inventario.parque.kyqa.InventarioKyqa.DTO;

import com.inventario.parque.kyqa.InventarioKyqa.Entity.PrestamoId;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.inventario.parque.kyqa.InventarioKyqa.Entity.Prestamo} entity
 */
@Data
public class PrestamoDto implements Serializable {
    private final PrestamoId id;
    private final PersonaDto personaIdpersona;
    private final InventarioDto inventarioIdinventario;
    private final Instant fechaSalida;
    @Size(max = 45)
    private final String estadoSalida;
    @Size(max = 45)
    private final String firmaSalida;
    private final Instant fechaIngreso;
    @Size(max = 45)
    private final String estadoIngreso;
    @Size(max = 45)
    private final String firmaIngreso;
    @Size(max = 45)
    private final String area;
}