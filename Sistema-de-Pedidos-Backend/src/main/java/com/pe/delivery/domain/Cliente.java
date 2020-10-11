/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.delivery.domain;

import com.pe.delivery.domain.enums.Perfil;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByDni", query = "SELECT c FROM Cliente c WHERE c.dni = :dni"),
    @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email"),
    @NamedQuery(name = "Cliente.findByNombreCompleto", query = "SELECT c FROM Cliente c WHERE c.nombreCompleto = :nombreCompleto"),
    @NamedQuery(name = "Cliente.findByClave", query = "SELECT c FROM Cliente c WHERE c.clave = :clave"),
    @NamedQuery(name = "Cliente.findByTipo", query = "SELECT c FROM Cliente c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Size(max = 8)
    @Column(name = "dni")
    private String dni;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 100)
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Size(max = 100)
    @Column(name = "clave")
    private String clave;
    @Column(name = "tipo")
    private Integer tipo;
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<DocumentoVenta> documentoVentaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<Entrega> entregaCollection;
/*
    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="PERFIS")
    private Set<Integer> perfis = new HashSet<>();
    */
    public Cliente() {
        //addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
        //addPerfil(Perfil.CLIENTE);
    }
    public Cliente(Integer idCliente,String nombreCompleto,String email) {
        this.idCliente = idCliente;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        //addPerfil(Perfil.CLIENTE);
    }
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /*
    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        perfis.add(perfil.getCod());
    }*/
    
    @XmlTransient
    public Collection<DocumentoVenta> getDocumentoVentaCollection() {
        return documentoVentaCollection;
    }

    public void setDocumentoVentaCollection(Collection<DocumentoVenta> documentoVentaCollection) {
        this.documentoVentaCollection = documentoVentaCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @XmlTransient
    public Collection<Entrega> getEntregaCollection() {
        return entregaCollection;
    }

    public void setEntregaCollection(Collection<Entrega> entregaCollection) {
        this.entregaCollection = entregaCollection;
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
        return "com.wesley.cursomc.domain.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
