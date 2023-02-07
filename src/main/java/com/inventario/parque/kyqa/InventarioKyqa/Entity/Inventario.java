package com.inventario.parque.kyqa.InventarioKyqa.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = Inventario.ENTITY_NAME)
@Table(name = Inventario.TABLE_NAME, schema = "kyqa")
public class Inventario implements Serializable {
    public static final String ENTITY_NAME = "Inventario";
    public static final String TABLE_NAME = "inventario";
    public static final String COLUMN_ID_NAME = "idInventario";
    public static final String COLUMN_NOMBREOBJETO_NAME = "nombreObjeto";
    public static final String COLUMN_DESCRIPCION_NAME = "descripcion";
    public static final String COLUMN_TOTAL_NAME = "total";
    public static final String COLUMN_DISPONIBLE_NAME = "disponible";
    public static final String COLUMN_OBSERVACIONES_NAME = "observaciones";
    public static final String COLUMN_FOTO_NAME = "foto";
    public static final String COLUMN_AREAINVENTARIO_NAME = "areaInventario";
    private static final long serialVersionUID = 7595057014807523670L;


    private Integer id;

    private String nombreObjeto;

    private String descripcion;

    private Integer total;

    private Integer disponible;

    private String observaciones;

    private String foto;

    private String areaInventario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    @Size(max = 45)
    @Column(name = COLUMN_NOMBREOBJETO_NAME, length = 45)
    public String getNombreObjeto() {
        return nombreObjeto;
    }

    @Size(max = 100)
    @Column(name = COLUMN_DESCRIPCION_NAME, length = 100)
    public String getDescripcion() {
        return descripcion;
    }

    @Column(name = COLUMN_TOTAL_NAME)
    public Integer getTotal() {
        return total;
    }

    @Column(name = COLUMN_DISPONIBLE_NAME)
    public Integer getDisponible() {
        return disponible;
    }

    @Size(max = 45)
    @Column(name = COLUMN_OBSERVACIONES_NAME, length = 45)
    public String getObservaciones() {
        return observaciones;
    }

    @Size(max = 200)
    @Column(name = COLUMN_FOTO_NAME, length = 200)
    public String getFoto() {
        return foto;
    }

    @Size(max = 45)
    @Column(name = COLUMN_AREAINVENTARIO_NAME, length = 45)
    public String getAreaInventario() {
        return areaInventario;
    }

}