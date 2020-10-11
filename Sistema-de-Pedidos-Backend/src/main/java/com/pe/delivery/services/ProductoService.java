package com.pe.delivery.services;

import java.util.List;

import com.pe.delivery.domain.Categoria;
import com.pe.delivery.domain.Producto;

import com.pe.delivery.repositories.CategoriaRepository;
import com.pe.delivery.repositories.ProductoRepository;

import com.wesley.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ProductoService  {

    @Autowired
    private ProductoRepository repo;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Producto find(Integer id) {
        Producto obj = repo.findOne(id);
        if (obj == null) {
            throw new ObjectNotFoundException("¡Objeto no encontrado! Id: " + id
                    + ", Tipo: " + Producto.class.getName());
        }
        return obj;
    }

    public Page<Producto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = categoriaRepository.findAll(ids);
        return repo.findDistinctByNombreContainingAndCategoriasIn(nome, categorias, pageRequest);
        //return null;
    }
}