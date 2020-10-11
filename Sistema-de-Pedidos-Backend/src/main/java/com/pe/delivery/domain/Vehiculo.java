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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DAYIRO
 */
@Entity
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByIdVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.idVehiculo = :idVehiculo"),
    @NamedQuery(name = "Vehiculo.findByNroPlaca", query = "SELECT v FROM Vehiculo v WHERE v.nroPlaca = :nroPlaca"),
    @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;
    @Size(max = 50)
    @Column(name = "nro_placa")
    private String nroPlaca;
    @Size(max = 100)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 100)
    @Column(name = "marca")
    private String marca;
    @JoinColumn(name = "id_personal_entrega", referencedColumnName = "id_personal_entrega")
    @ManyToOne(optional = false)
    private PersonalEntrega idPersonalEntrega;
    @JoinColumn(name = "id_tipo_vehiculo", referencedColumnName = "id_tipo_vehiculo")
    @ManyToOne(optional = false)
    private TipoVehiculo idTipoVehiculo;

    public Vehiculo() {
    }

    public Vehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getNroPlaca() {
        return nroPlaca;
    }

    public void setNroPlaca(String nroPlaca) {
        this.nroPlaca = nroPlaca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public PersonalEntrega getIdPersonalEntrega() {
        return idPersonalEntrega;
    }

    public void setIdPersonalEntrega(PersonalEntrega idPersonalEntrega) {
        this.idPersonalEntrega = idPersonalEntrega;
    }

    public TipoVehiculo getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(TipoVehiculo idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wesley.cursomc.domain.Vehiculo[ idVehiculo=" + idVehiculo + " ]";
    }
    
}
