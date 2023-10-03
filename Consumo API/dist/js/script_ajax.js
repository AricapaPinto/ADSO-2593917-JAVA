let waitContent = null;
let insertarDatos = null;
let formEditarCliente = null;
let listaClientes = null;
let modalEditarCliente = null;
let eliminarCliente = null;

window.onload = function () {
	waitContent = document.getElementById("waitContent");
	insertarDatos = document.getElementById("insertarDatos");
	formEditarCliente = document.getElementById("actulizarCliente");

	// metodo para abrir el modal de boostrap 
	modalEditarCliente = new bootstrap.Modal(document.getElementById("modalEditarCliente"), {
		backdrop: 'static',
		keyboard: false,
		focus: false
	});
	insertarDatos.addEventListener("submit", function (event) {
		// evento para que no se recargue la pagina
		event.preventDefault();
		crearCliente();
	});
	formEditarCliente.addEventListener("submit", function (event) {
		event.preventDefault();
		editarCliente();
	});

	getClientes();
}

function crearCliente() {
	let cedula = document.getElementById("documento").value;
	let nombre = document.getElementById("nombre").value;
	let apellidos = document.getElementById("apellido").value;
	let telefono = document.getElementById("telefonos").value;
	let direccion = document.getElementById("direcciones").value;
	let correo = document.getElementById("correo").value;

	console.log(cedula);
	console.log(nombre);
	console.log(apellidos);
	console.log(telefono);
	console.log(direccion);

	let datos = new FormData();
	datos.append("cedula", document.getElementById("documento").value);
	datos.append("nombres", document.getElementById("nombre").value);
	datos.append("apellidos", document.getElementById("apellido").value);
	datos.append("telefono", document.getElementById("telefonos").value)
	datos.append("direccion", document.getElementById("direcciones").value);
	datos.append("email", document.getElementById("correo").value);


	let configuracion = {
		method: "POST",
		Headers: {
			"Accept": "application/json",

		},
		body: datos,

	};


	fetch("http://localhost/ProyectoPHP/Insert.php", configuracion)
		.then(resp => resp.json())
		.then(data => {
			console.log("Respuesta API");
			console.log(data);
			if (data.status) {
				getClientes();

				document.getElementById("documento").value = "";
				document.getElementById("nombre").value = "";
				document.getElementById("apellido").value = "";
				document.getElementById("telefonos").value = "";
				document.getElementById("direcciones").value = "";
				document.getElementById("correo").value = "";

				Swal.fire({
					title: 'INSERTADO CON EXITO',
					text: 'El usuario ha sido creado con éxito.',
					icon: 'success',
				});
			} else {
				Swal.fire({
					title: 'NO INSERTADO',
					text: 'No se pudo crear el usuario. Es posible que la cedula ingresada exista de manera previa.',
					icon: 'error',
				});
			}
		});

}
const EliminarCliente = (numero) => {
	let dato = new FormData();
	dato.append("cedula", numero);
	let configuracion = {
		method: "POST",
		headers: {
			"Accept": "application/json",
		},
		body: dato,
	}
	fetch("http://localhost/ProyectoPHP/Eliminar.php", configuracion)
		.then(resp => resp.json())
		.then(data => {

			console.log(" Respuesta API: ");
			console.log(data);
			getClientes();
			if (data.status) {
				// esto deveria actuliar el coso lo hace pero hay un problema
				// getClientes();
				Swal.fire({
					title: 'ELIMINADO CON EXITO',
					text: 'El usuario ha sido eliminado con éxito.',
					icon: 'success',
				});
			} else {
				Swal.fire({
					title: 'NO ELIMINADO',
					text: 'No se pudo eliminar  el usuario.',
					icon: 'error',
				});
			}


		});
}
function editarCliente() {
	let datos = new FormData();
	datos.append("cedula", document.getElementById("editar_documento").value);
	datos.append("nombres", document.getElementById("editar_nombre").value);
	datos.append("apellidos", document.getElementById("editar_apellido").value);
	datos.append("telefono", document.getElementById("editar_telefonos").value)
	datos.append("direccion", document.getElementById("editar_direcciones").value);
	datos.append("email", document.getElementById("editar_correo").value);
	let configuracion = {
		method: "POST",
		headers: {
			"Accept": "application/json",
		},
		body: datos,
	};

	fetch("http://localhost/ProyectoPHP/editar.php", configuracion)
		.then(resp => resp.json())
		.then(data => {

			console.log(" Respuesta API: ");
			console.log(data);

			if (data.status) {
				// esto deveria actuliar el coso lo hace pero hay un problema
				getClientes();
				modalEditarCliente.hide();
				Swal.fire({
					title: 'EDITADO CON EXITO',
					text: 'El usuario ha sido editado con éxito.',
					icon: 'success',
				});
			} else {
				Swal.fire({
					title: 'NO EDITADO',
					text: 'No se pudo editar el usuario.',
					icon: 'error',
				});
			}


		});
}
function getClientes() {
	let endpointLocal = "http://localhost/ProyectoPHP/Obtener.php";
	waitContent.style.display = 'block';
	fetch(endpointLocal)
		.then(res => res.json())
		.then(data => {
			console.log("Datos servidor:");
			console.log(data);
			// creamos metodo para mostrar los datos en la tabla 
			// hacemos llamado a el identificador 
			const container = document.getElementById("date_user");
			// creamo el ciclo el cual va  hacer contado  de los usuario 
			// Borrar los elementos anteriores de la tabla
			container.innerHTML = "";
			// ahora le aregamos a la variable todos los datos de la api en local a lista clientes
			listaClientes = data.registros;
			for (let i = 0; i < data.registros.length; i++) {
				// creamos los contenedores la cual vamos a meter la informacion
				const tr = document.createElement("tr");
				const td = document.createElement("td");
				const td2 = document.createElement("td");
				const td3 = document.createElement("td");
				const td4 = document.createElement("td");
				const td5 = document.createElement("td");
				const td6 = document.createElement("td");
				const td7 = document.createElement("td");
				// creamos los botones 
				const btn_1 = document.createElement("button");
				const btn_2 = document.createElement("button");

				btn_1.textContent = "Eliminar";
				btn_2.textContent = "Actulizar";

				btn_1.classList.add("btn", "btn-danger");
				btn_2.classList.add("btn", "btn-success");
				// btn_1.classList.add("btn","btn-success");
				// btn_1.classList.add("btn","btn-danger");
				// le añadimos el contenido al td 
				td6.appendChild(btn_1);
				td7.appendChild(btn_2);


				td.textContent = data.registros[i].cedula;
				td2.textContent = data.registros[i].nombres;
				td3.textContent = data.registros[i].apellidos;
				td4.textContent = data.registros[i].telefono;
				td5.textContent = data.registros[i].direccion;
				// ahora le añadimos los td a su tr respectivo 
				tr.appendChild(td);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tr.appendChild(td5);
				tr.appendChild(td6);
				tr.appendChild(td7);
				// añadimos el tr a el contenedor de los datos 
				container.appendChild(tr);

				// agregamos los eventos del boton onclik para actulizar los datos del cliente 

				btn_2.addEventListener('click', () => {
					// aqui ejecutamos el metodo que vamos a hacerle a los botones
					abrirModalEditar(i);
					console.log("Ha dado click en el boton", i);

				});
				btn_1.addEventListener('click', () => {
					// aqui ejecutamos el metodo que vamos a hacerle a los botones
					EliminarCliente(data.registros[i].cedula);
					console.log("Ha dado click en el boton", i);

				});
			}
			waitContent.style.display = 'none';
		});
}
// funcion para abrir el modal y editar a los clientes dependiendo de donde se de click 

const abrirModalEditar = (posicion) => {
	document.getElementById("editar_documento").value = listaClientes[posicion].cedula;
	document.getElementById("editar_nombre").value = listaClientes[posicion].nombres;
	document.getElementById("editar_apellido").value = listaClientes[posicion].apellidos;
	document.getElementById("editar_telefonos").value = listaClientes[posicion].telefono;
	document.getElementById("editar_direcciones").value = listaClientes[posicion].direccion;
	document.getElementById("editar_correo").value = listaClientes[posicion].email;

	modalEditarCliente.show();
}