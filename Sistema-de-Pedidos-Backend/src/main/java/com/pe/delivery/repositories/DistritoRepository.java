package com.pe.delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pe.delivery.domain.Distrito;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Integer> {
    /*
    @Transactional(readOnly=true)
    @Query("SELECT obj FROM Distrito obj WHERE obj.estado.id = :estadoId ORDER BY obj.nome")
    public List<Distrito> findCidades(@Param("estadoId") Integer estado_id);
    */
}
