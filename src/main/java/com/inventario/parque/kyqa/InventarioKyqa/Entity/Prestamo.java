package com.inventario.parque.kyqa.InventarioKyqa.Entity;

import com.inventario.parque.kyqa.InventarioKyqa.Enum.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.Set;

//Anotaciones Para Lombok
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "Prestamo")
@Table(name = "prestamo")
public class Prestamo {

    //Anotaciones Para JPA
    @Id
    @Column(name = "IdPrestamo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestamo;

    @Column(name = "FechaSalida", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar FechaSalida;

    @Column(name = "EstadoSalida", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Estado EstadoSalida;

    @Column(name = "FirmaSalida", nullable = false)
    private String FirmaSalida;

    @Column(name = "FechaIngreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar FechaIngreso;

    @Column(name = "EstadoIngreso")
    @Enumerated(value = EnumType.STRING)
    private Estado EstadoIngreso;

    @Column(name = "FirmaIngreso")
    private String FirmaIngreso;

    @Column(name = "Area", length = 50)
    private String Area;

    //Relación de Muchos a Muchos Entre Inventario y Prestamos
    @ManyToMany(mappedBy = "prestamos")
    private Set<Inventario> inventarios;

    //Relación de Muchos a Muchos Entre Persona y Prestamos
    @ManyToMany(mappedBy = "prestamos")
    private Set<Persona> personas;
}