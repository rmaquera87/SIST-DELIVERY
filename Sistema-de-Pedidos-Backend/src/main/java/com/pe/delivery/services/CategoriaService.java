package com.pe.delivery.services;

import com.pe.delivery.dto.CategoriaDTO;
import com.pe.delivery.resources.CategoriaResource;
import com.wesley.cursomc.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pe.delivery.domain.Categoria;
import com.pe.delivery.repositories.CategoriaRepository;
import com.wesley.cursomc.services.exceptions.ObjectNotFoundException;

import java.util.List;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Categoria obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("¡Objeto no encontrado! id: "+id
					+", Tipo: "+Categoria.class.getName());
		}
		return obj;
	}

	public List<Categoria> findAll() {
		return repo.findAll();
	}


	public Categoria insert(Categoria obj){
                obj.setIdCategoria(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getIdCategoria());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("No puede eliminar una categoría que tiene productos");
		}
	}

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getIdCategoria(), objDto.getDescripcion());
	}

	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setDescripcion(obj.getDescripcion());
	}
}
