package com.inventario.parque.kyqa.InventarioKyqa.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

//Anotaciones Para Lombok
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "Persona")
@Table(name = "persona")
public class Persona {

    //Anotaciones Para JPA
    @Id
    @Column(name = "IdPersona", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @Column(name = "Documento", nullable = false)
    private String Documento;

    @Column(name = "PrimerNombre", length = 50, nullable = false)
    private String PrimerNombre;

    @Column(name = "SegundoNombre", length = 100)
    private String SegundoNombre;

    @Column(name = "PrimerApellido", length = 50, nullable = false)
    private String PrimerApellido;

    @Column(name = "SegundoApellido", length = 50)
    private String SegundoApellido;

    //Relación de Muchos a Muchos Entre Persona y Prestamo
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "persona_prestamo",
            joinColumns = @JoinColumn(name = "id_persona", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_prestamo", nullable = false))
    private Set<Prestamo> prestamos;
}