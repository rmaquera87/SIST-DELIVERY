package com.pe.delivery.repositories;

import com.pe.delivery.domain.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer> {

}
