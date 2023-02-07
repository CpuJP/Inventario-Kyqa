package com.inventario.parque.kyqa.InventarioKyqa.DTO;

import com.inventario.parque.kyqa.InventarioKyqa.Entity.Prestamo;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

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
    private final Set<Prestamo> prestamos;
}