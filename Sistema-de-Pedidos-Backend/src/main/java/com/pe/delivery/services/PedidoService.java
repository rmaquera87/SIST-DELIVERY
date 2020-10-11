package com.pe.delivery.services;

import com.pe.delivery.repositories.ClienteRepository;
import com.pe.delivery.repositories.PedidoRepository;
import com.pe.delivery.domain.Pedido;
import com.pe.delivery.domain.Cliente;
import com.pe.delivery.domain.Categoria;
import com.pe.delivery.domain.DetallePedido;
import com.pe.delivery.domain.enums.EstadoPagamento;
import com.pe.delivery.security.UserSS;
import com.wesley.cursomc.services.exceptions.AuthorizationException;
import com.wesley.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import java.util.Date;


import java.util.Optional;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;
	//@Autowired
	//private BoletoService boletoService;


	@Autowired
	private ProductoService productoService;



	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private ClienteRepository clienteRepository;



	public Pedido find(Integer id) {
		Pedido obj = repo.findOne(id);

		if(obj == null) {
			throw new ObjectNotFoundException("¡Objeto no encontrado! id: "+id
					+", Tipo: "+Categoria.class.getName());
		}
		return obj;
	}

	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setIdPedido(null);
		//obj.setFechaCreacion(new Date());
		obj.setIdCliente(clienteService.find(obj.getIdCliente().getIdCliente()));
		/*obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}*/
		obj = repo.save(obj);
		//pagamentoRepository.save(obj.getPagamento());
		for (DetallePedido ip : obj.getDetallePedidoCollection()) {
			
			ip.setIdProducto(productoService.find(ip.getIdProducto().getIdProducto()));
			ip.setSubTotal(ip.getIdProducto().getPrecio());
			
		}
		//itemPedidoRepository.save(obj.getItens());
		//System.out.println(obj);
		emailService.sendOrderConfirmationEmail(obj);

		return obj;
	}

	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso Denegado");
		}
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		//Cliente cliente =  clienteRepository.findOne(user.getId());
		return repo.findByIdCliente(user.getId(), pageRequest);
	}

}
