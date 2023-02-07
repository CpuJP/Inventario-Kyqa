package com.inventario.parque.kyqa.InventarioKyqa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Embeddable
public class PrestamoId implements Serializable {
    public static final String COLUMN_IDPRESTAMO_NAME = "idPrestamo";
    public static final String COLUMN_PERSONAIDPERSONA_NAME = "Persona_idPersona";
    public static final String COLUMN_INVENTARIOIDINVENTARIO_NAME = "Inventario_idInventario";
    private static final long serialVersionUID = -8341880149765451721L;

    private Integer idPrestamo;

    private Integer personaIdpersona;

    private Integer inventarioIdinventario;

    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_IDPRESTAMO_NAME, nullable = false)
    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    @NotNull
    @Column(name = COLUMN_PERSONAIDPERSONA_NAME, nullable = false)
    public Integer getPersonaIdpersona() {
        return personaIdpersona;
    }

    @NotNull
    @Column(name = COLUMN_INVENTARIOIDINVENTARIO_NAME, nullable = false)
    public Integer getInventarioIdinventario() {
        return inventarioIdinventario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PrestamoId entity = (PrestamoId) o;
        return Objects.equals(this.inventarioIdinventario, entity.inventarioIdinventario) &&
                Objects.equals(this.idPrestamo, entity.idPrestamo) &&
                Objects.equals(this.personaIdpersona, entity.personaIdpersona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventarioIdinventario, idPrestamo, personaIdpersona);
    }

}