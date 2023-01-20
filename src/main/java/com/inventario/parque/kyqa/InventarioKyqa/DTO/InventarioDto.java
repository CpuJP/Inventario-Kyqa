package com.inventario.parque.kyqa.InventarioKyqa.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.inventario.parque.kyqa.InventarioKyqa.Entity.Inventario} entity
 */
@Data
public class InventarioDto implements Serializable {
    private final Long idInventario;
    private final String NombreObjeto;
    private final String Descripcion;
    private final Integer Total;
    private final Integer Disponible;
    private final String Observacion;
    private final String Foto;
    private final String AreaInventario;
}