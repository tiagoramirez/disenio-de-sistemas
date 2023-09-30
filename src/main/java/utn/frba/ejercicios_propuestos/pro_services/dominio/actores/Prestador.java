package utn.frba.ejercicios_propuestos.pro_services.dominio.actores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import utn.frba.ejercicios_propuestos.pro_services.datos.Persistente;
import utn.frba.ejercicios_propuestos.pro_services.dominio.actores.reputaciones.Reputacion;
import utn.frba.ejercicios_propuestos.pro_services.dominio.actores.reputaciones.ReputacionBuena;

@Entity
@Table(name = "prestador")
@Getter
@Setter
public class Prestador extends Persistente {
    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String foto;

    @Column
    private String nroDocumento;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaNacimiento;

    @Column
    private String cuitCuil;

    @ElementCollection
    @CollectionTable(name = "prestador_email", joinColumns = @JoinColumn(name = "prestador_id"))
    @Column(name = "email")
    private Set<String> emails;

    @ElementCollection
    @CollectionTable(name = "prestador_telefono", joinColumns = @JoinColumn(name = "prestador_id"))
    @Column(name = "telefono")
    private Set<String> telefonos;

    @OneToMany
    @JoinColumn(name = "prestador_id", referencedColumnName = "id")
    private List<Disponibilidad> disponibilidades;

    @OneToOne
    @JoinColumn(name = "reputacion_id", referencedColumnName = "id")
    private Reputacion reputacion;

    public Prestador() {
        this.emails = new HashSet<String>();
        this.telefonos = new HashSet<String>();
        this.disponibilidades = new ArrayList<Disponibilidad>();
    }

    public Prestador(String nombre, String apellido, String nroDocumento, TipoDocumento tipoDocumento,
            LocalDate fechaNacimiento, String cuitCuil, Set<String> emails, Set<String> telefonos,
            List<Disponibilidad> disponibilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.foto = "";
        this.nroDocumento = nroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.cuitCuil = cuitCuil;
        this.emails = emails;
        this.telefonos = telefonos;
        this.disponibilidades = disponibilidades;
        this.reputacion = new ReputacionBuena();
    }

}
