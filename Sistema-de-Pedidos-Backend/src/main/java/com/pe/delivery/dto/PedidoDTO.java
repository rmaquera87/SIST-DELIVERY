/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.delivery.dto;

import com.pe.delivery.domain.DetallePedido;
import java.util.List;

/**
 *
 * @author DAYIRO
 */
public class PedidoDTO {

    private Integer idPedido;
    private String fechaCreacion;
    private Integer idEstadoPedido;
    private Integer idPersonalEntrega;
    private Integer idDistrito;
    private Integer idCliente;
    private Integer idEntrega;
    private List<DetallePedidoDTO> detallePedido;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(Integer idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public Integer getIdPersonalEntrega() {
        return idPersonalEntrega;
    }

    public void setIdPersonalEntrega(Integer idPersonalEntrega) {
        this.idPersonalEntrega = idPersonalEntrega;
    }

    public Integer getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Integer idEntrega) {
        this.idEntrega = idEntrega;
    }

    public List<DetallePedidoDTO> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(List<DetallePedidoDTO> detallePedido) {
        this.detallePedido = detallePedido;
    }



    
    
}
