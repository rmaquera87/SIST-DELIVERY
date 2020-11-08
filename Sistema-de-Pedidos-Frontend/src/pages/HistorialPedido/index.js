import React, { useEffect, useState } from 'react';
import { useHistory } from 'react-router-dom'

import api from '../../services/api'

import './styles.css'

import LittleCart from '../../components/LittleCart'
import Home from '../../components/Home'
import Category from '../../components/Category'

function HistorialPedido () {
    const [categories, setCategories] = useState([])
    const history = useHistory()

    useEffect(() => {
        api.get('/historial').then(response => {
            setCategories(response.data)
        })
    }, [])

    function productsHandle (id) {
        history.push(`/products/${id}`)
    }

    return ("");
}

export default HistorialPedido;