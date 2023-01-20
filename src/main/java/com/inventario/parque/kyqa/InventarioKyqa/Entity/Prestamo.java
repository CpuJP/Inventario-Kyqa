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

    //Relación de Muchos a Muchos Entre Inventario y Prestamos
    @ManyToMany(mappedBy = "prestamos")
    private Set<Inventario> inventarios;

    //Relación de Muchos a Muchos Entre Persona y Prestamos
    @ManyToMany(mappedBy = "prestamos")
    private Set<Persona> personas;

    //Getters y Setters
    public Long getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Long idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Calendar getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(Calendar fechaSalida) {
        FechaSalida = fechaSalida;
    }

    public Estado getEstadoSalida() {
        return EstadoSalida;
    }

    public void setEstadoSalida(Estado estadoSalida) {
        EstadoSalida = estadoSalida;
    }

    public String getFirmaSalida() {
        return FirmaSalida;
    }

    public void setFirmaSalida(String firmaSalida) {
        FirmaSalida = firmaSalida;
    }

    public Calendar getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Calendar fechaIngreso) {
        FechaIngreso = fechaIngreso;
    }

    public Estado getEstadoIngreso() {
        return EstadoIngreso;
    }

    public void setEstadoIngreso(Estado estadoIngreso) {
        EstadoIngreso = estadoIngreso;
    }

    public String getFirmaIngreso() {
        return FirmaIngreso;
    }

    public void setFirmaIngreso(String firmaIngreso) {
        FirmaIngreso = firmaIngreso;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public Set<Inventario> getInventarios() {
        return inventarios;
    }

    public void setInventarios(Set<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }

    //Creación de plantilla builder
    public Prestamo(Long idPrestamo, Calendar FechaSalida, Estado EstadoSalida, String firmaSalida, Calendar fechaIngreso, Estado estadoIngreso, String firmaIngreso, String area){
    }

    //Creación del Builder
    public static class Builder {
        private Long idPrestamo;
        private Calendar FechaSalida;
        private Estado EstadoSalida;
        private String FirmaSalida;
        private Calendar FechaIngreso;
        private Estado EstadoIngreso;
        private String FirmaIngreso;
        private String Area;

        //Creación Método Build
        Prestamo build() {
            return new Prestamo(this.idPrestamo, this.FechaSalida, this.EstadoSalida, this.FirmaSalida,
                    this.FechaIngreso, this.EstadoIngreso, this.FirmaIngreso, this.Area);
        }

        //Getters y Setters Builder

        public Long getIdPrestamo() {
            return idPrestamo;
        }

        public Builder setIdPrestamo(Long idPrestamo) {
            this.idPrestamo = idPrestamo;
            return this;
        }

        public Calendar getFechaSalida() {
            return FechaSalida;
        }

        public Builder setFechaSalida(Calendar fechaSalida) {
            FechaSalida = fechaSalida;
            return this;
        }

        public Estado getEstadoSalida() {
            return EstadoSalida;
        }

        public Builder setEstadoSalida(Estado estadoSalida) {
            EstadoSalida = estadoSalida;
            return this;
        }

        public String getFirmaSalida() {
            return FirmaSalida;
        }

        public Builder setFirmaSalida(String firmaSalida) {
            FirmaSalida = firmaSalida;
            return this;
        }

        public Calendar getFechaIngreso() {
            return FechaIngreso;
        }

        public Builder setFechaIngreso(Calendar fechaIngreso) {
            FechaIngreso = fechaIngreso;
            return this;
        }

        public Estado getEstadoIngreso() {
            return EstadoIngreso;
        }

        public Builder setEstadoIngreso(Estado estadoIngreso) {
            EstadoIngreso = estadoIngreso;
            return this;
        }

        public String getFirmaIngreso() {
            return FirmaIngreso;
        }

        public Builder setFirmaIngreso(String firmaIngreso) {
            FirmaIngreso = firmaIngreso;
            return this;
        }

        public String getArea() {
            return Area;
        }

        public Builder setArea(String area) {
            Area = area;
            return this;
        }
    }
}
