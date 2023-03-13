/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MM
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByNombreConyugue", query = "SELECT c FROM Cliente c WHERE c.nombreConyugue = :nombreConyugue")
    , @NamedQuery(name = "Cliente.findByApellidoConyugue", query = "SELECT c FROM Cliente c WHERE c.apellidoConyugue = :apellidoConyugue")
    , @NamedQuery(name = "Cliente.findByEdadConyugue", query = "SELECT c FROM Cliente c WHERE c.edadConyugue = :edadConyugue")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_conyugue")
    private String nombreConyugue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido_conyugue")
    private String apellidoConyugue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad_conyugue")
    private int edadConyugue;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "direccion_conyugue")
    private String direccionConyugue;
    @JoinTable(name = "cliente_has_solicitud", joinColumns = {
        @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")}, inverseJoinColumns = {
        @JoinColumn(name = "id_solicitud", referencedColumnName = "id_solicitud")})
    @ManyToMany
    private Collection<Solicitud> solicitudCollection;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<Solicitud> solicitudCollection1;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nombreConyugue, String apellidoConyugue, int edadConyugue, String direccionConyugue) {
        this.idCliente = idCliente;
        this.nombreConyugue = nombreConyugue;
        this.apellidoConyugue = apellidoConyugue;
        this.edadConyugue = edadConyugue;
        this.direccionConyugue = direccionConyugue;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreConyugue() {
        return nombreConyugue;
    }

    public void setNombreConyugue(String nombreConyugue) {
        this.nombreConyugue = nombreConyugue;
    }

    public String getApellidoConyugue() {
        return apellidoConyugue;
    }

    public void setApellidoConyugue(String apellidoConyugue) {
        this.apellidoConyugue = apellidoConyugue;
    }

    public int getEdadConyugue() {
        return edadConyugue;
    }

    public void setEdadConyugue(int edadConyugue) {
        this.edadConyugue = edadConyugue;
    }

    public String getDireccionConyugue() {
        return direccionConyugue;
    }

    public void setDireccionConyugue(String direccionConyugue) {
        this.direccionConyugue = direccionConyugue;
    }

    @XmlTransient
    public Collection<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(Collection<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @XmlTransient
    public Collection<Solicitud> getSolicitudCollection1() {
        return solicitudCollection1;
    }

    public void setSolicitudCollection1(Collection<Solicitud> solicitudCollection1) {
        this.solicitudCollection1 = solicitudCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
