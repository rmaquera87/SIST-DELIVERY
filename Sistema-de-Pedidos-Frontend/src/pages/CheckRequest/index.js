import React from 'react'
import { useParams, useHistory } from 'react-router-dom'
import api from '../../services/api'

import cart from '../../utils/cart'
import request from '../../utils/request'
import responseError from '../../utils/responseError'

import './styles.css'
import Home from '../../components/Home';

function CheckRequest () {
    const history = useHistory()
    const { qtdPlots } = useParams()

    function handleRequest () {
        const items = cart.getCart().map(item => {
            return {

                cantidad: item.qtd,
                precioUnitario: item.precio,
                subTotal: item.precio * item.qtd,
                idProducto: item.idProducto

            }
        })

        const data = {
            idCliente:  request.getClient().idCliente ,
            idEntrega:  request.getAdressDelivery().idEntrega,
            detallePedido: items

            /*enderecoDeEntrega: request.getAdressDelivery(),
            pagamento: {
                numeroDeParcelas: parseInt(qtdPlots),
                '@type': qtdPlots === '0' ? 'pagamentoComBoleto' : 'pagamentoComCartao'
            },
            itens*/
        }

        const token = localStorage.getItem('token')
        api.post('/pedidos', data, {
            headers: {
                'Content-Type': 'application/json',
                Authorization: token
            }
        }).then(response => {
            console.log(response)

            if(response.status===200 || response.status===201){
                history.push('/categories')
                alert("Su pedido se ha registrado correctamente");
                localStorage.removeItem('cart');
            }else{
                alert("Hubo un error");
            }
        }).catch(error => {
            responseError(error)
        })

        console.log(data)
    }

    return (
        <Home name={'Confirmar Pedido'}>
            <div className='checkContainer'>

                <section>
                    <h1>Cliente</h1>
                    <p>{request.getClient().nombreCompleto}</p>
                    <p>{request.getClient().email}</p>

                    <h1>Dirección de Entrega</h1>
                    <p>{`${request.getAdressDelivery().descripcion}`}</p>


                    <h1>Pago</h1>
                    {qtdPlots === '0' ?
                        <p>Pago con Efectivo</p>
                        :
                        (
                            <>
                                <p>Pago con Tarjeta</p>
                                <p>{`${qtdPlots} parcelas`}</p>
                            </>
                        )
                    }
                </section>
                <section>
                    <h1>Items del pedido</h1>
                    <ul>
                        {cart.getCart().map(item => (
                            <li key={item.id}>
                                <img
                                    src={'https://comps.canstockphoto.com.br/produto-engrenagem-s%C3%ADmbolo-cardbox-desenho_csp53091492.jpg'}
                                    alt={'item do carrinho'}
                                />
                                <div className='infoItem' align="left">
                                    <p align="left"><b>{item.nombre}</b></p>
                                    <p align="left"><b>Cant.:</b> {item.qtd} <b>P.U.:</b> {`S/ ${item.precio}`}</p>
                                  
                                </div>
                                <div className='price'><b>Total</b> {`S/ ${item.precio * item.qtd}`}</div>
                            </li>
                        ))}
                    </ul>
                    <h1 align="right">Total: {`S/ ${cart.getTotalCart()}`}</h1>
                </section>
                <div className='buttons'>
                    <button onClick={() => handleRequest()}>Confirmar pedido</button>
                    <button onClick={() => history.goBack()}>Regresar</button>
                </div>
            </div>
        </Home>
    )
}

export default CheckRequest;