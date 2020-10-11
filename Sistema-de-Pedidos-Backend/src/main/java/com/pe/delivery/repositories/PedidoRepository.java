package com.pe.delivery.repositories;


import com.pe.delivery.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;


import com.pe.delivery.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Transactional(readOnly=true)
    Page<Pedido> findByIdCliente(Integer idCliente, Pageable pageRequest);
}