package com.pe.delivery.services;

import java.util.List;

import com.pe.delivery.domain.Categoria;
import com.pe.delivery.domain.Producto;
import com.pe.delivery.dto.ProductoDTO;

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

    public ProductoDTO find(Integer id) {
        //Producto obj = repo.findOne(id);
        Producto obj = repo.findByIdProducto(id);

        /*Producto obj=new Producto();
        obj.setIdProducto(1);
        obj.setNombre("pro");
        obj.setPrecio(Long.parseLong("13"));*/
        if (obj == null) {
            throw new ObjectNotFoundException("¡Objeto no encontrado! Id: " + id
                    + ", Tipo: " + Producto.class.getName());
        }
        
        ProductoDTO productoDto=new ProductoDTO(obj);
        
        
        return productoDto;
    }

    public Page<Producto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = categoriaRepository.findAll(ids);
        return repo.findDistinctByNombreContainingAndCategoriasIn(nome, categorias, pageRequest);
        //return null;
    }
}