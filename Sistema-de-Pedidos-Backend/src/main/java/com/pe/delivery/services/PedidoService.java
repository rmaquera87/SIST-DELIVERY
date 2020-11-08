package com.pe.delivery.services;

import com.pe.delivery.repositories.ClienteRepository;
import com.pe.delivery.repositories.PedidoRepository;
import com.pe.delivery.domain.Pedido;
import com.pe.delivery.domain.Cliente;
import com.pe.delivery.domain.Categoria;
import com.pe.delivery.domain.DetallePedido;
import com.pe.delivery.domain.enums.EstadoPagamento;
import com.pe.delivery.dto.DetallePedidoDTO;
import com.pe.delivery.dto.PedidoDTO;
import com.pe.delivery.repositories.DetallePedidoRepository;
import com.pe.delivery.repositories.DistritoRepository;
import com.pe.delivery.repositories.EntregaRepository;
import com.pe.delivery.repositories.EstadoPedidoRepository;
import com.pe.delivery.repositories.PersonalEntregaRepository;
import com.pe.delivery.repositories.ProductoRepository;
import com.pe.delivery.security.UserSS;
import com.wesley.cursomc.services.exceptions.AuthorizationException;
import com.wesley.cursomc.services.exceptions.ObjectNotFoundException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import java.util.Date;
import java.util.List;


import java.util.Optional;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	//@Autowired
	//private BoletoService boletoService;
        
        @Autowired
	private EstadoPedidoRepository estadoPedidoRepository;
        @Autowired
	private PersonalEntregaRepository personalEntregaRepository;
        @Autowired
        private DistritoRepository distritoRepository;
        @Autowired
	private ClienteRepository clienteRepository;
        @Autowired
	private EntregaRepository entregaRepository;
        @Autowired
	private DetallePedidoRepository detallePedidoRepository;

	@Autowired
	private ProductoRepository productoRepository;



	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EmailService emailService;





	public Pedido find(Integer id) {
		Pedido obj = pedidoRepository.findOne(id);

		if(obj == null) {
			throw new ObjectNotFoundException("¡Objeto no encontrado! id: "+id
					+", Tipo: "+Categoria.class.getName());
		}
		return obj;
	}

	@Transactional
	public PedidoDTO insert(PedidoDTO pedidoDTO) {
            
                Pedido pedido=new Pedido();
		//pedido.setIdPedido(null);
		pedido.setFechaCreacion(new Date());

                pedido.setIdEstadoPedido(estadoPedidoRepository.findOne(1));
		//pedido.setIdPersonalEntrega(personalEntregaRepository.findOne(pedidoDTO.getIdPersonalEntrega()));
                //pedido.setIdDistrito(distritoRepository.findOne(pedidoDTO.getIdDistrito()));
                pedido.setIdDistrito(distritoRepository.findOne(1));
                pedido.setIdCliente(clienteRepository.findOne(pedidoDTO.getIdCliente()));
                pedido.setIdEntrega(entregaRepository.findOne(pedidoDTO.getIdEntrega()));
                
                
                
		/*obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}*/
		pedidoRepository.save(pedido);
		//pagamentoRepository.save(obj.getPagamento());
		/*for (DetallePedido ip : obj.getDetallePedidoCollection()) {
			
			//ip.setIdProducto(productoService.find(ip.getIdProducto().getIdProducto()));
			//ip.setSubTotal(ip.getIdProducto().getPrecio());
			
		}*/
		//itemPedidoRepository.save(obj.getItens());
		//System.out.println(obj);
		
                //emailService.sendOrderConfirmationEmail(obj);
                List<DetallePedido> lstDetallePedido= new ArrayList<>();
                for (DetallePedidoDTO dp : pedidoDTO.getDetallePedido()) {
                    
                        DetallePedido detallePedido=new DetallePedido();
                        detallePedido.setCantidad(dp.getCantidad());
                        detallePedido.setPrecioUnitario(dp.getPrecioUnitario());
                        detallePedido.setSubTotal(dp.getSubTotal());
                        detallePedido.setProducto(productoRepository.findOne(dp.getIdProducto()));
                        detallePedido.setPedido(pedido);
                       
                        lstDetallePedido.add(detallePedido);
			
		}
                
                detallePedidoRepository.save(lstDetallePedido);
                
		return pedidoDTO;
	}

	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso Denegado");
		}
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		//Cliente cliente =  clienteRepository.findOne(user.getId());
		return pedidoRepository.findByIdCliente(user.getId(), pageRequest);
	}

}
