package com.inventario.parque.kyqa.InventarioKyqa.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = Prestamo.ENTITY_NAME)
@Table(name = Prestamo.TABLE_NAME, schema = "kyqa", indexes = {
        @Index(name = "fk_Prestamo_Persona_idx", columnList = "Persona_idPersona"),
        @Index(name = "fk_Prestamo_Inventario1_idx", columnList = "Inventario_idInventario")
})
public class Prestamo implements Serializable {
    public static final String ENTITY_NAME = "Prestamo";
    public static final String TABLE_NAME = "prestamo";
    public static final String COLUMN_ID_NAME = "idPrestamo";
    public static final String COLUMN_FECHASALIDA_NAME = "fechaSalida";
    public static final String COLUMN_ESTADOSALIDA_NAME = "estadoSalida";
    public static final String COLUMN_FIRMASALIDA_NAME = "firmaSalida";
    public static final String COLUMN_FECHAINGRESO_NAME = "fechaIngreso";
    public static final String COLUMN_ESTADOINGRESO_NAME = "estadoIngreso";
    public static final String COLUMN_FIRMAINGRESO_NAME = "firmaIngreso";
    public static final String COLUMN_AREA_NAME = "area";
    private static final long serialVersionUID = 5703408910511441330L;


    private Integer id;

    private Persona personaIdpersona;

    private Inventario inventarioIdinventario;

    private Instant fechaSalida;

    private String estadoSalida;

    private String firmaSalida;

    private Instant fechaIngreso;

    private String estadoIngreso;

    private String firmaIngreso;

    private String area;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    @MapsId("personaIdpersona")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Persona_idPersona", nullable = false)
    public Persona getPersonaIdpersona() {
        return personaIdpersona;
    }

    @MapsId("inventarioIdinventario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Inventario_idInventario", nullable = false)
    public Inventario getInventarioIdinventario() {
        return inventarioIdinventario;
    }

    @Column(name = COLUMN_FECHASALIDA_NAME)
    public Instant getFechaSalida() {
        return fechaSalida;
    }

    @Size(max = 45)
    @Column(name = COLUMN_ESTADOSALIDA_NAME, length = 45)
    public String getEstadoSalida() {
        return estadoSalida;
    }

    @Size(max = 45)
    @Column(name = COLUMN_FIRMASALIDA_NAME, length = 45)
    public String getFirmaSalida() {
        return firmaSalida;
    }

    @Column(name = COLUMN_FECHAINGRESO_NAME)
    public Instant getFechaIngreso() {
        return fechaIngreso;
    }

    @Size(max = 45)
    @Column(name = COLUMN_ESTADOINGRESO_NAME, length = 45)
    public String getEstadoIngreso() {
        return estadoIngreso;
    }

    @Size(max = 45)
    @Column(name = COLUMN_FIRMAINGRESO_NAME, length = 45)
    public String getFirmaIngreso() {
        return firmaIngreso;
    }

    @Size(max = 45)
    @Column(name = COLUMN_AREA_NAME, length = 45)
    public String getArea() {
        return area;
    }

}