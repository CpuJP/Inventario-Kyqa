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
@Entity(name = "Inventario")
@Table(name = "inventario")
public class Inventario{

    //Anotaciones Para JPA
    @Id
    @Column(name = "IdInventario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventario;

    @Column(name = "NombreObjeto", nullable = false, length = 50)
    private String NombreObjeto;

    @Column(name = "Descripcion", length = 150)
    private String Descripcion;

    @Column(name = "Total", nullable = false)
    private Integer Total;

    @Column(name = "Disponible", nullable = false)
    private Integer Disponible;

    @Column(name = "Observaciones", length = 150)
    private String Observacion;

    @Column(name = "Foto")
    private String Foto;

    @Column(name = "AreaInventario", length = 50, nullable = false)
    private String AreaInventario;

    //Relación de Muchos a Muchos Entre Inventario y Prestamos
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "inventario_prestamo",
            joinColumns = @JoinColumn(name = "id_inventario", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_prestamo", nullable = false))
    private Set<Prestamo> prestamos;
}
