import React, { useState } from 'react'
import { useHistory } from 'react-router-dom'

import './styles.css'
import HeaderNavigate from '../../components/HeaderNavigate';

function FormPayment () {
    const history = useHistory()
    const [plots, setPlots] = useState(false)
    let qtdPlots = 0;

    function handleFinish (e) {
        e.preventDefault()

        plots === false ? history.push(`/check-request/${0}`) : history.push(`/check-request/${qtdPlots}`)
    }

    return (
        <HeaderNavigate name={'Forma de pago'} navigate={() => history.push('/get-adress')}>
            <div className='containerPayment'>
                <br />
                <span>Tipo de pago</span>
                <form onSubmit={handleFinish}>
                    <div className='selectPayment'>
                        <input
                            id='boleto'
                            value='boleto'
                            name="gender"
                            type="radio"
                            onChange={() => setPlots(false)}
                            required={true}
                        />
                        <label
                            htmlFor='boleto'>
                            Pago en Efectivo
                        </label>
                        <input
                            id='cartao'
                            value='cartao'
                            name="gender"
                            type="radio"
                            onChange={() => setPlots(true)}
                            required={true}
                        />
                        <label
                            htmlFor='cartao'>
                            Pago con Tarjeta
                         </label>
                    </div>
                    <div className='numPlots'>
                        {plots === true ? (
                            <>
                                <h3>Nº de cuotas</h3>
                                <select onChange={event => qtdPlots = event.target.value}>
                                    <option value='1'>1</option>
                                    <option value='2'>2</option>
                                    <option value='3'>3</option>
                                    <option value='4'>4</option>
                                    <option value='5'>5</option>
                                    <option value='6'>6</option>
                                    <option value='7'>7</option>
                                    <option value='8'>8</option>
                                    <option value='9'>9</option>
                                    <option value='10'>10</option>
                                </select>
                            </>
                        ) : (<div />)}
                    </div>
                    <button type='submit'>Próximo</button>
                </form>
            </div>
        </HeaderNavigate>
    )
}

export default FormPayment;