import React from 'react';


import './styles.css'

function Producto (props) {
    return (
        <div className="containerProducto" onClick={props.click}>
            <img src="https://www.euax.com.br/wp-content/uploads/2019/04/escopo-de-projeto.png" alt="producto" />
            <div className="nameProducto">
                <p>{props.name}</p>
                <p>PRECIO: S/. {props.precio}</p>
            </div>
        </div>
    );
}

export default Producto;