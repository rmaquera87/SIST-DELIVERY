package com.pe.delivery.repositories;

import com.pe.delivery.domain.Categoria;
import com.pe.delivery.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Transactional(readOnly=true)
    @Query("SELECT DISTINCT p FROM ProductoCategoria pc INNER JOIN pc.idProducto p INNER JOIN pc.idCategoria c WHERE p.nombre LIKE %:nombre% AND c IN :categorias")
    Page<Producto> findDistinctByNombreContainingAndCategoriasIn(@Param("nombre") String nomex, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
}
