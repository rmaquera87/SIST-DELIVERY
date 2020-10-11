package com.pe.delivery.dto;

import com.pe.delivery.domain.Categoria;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class CategoriaDTO  implements Serializable {

    private Integer idCategoria;
    private String  descripcion;

    public CategoriaDTO(Categoria categoria) {
        this.idCategoria = categoria.getIdCategoria();
        this.descripcion = categoria.getDescripcion();
    }

    
    
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

}