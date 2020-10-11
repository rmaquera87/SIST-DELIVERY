/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.delivery.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "estado_personal_entrega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPersonalEntrega.findAll", query = "SELECT e FROM EstadoPersonalEntrega e"),
    @NamedQuery(name = "EstadoPersonalEntrega.findByIdEstadoPersonalEntrega", query = "SELECT e FROM EstadoPersonalEntrega e WHERE e.idEstadoPersonalEntrega = :idEstadoPersonalEntrega"),
    @NamedQuery(name = "EstadoPersonalEntrega.findByDescripcion", query = "SELECT e FROM EstadoPersonalEntrega e WHERE e.descripcion = :descripcion")})
public class EstadoPersonalEntrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_personal_entrega")
    private Integer idEstadoPersonalEntrega;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoPersonalEntrega")
    private Collection<PersonalEntrega> personalEntregaCollection;

    public EstadoPersonalEntrega() {
    }

    public EstadoPersonalEntrega(Integer idEstadoPersonalEntrega) {
        this.idEstadoPersonalEntrega = idEstadoPersonalEntrega;
    }

    public Integer getIdEstadoPersonalEntrega() {
        return idEstadoPersonalEntrega;
    }

    public void setIdEstadoPersonalEntrega(Integer idEstadoPersonalEntrega) {
        this.idEstadoPersonalEntrega = idEstadoPersonalEntrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<PersonalEntrega> getPersonalEntregaCollection() {
        return personalEntregaCollection;
    }

    public void setPersonalEntregaCollection(Collection<PersonalEntrega> personalEntregaCollection) {
        this.personalEntregaCollection = personalEntregaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoPersonalEntrega != null ? idEstadoPersonalEntrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoPersonalEntrega)) {
            return false;
        }
        EstadoPersonalEntrega other = (EstadoPersonalEntrega) object;
        if ((this.idEstadoPersonalEntrega == null && other.idEstadoPersonalEntrega != null) || (this.idEstadoPersonalEntrega != null && !this.idEstadoPersonalEntrega.equals(other.idEstadoPersonalEntrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wesley.cursomc.domain.EstadoPersonalEntrega[ idEstadoPersonalEntrega=" + idEstadoPersonalEntrega + " ]";
    }
    
}
