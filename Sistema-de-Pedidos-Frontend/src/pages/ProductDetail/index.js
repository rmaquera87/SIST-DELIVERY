import React, { useEffect, useState } from 'react';
import { useHistory, useParams } from 'react-router-dom'
import api from '../../services/api'
import cart from '../../utils/cart'

import HeaderNavigate from '../../components/HeaderNavigate'
import LittleCart from '../../components/LittleCart'

import './styles.css'
import Producto from '../../components/Producto';

function ProductDetail () {
    const [product, setProduct] = useState({})
    const history = useHistory()
    let { id } = useParams()

    useEffect(() => {
        api.get(`/produtos/${id}`).then(response => {
            setProduct(response.data)
            //setProduct(response.data.content)
        })
    }, [id])

    function addToCarHandle () {
        cart.addToCart(product)
        history.push('/cart')
    }
    console.log(product.idProducto);
    return (
        <HeaderNavigate name={"Detalles"} navigate={() => history.goBack()}>
            <LittleCart click={() => history.push('/cart')} />
            <div className="detailContainer">
                <div className="card">
                    <img src={"https://blog.hotmart.com/blog/2019/12/17163328/cadastrar_produto-670x419.png"} alt={"Foto do produto"} />
                    <div className="information">
                        
                        <p>nom{product.idProducto}</p>
                        <p>S/. {product.precio}.00</p>
                        <button onClick={addToCarHandle}>Adicionar Al Carrito</button>
                    </div>
                </div>
            </div>
        </HeaderNavigate>
    );
}

export default ProductDetail;