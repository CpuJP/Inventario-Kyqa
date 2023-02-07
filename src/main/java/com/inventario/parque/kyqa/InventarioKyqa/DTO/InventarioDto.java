package com.inventario.parque.kyqa.InventarioKyqa.DTO;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.inventario.parque.kyqa.InventarioKyqa.Entity.Inventario} entity
 */
@Data
public class InventarioDto implements Serializable {
    private final Integer id;
    @Size(max = 45)
    private final String nombreObjeto;
    @Size(max = 100)
    private final String descripcion;
    private final Integer total;
    private final Integer disponible;
    @Size(max = 45)
    private final String observaciones;
    @Size(max = 200)
    private final String foto;
    @Size(max = 45)
    private final String areaInventario;
}