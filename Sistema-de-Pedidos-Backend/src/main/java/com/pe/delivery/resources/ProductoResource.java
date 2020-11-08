package com.pe.delivery.resources;

import com.pe.delivery.domain.Producto;
import java.util.List;


import com.pe.delivery.dto.ProductoDTO;
import com.pe.delivery.resources.utils.URL;
import com.pe.delivery.services.ProductoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/produtos")
@Api(value="API REST Produtos")
public class ProductoResource {

    @Autowired
    private ProductoService service;

    @ApiOperation(value="Buscar produto por ID")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<ProductoDTO> find(@PathVariable Integer id) {
        ProductoDTO obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @ApiOperation(value="Buscar produtos")
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<Page<ProductoDTO>> findPage(
            @RequestParam(value="nome", defaultValue="") String nome,
            @RequestParam(value="categorias", defaultValue="") String categorias,
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="p.nombre") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        String nomeDecoded = URL.decodeParam(nome);
        List<Integer> ids = URL.decodeIntList(categorias);
        Page<Producto> list = service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
        Page<ProductoDTO> listDto = list.map(obj -> new ProductoDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }

}