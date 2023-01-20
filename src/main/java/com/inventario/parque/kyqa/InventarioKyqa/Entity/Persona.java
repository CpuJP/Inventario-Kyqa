//TODO: Implemenmtar Buider, Get y Set normales y buider
package com.inventario.parque.kyqa.InventarioKyqa.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "Persona")
@Table(name = "persona")
public class Persona {

    @Id
    @Column(name = "IDPersona", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @Column(name = "documento")
    private String Documento;

    @Column(name = "primernombre", length = 50, nullable = false)
    private String PrimerNombre;

    @Column(name = "segundonombre", length = 100)
    private String SegundoNombre;

    @Column(name = "primerapellido", length = 50, nullable = false)
    private String PrimerApellido;

    @Column(name = "segundoapellido", length = 50)
    private String SegundoApellido;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "persona_prestamo",
            joinColumns = @JoinColumn(name = "id_persona", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_prestamo", nullable = false))
    private Set<Prestamo> prestamos;
}
