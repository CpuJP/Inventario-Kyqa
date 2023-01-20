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

    //Relación de Muchos a Muchos Entre Persona y Prestamo
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "persona_prestamo",
            joinColumns = @JoinColumn(name = "id_persona", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_prestamo", nullable = false))
    private Set<Prestamo> prestamos;

    //Getters y Setters
    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        Documento = documento;
    }

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        PrimerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        SegundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        PrimerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        SegundoApellido = segundoApellido;
    }

    public Set<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Set<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    //Creación de plantilla builder
    public Persona(Long idPersona, String documento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) {
    }

    public static class Builder {
        private Long idPersona;
        private String Documento;
        private String PrimerNombre;
        private String SegundoNombre;
        private String PrimerApellido;
        private String SegundoApellido;

        //Creación Método Builder
        Persona build() {
            return new Persona(this.idPersona, this.Documento, this.PrimerNombre,
                    this.SegundoNombre, this.PrimerApellido, this.SegundoApellido);
        }

        //Getters y Setters Builder
        public Long getIdPersona() {
            return idPersona;
        }

        public Builder setIdPersona(Long idPersona) {
            this.idPersona = idPersona;
            return this;
        }

        public String getDocumento() {
            return Documento;
        }

        public Builder setDocumento(String documento) {
            Documento = documento;
            return this;
        }

        public String getPrimerNombre() {
            return PrimerNombre;
        }

        public Builder setPrimerNombre(String primerNombre) {
            PrimerNombre = primerNombre;
            return this;
        }

        public String getSegundoNombre() {
            return SegundoNombre;
        }

        public Builder setSegundoNombre(String segundoNombre) {
            SegundoNombre = segundoNombre;
            return this;
        }

        public String getPrimerApellido() {
            return PrimerApellido;
        }

        public Builder setPrimerApellido(String primerApellido) {
            PrimerApellido = primerApellido;
            return this;
        }

        public String getSegundoApellido() {
            return SegundoApellido;
        }

        public Builder setSegundoApellido(String segundoApellido) {
            SegundoApellido = segundoApellido;
            return this;
        }
    }
}
