package com.pe.delivery.repositories;

import com.pe.delivery.domain.Entrega;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer> {
    @Transactional(readOnly=true)
    @Query("SELECT e FROM Entrega e INNER JOIN e.idCliente c WHERE c.idCliente=:idCliente")
    List<Entrega> findEntregaXCliente(@Param("idCliente") Integer idCliente);
    
}
