const reponseError = (error) => {
    let numberError
    try {
        numberError = Number(error.response.data.status)
    } catch (error) {
        alert('El servidor aún no está disponible')
        return
    }
    switch (numberError) {
        case 400:
            alert('Complete los datos correctamente')
            break;
        case 401:
            alert('Credenciales no válidas')
            break;
        case 403:
            alert('Su sesión ha caducado')
            break;
        case 500:
            alert('Error de servidor interno')
            break;
        default:
            alert('Disculpe, ha ocurrido un error. Error = ${numberError}');
    }
}

export default reponseError