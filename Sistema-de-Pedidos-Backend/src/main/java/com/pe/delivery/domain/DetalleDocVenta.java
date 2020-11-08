/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.delivery.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DAYIRO
 */
@Entity
@Table(name = "detalle_doc_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleDocVenta.findAll", query = "SELECT d FROM DetalleDocVenta d"),
    @NamedQuery(name = "DetalleDocVenta.findByIdDetalleDocVenta", query = "SELECT d FROM DetalleDocVenta d WHERE d.idDetalleDocVenta = :idDetalleDocVenta"),
    @NamedQuery(name = "DetalleDocVenta.findByCantidad", query = "SELECT d FROM DetalleDocVenta d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleDocVenta.findBySubTotal", query = "SELECT d FROM DetalleDocVenta d WHERE d.subTotal = :subTotal")})
public class DetalleDocVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_doc_venta")
    private Integer idDetalleDocVenta;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "sub_total")
    private Long subTotal;
    @JoinColumn(name = "id_documento_venta", referencedColumnName = "id_documento_venta")
    @ManyToOne(optional = false)
    private DocumentoVenta idDocumentoVenta;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public DetalleDocVenta() {
    }

    public DetalleDocVenta(Integer idDetalleDocVenta) {
        this.idDetalleDocVenta = idDetalleDocVenta;
    }

    public Integer getIdDetalleDocVenta() {
        return idDetalleDocVenta;
    }

    public void setIdDetalleDocVenta(Integer idDetalleDocVenta) {
        this.idDetalleDocVenta = idDetalleDocVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Long subTotal) {
        this.subTotal = subTotal;
    }

    public DocumentoVenta getIdDocumentoVenta() {
        return idDocumentoVenta;
    }

    public void setIdDocumentoVenta(DocumentoVenta idDocumentoVenta) {
        this.idDocumentoVenta = idDocumentoVenta;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleDocVenta != null ? idDetalleDocVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleDocVenta)) {
            return false;
        }
        DetalleDocVenta other = (DetalleDocVenta) object;
        if ((this.idDetalleDocVenta == null && other.idDetalleDocVenta != null) || (this.idDetalleDocVenta != null && !this.idDetalleDocVenta.equals(other.idDetalleDocVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pe.delivery.domain.DetalleDocVenta[ idDetalleDocVenta=" + idDetalleDocVenta + " ]";
    }
    
}
