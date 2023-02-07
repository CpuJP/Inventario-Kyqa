package com.inventario.parque.kyqa.InventarioKyqa.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = Persona.ENTITY_NAME)
@Table(name = Persona.TABLE_NAME, schema = "kyqa", indexes = {
        @Index(name = "celular_UNIQUE", columnList = "celular", unique = true)
})
public class Persona implements Serializable {
    public static final String ENTITY_NAME = "Persona";
    public static final String TABLE_NAME = "persona";
    public static final String COLUMN_ID_NAME = "idPersona";
    public static final String COLUMN_DOCUMENTO_NAME = "documento";
    public static final String COLUMN_PRIMERNOMBRE_NAME = "primerNombre";
    public static final String COLUMN_SEGUNDONOMBRE_NAME = "segundoNombre";
    public static final String COLUMN_PRIMERAPELLIDO_NAME = "primerApellido";
    public static final String COLUMN_SEGUNDOAPELLIDO_NAME = "segundoApellido";
    public static final String COLUMN_CELULAR_NAME = "celular";
    private static final long serialVersionUID = -7797848499666670300L;


    private Integer id;

    private String documento;

    private String primerNombre;

    private String segundoNombre;

    private String primerApellido;

    private String segundoApellido;

    private String celular;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    public Integer getId() {
        return id;
    }

    @Size(max = 20)
    @NotNull
    @Column(name = COLUMN_DOCUMENTO_NAME, nullable = false, length = 20)
    public String getDocumento() {
        return documento;
    }

    @Size(max = 45)
    @NotNull
    @Column(name = COLUMN_PRIMERNOMBRE_NAME, nullable = false, length = 45)
    public String getPrimerNombre() {
        return primerNombre;
    }

    @Size(max = 100)
    @Column(name = COLUMN_SEGUNDONOMBRE_NAME, length = 100)
    public String getSegundoNombre() {
        return segundoNombre;
    }

    @Size(max = 45)
    @NotNull
    @Column(name = COLUMN_PRIMERAPELLIDO_NAME, nullable = false, length = 45)
    public String getPrimerApellido() {
        return primerApellido;
    }

    @Size(max = 100)
    @Column(name = COLUMN_SEGUNDOAPELLIDO_NAME, length = 100)
    public String getSegundoApellido() {
        return segundoApellido;
    }

    @Size(max = 15)
    @Column(name = COLUMN_CELULAR_NAME, length = 15)
    public String getCelular() {
        return celular;
    }

}