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
    @Column(name = "IDInventario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventario;

    @Column(name = "nombreobjeto", nullable = false, length = 50)
    private String NombreObjeto;

    @Column(name = "descripcion", length = 150)
    private String Descripcion;

    @Column(name = "total", nullable = false)
    private Integer Total;

    @Column(name = "disponible", nullable = false)
    private Integer Disponible;

    @Column(name = "observaciones", length = 150)
    private String Observacion;

    @Column(name = "foto")
    private String Foto;

    @Column(name = "areainventario", length = 50, nullable = false)
    private String AreaInventario;

    //Relación de Muchos a Muchos Entre Inventario y Prestamos
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "inventario_prestamo",
            joinColumns = @JoinColumn(name = "id_inventario", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_prestamo", nullable = false))
    private Set<Prestamo> prestamos;

    //Getters y Setters
    public Long getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Long idInventario) {
        this.idInventario = idInventario;
    }

    public String getNombreObjeto() {
        return NombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        NombreObjeto = nombreObjeto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Integer getTotal() {
        return Total;
    }

    public void setTotal(Integer total) {
        Total = total;
    }

    public Integer getDisponible() {
        return Disponible;
    }

    public void setDisponible(Integer disponible) {
        Disponible = disponible;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String observacion) {
        Observacion = observacion;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public String getAreaInventario() {
        return AreaInventario;
    }

    public void setAreaInventario(String areaInventario) {
        AreaInventario = areaInventario;
    }

    public Set<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Set<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    //Creación de plantilla builder
    public Inventario(Long idInventario, String nombreObjeto, String descripcion, Integer total, Integer disponible, String observacion, String foto, String areaInventario) {
    }

    //Creación del Builder
    public static class Builder {
        private Long idInventario;
        private String NombreObjeto;
        private String Descripcion;
        private Integer Total;
        private Integer Disponible;
        private String Observacion;
        private String Foto;
        private String AreaInventario;

        //Creación Método Build
        Inventario build() {
            return new Inventario(this.idInventario, this.NombreObjeto, this.Descripcion,
                    this.Total, this.Disponible, this.Observacion, this.Foto, this.AreaInventario);
        }

        //Getters y Setters Builder
        public Long getIdInventario() {
            return idInventario;
        }

        public Builder setIdInventario(Long idInventario) {
            this.idInventario = idInventario;
            return this;
        }

        public String getNombreObjeto() {
            return NombreObjeto;
        }

        public Builder setNombreObjeto(String nombreObjeto) {
            NombreObjeto = nombreObjeto;
            return this;
        }

        public String getDescripcion() {
            return Descripcion;
        }

        public Builder setDescripcion(String descripcion) {
            Descripcion = descripcion;
            return this;
        }

        public Integer getTotal() {
            return Total;
        }

        public Builder setTotal(Integer total) {
            Total = total;
            return this;
        }

        public Integer getDisponible() {
            return Disponible;
        }

        public Builder setDisponible(Integer disponible) {
            Disponible = disponible;
            return this;
        }

        public String getObservacion() {
            return Observacion;
        }

        public Builder setObservacion(String observacion) {
            Observacion = observacion;
            return this;
        }

        public String getFoto() {
            return Foto;
        }

        public Builder setFoto(String foto) {
            Foto = foto;
            return this;
        }

        public String getAreaInventario() {
            return AreaInventario;
        }

        public Builder setAreaInventario(String areaInventario) {
            AreaInventario = areaInventario;
            return this;
        }
    }
}
