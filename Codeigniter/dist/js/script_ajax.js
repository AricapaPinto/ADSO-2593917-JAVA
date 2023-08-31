
// esta parte ya funciona
function getCliente(cedula) {
    console.log("cedula del cliente:", cedula);
    // aqui mandamos la cedula al controlador en el metodo que se encargara de validar que la cedula se encuentre en la base de datos y haci nos traiga la informacion de ese usuario 
    let endpointLocal = "http://localhost/CodeIgniter/index.php/admin/UpdateUsers/getCliente/" + cedula;

    fetch(endpointLocal)
        .then(res => res.json())
        .then(data => {
            // aqui miramos en consola si recibimos los datos que queriamos
            console.log("Datos del servidor:");

            
            //    creamo dos variables para tener separada las tabla entre si y poder acceder a los datos mas facilmente 

            let persona = data.persona;
            let usuario = data.usuario;

            console.log(persona.cedula);
            console.log(usuario);
            // ahora metemos los datos en los input a cual pertenece cada uno 


            document.getElementById("editar_documento").value = persona.cedula;
            document.getElementById("editar_nombre").value = persona.nombres;
            document.getElementById("editar_apellido").value = persona.apellidos;
            document.getElementById("editar_telefonos").value = persona.telefono;
            document.getElementById("editar_direcciones").value = persona.direccion;
            document.getElementById("editar_correo").value = persona.email;
        });

    // ahora cargamos los datos para meterlo en el formulario del modal
}