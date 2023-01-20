//TODO: Implemenmtar Buider, Get y Set normales y buider

package com.inventario.parque.kyqa.InventarioKyqa.Entity;

import com.inventario.parque.kyqa.InventarioKyqa.Enum.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "Prestamo")
@Table(name = "prestamo")
public class Prestamo {

    @Id
    @Column(name = "IDPrestamo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestamo;

    @Column(name = "fechasalida", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar FechaSalida;

    @Column(name = "estadosalida", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Estado EstadoSalida;

    @Column(name = "firmasalida")
    private String FirmaSalida;

    @Column(name = "fechaingreso", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar FechaIngreso;

    @Column(name = "estadoingreso")
    @Enumerated(value = EnumType.STRING)
    private Estado EstadoIngreso;

    @Column(name = "firmaingreso")
    private String FirmaIngreso;

    @Column(name = "area", length = 50)
    private String Area;

    @ManyToMany(mappedBy = "prestamos")
    private Set<Inventario> inventarios;

    @ManyToMany(mappedBy = "prestamos")
    private Set<Persona> personas;
}
