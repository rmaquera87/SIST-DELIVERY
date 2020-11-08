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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "documento_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoVenta.findAll", query = "SELECT d FROM DocumentoVenta d"),
    @NamedQuery(name = "DocumentoVenta.findByIdDocumentoVenta", query = "SELECT d FROM DocumentoVenta d WHERE d.idDocumentoVenta = :idDocumentoVenta"),
    @NamedQuery(name = "DocumentoVenta.findByFechaCreacion", query = "SELECT d FROM DocumentoVenta d WHERE d.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "DocumentoVenta.findByTotalPagar", query = "SELECT d FROM DocumentoVenta d WHERE d.totalPagar = :totalPagar")})
public class DocumentoVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_documento_venta")
    private Integer idDocumentoVenta;
    @Size(max = 100)
    @Column(name = "fecha_creacion")
    private String fechaCreacion;
    @Column(name = "total_pagar")
    private Long totalPagar;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_distrito", referencedColumnName = "id_distrito")
    @ManyToOne(optional = false)
    private Distrito idDistrito;
    @JoinColumn(name = "id_estado_doc_venta", referencedColumnName = "id_estado_doc_venta")
    @ManyToOne(optional = false)
    private EstadoDocVenta idEstadoDocVenta;
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    @ManyToOne(optional = false)
    private TipoDocumento idTipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocumentoVenta")
    private Collection<DetalleDocVenta> detalleDocVentaCollection;

    public DocumentoVenta() {
    }

    public DocumentoVenta(Integer idDocumentoVenta) {
        this.idDocumentoVenta = idDocumentoVenta;
    }

    public Integer getIdDocumentoVenta() {
        return idDocumentoVenta;
    }

    public void setIdDocumentoVenta(Integer idDocumentoVenta) {
        this.idDocumentoVenta = idDocumentoVenta;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Long totalPagar) {
        this.totalPagar = totalPagar;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Distrito getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Distrito idDistrito) {
        this.idDistrito = idDistrito;
    }

    public EstadoDocVenta getIdEstadoDocVenta() {
        return idEstadoDocVenta;
    }

    public void setIdEstadoDocVenta(EstadoDocVenta idEstadoDocVenta) {
        this.idEstadoDocVenta = idEstadoDocVenta;
    }

    public TipoDocumento getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    @XmlTransient
    public Collection<DetalleDocVenta> getDetalleDocVentaCollection() {
        return detalleDocVentaCollection;
    }

    public void setDetalleDocVentaCollection(Collection<DetalleDocVenta> detalleDocVentaCollection) {
        this.detalleDocVentaCollection = detalleDocVentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumentoVenta != null ? idDocumentoVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoVenta)) {
            return false;
        }
        DocumentoVenta other = (DocumentoVenta) object;
        if ((this.idDocumentoVenta == null && other.idDocumentoVenta != null) || (this.idDocumentoVenta != null && !this.idDocumentoVenta.equals(other.idDocumentoVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pe.delivery.domain.DocumentoVenta[ idDocumentoVenta=" + idDocumentoVenta + " ]";
    }
    
}
