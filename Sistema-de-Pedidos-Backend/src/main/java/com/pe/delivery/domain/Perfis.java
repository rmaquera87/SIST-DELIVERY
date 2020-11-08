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
@Table(name = "perfis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfis.findAll", query = "SELECT p FROM Perfis p"),
    @NamedQuery(name = "Perfis.findByIdPerfis", query = "SELECT p FROM Perfis p WHERE p.idPerfis = :idPerfis"),
    @NamedQuery(name = "Perfis.findByIdPerfil", query = "SELECT p FROM Perfis p WHERE p.idPerfil = :idPerfil")})
public class Perfis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_perfis")
    private Integer idPerfis;
    @Column(name = "id_perfil")
    private Integer idPerfil;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente idCliente;

    public Perfis() {
    }

    public Perfis(Integer idPerfis) {
        this.idPerfis = idPerfis;
    }

    public Integer getIdPerfis() {
        return idPerfis;
    }

    public void setIdPerfis(Integer idPerfis) {
        this.idPerfis = idPerfis;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfis != null ? idPerfis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfis)) {
            return false;
        }
        Perfis other = (Perfis) object;
        if ((this.idPerfis == null && other.idPerfis != null) || (this.idPerfis != null && !this.idPerfis.equals(other.idPerfis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pe.delivery.domain.Perfis[ idPerfis=" + idPerfis + " ]";
    }
    
}
