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
@Table(name = "estado_doc_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoDocVenta.findAll", query = "SELECT e FROM EstadoDocVenta e"),
    @NamedQuery(name = "EstadoDocVenta.findByIdEstadoDocVenta", query = "SELECT e FROM EstadoDocVenta e WHERE e.idEstadoDocVenta = :idEstadoDocVenta"),
    @NamedQuery(name = "EstadoDocVenta.findByDescripcion", query = "SELECT e FROM EstadoDocVenta e WHERE e.descripcion = :descripcion")})
public class EstadoDocVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_doc_venta")
    private Integer idEstadoDocVenta;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoDocVenta")
    private Collection<DocumentoVenta> documentoVentaCollection;

    public EstadoDocVenta() {
    }

    public EstadoDocVenta(Integer idEstadoDocVenta) {
        this.idEstadoDocVenta = idEstadoDocVenta;
    }

    public Integer getIdEstadoDocVenta() {
        return idEstadoDocVenta;
    }

    public void setIdEstadoDocVenta(Integer idEstadoDocVenta) {
        this.idEstadoDocVenta = idEstadoDocVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<DocumentoVenta> getDocumentoVentaCollection() {
        return documentoVentaCollection;
    }

    public void setDocumentoVentaCollection(Collection<DocumentoVenta> documentoVentaCollection) {
        this.documentoVentaCollection = documentoVentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoDocVenta != null ? idEstadoDocVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoDocVenta)) {
            return false;
        }
        EstadoDocVenta other = (EstadoDocVenta) object;
        if ((this.idEstadoDocVenta == null && other.idEstadoDocVenta != null) || (this.idEstadoDocVenta != null && !this.idEstadoDocVenta.equals(other.idEstadoDocVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pe.delivery.domain.EstadoDocVenta[ idEstadoDocVenta=" + idEstadoDocVenta + " ]";
    }
    
}
