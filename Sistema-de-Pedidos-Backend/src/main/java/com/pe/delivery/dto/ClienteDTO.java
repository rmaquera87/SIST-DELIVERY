package com.pe.delivery.dto;

import com.pe.delivery.domain.Cliente;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class ClienteDTO implements Serializable {
    private Integer idCliente;
    private String dni;
    private String email;
    private String nombreCompleto;
    private String clave;
    private Integer tipo;
    private String telefono;

    public ClienteDTO(Cliente cliente) {
         this.idCliente = cliente.getIdCliente();
         this.dni = cliente.getDni();
         this.email = cliente.getEmail();
         this.nombreCompleto = cliente.getNombreCompleto();
         this.clave = cliente.getClave();
         this.tipo = cliente.getTipo();
         this.telefono = cliente.getTelefono();
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
    
    
}