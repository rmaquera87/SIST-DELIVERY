package com.pe.delivery.services;


import com.pe.delivery.domain.enums.Perfil;
import com.pe.delivery.domain.enums.TipoCliente;
import com.pe.delivery.dto.ClienteDTO;

import com.pe.delivery.security.UserSS;
import com.wesley.cursomc.services.exceptions.AuthorizationException;
import com.wesley.cursomc.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.pe.delivery.domain.Cliente;
import com.pe.delivery.domain.Entrega;
import com.pe.delivery.repositories.ClienteRepository;
import com.pe.delivery.repositories.EntregaRepository;
import com.wesley.cursomc.services.exceptions.ObjectNotFoundException;

import java.util.List;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;




	@Autowired
	private EntregaRepository entregaRepository;

	@Autowired
	private BCryptPasswordEncoder pe;

	public Cliente find(Integer id) {
        UserSS user = UserService.authenticated();
        if(user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())){
            throw new AuthorizationException(" Acesso Denegado!");
        }
		Cliente obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("¡Objeto no encontrado! id: " + id
					+ ", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}

	public Cliente findByEmail(String email) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso Denegado");
		}

		Cliente obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"¡Objeto no encontrado! Id: " + user.getId() + ", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}

	public Cliente insert(Cliente obj) {
		obj.setIdCliente(null);
		obj = repo.save(obj);
		//entregaRepository.save(obj.getEnderecos());
		return obj;
	}

	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getIdCliente());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("No se puede eliminar porque hay pedidos relacionados");
		}
	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getIdCliente(), objDto.getNombreCompleto(), objDto.getEmail());
	}

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNombreCompleto(obj.getNombreCompleto());
		newObj.setEmail(obj.getEmail());
	}

	/*public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()), pe.encode(objDto.getSenha()));
		Estado estado = new Estado(null,objDto.getEstado());
		Cidade cid= new Cidade(null,objDto.getCidade(),estado);


		estadoRepository.save(estado);
		cidadeRepository.save(cid);

		Entrega end = new Entrega(null,  null, cli);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2()!=null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3()!=null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;
	}
        */
}
