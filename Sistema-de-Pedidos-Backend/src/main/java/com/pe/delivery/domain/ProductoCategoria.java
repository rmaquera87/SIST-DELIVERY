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
@Table(name = "producto_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoCategoria.findAll", query = "SELECT p FROM ProductoCategoria p"),
    @NamedQuery(name = "ProductoCategoria.findByIdProductoCategoria", query = "SELECT p FROM ProductoCategoria p WHERE p.idProductoCategoria = :idProductoCategoria")})
public class ProductoCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto_categoria")
    private Integer idProductoCategoria;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public ProductoCategoria() {
    }

    public ProductoCategoria(Integer idProductoCategoria) {
        this.idProductoCategoria = idProductoCategoria;
    }

    public Integer getIdProductoCategoria() {
        return idProductoCategoria;
    }

    public void setIdProductoCategoria(Integer idProductoCategoria) {
        this.idProductoCategoria = idProductoCategoria;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
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
        hash += (idProductoCategoria != null ? idProductoCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoCategoria)) {
            return false;
        }
        ProductoCategoria other = (ProductoCategoria) object;
        if ((this.idProductoCategoria == null && other.idProductoCategoria != null) || (this.idProductoCategoria != null && !this.idProductoCategoria.equals(other.idProductoCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wesley.cursomc.domain.ProductoCategoria[ idProductoCategoria=" + idProductoCategoria + " ]";
    }
    
}
