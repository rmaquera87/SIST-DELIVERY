package com.pe.delivery.dto;


import com.pe.delivery.domain.Producto;
import java.io.Serializable;


public class ProductoDTO implements Serializable {


    private Integer idProducto;
    private String nombre;
    private Double precio;

    public ProductoDTO(Producto producto) {
        this.idProducto = producto.getIdProducto();
        this.nombre = producto.getNombre();
        this.precio = (double)producto.getPrecio();
    }

    
    
    
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


}