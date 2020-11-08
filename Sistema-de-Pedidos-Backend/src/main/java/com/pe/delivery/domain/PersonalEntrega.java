/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.delivery.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DAYIRO
 */
@Entity
@Table(name = "personal_entrega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalEntrega.findAll", query = "SELECT p FROM PersonalEntrega p"),
    @NamedQuery(name = "PersonalEntrega.findByIdPersonalEntrega", query = "SELECT p FROM PersonalEntrega p WHERE p.idPersonalEntrega = :idPersonalEntrega"),
    @NamedQuery(name = "PersonalEntrega.findByNombres", query = "SELECT p FROM PersonalEntrega p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "PersonalEntrega.findByApellidoPaterno", query = "SELECT p FROM PersonalEntrega p WHERE p.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "PersonalEntrega.findByApellidoMaterno", query = "SELECT p FROM PersonalEntrega p WHERE p.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "PersonalEntrega.findByNroDni", query = "SELECT p FROM PersonalEntrega p WHERE p.nroDni = :nroDni"),
    @NamedQuery(name = "PersonalEntrega.findByEstado", query = "SELECT p FROM PersonalEntrega p WHERE p.estado = :estado")})
public class PersonalEntrega implements Serializable {

    @OneToMany(mappedBy = "idPersonalEntrega")
    private Collection<Pedido> pedidoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_personal_entrega")
    private Integer idPersonalEntrega;
    @Size(max = 100)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 50)
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Size(max = 50)
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @Size(max = 8)
    @Column(name = "nro_dni")
    private String nroDni;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;

    public PersonalEntrega() {
    }

    public PersonalEntrega(Integer idPersonalEntrega) {
        this.idPersonalEntrega = idPersonalEntrega;
    }

    public Integer getIdPersonalEntrega() {
        return idPersonalEntrega;
    }

    public void setIdPersonalEntrega(Integer idPersonalEntrega) {
        this.idPersonalEntrega = idPersonalEntrega;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNroDni() {
        return nroDni;
    }

    public void setNroDni(String nroDni) {
        this.nroDni = nroDni;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonalEntrega != null ? idPersonalEntrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalEntrega)) {
            return false;
        }
        PersonalEntrega other = (PersonalEntrega) object;
        if ((this.idPersonalEntrega == null && other.idPersonalEntrega != null) || (this.idPersonalEntrega != null && !this.idPersonalEntrega.equals(other.idPersonalEntrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pe.delivery.domain.PersonalEntrega[ idPersonalEntrega=" + idPersonalEntrega + " ]";
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }
    
}
