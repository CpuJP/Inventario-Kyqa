package com.inventario.parque.kyqa.InventarioKyqa.DTO;

import com.inventario.parque.kyqa.InventarioKyqa.Enum.Estado;
import lombok.Data;

import java.io.Serializable;
import java.util.Calendar;

/**
 * A DTO for the {@link com.inventario.parque.kyqa.InventarioKyqa.Entity.Prestamo} entity
 */
@Data
public class PrestamoDto implements Serializable {
    private final Long idPrestamo;
    private final Calendar FechaSalida;
    private final Estado EstadoSalida;
    private final String FirmaSalida;
    private final Calendar FechaIngreso;
    private final Estado EstadoIngreso;
    private final String FirmaIngreso;
    private final String Area;
}