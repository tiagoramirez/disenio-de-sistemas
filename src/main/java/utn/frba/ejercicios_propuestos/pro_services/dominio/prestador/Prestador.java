package utn.frba.ejercicios_propuestos.pro_services.dominio.prestador;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "prestador")
@Getter
@Setter
public class Prestador {
    @Id
    @GeneratedValue
    private Long id;

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

    @Transient
    private Reputacion reputacion;
}
