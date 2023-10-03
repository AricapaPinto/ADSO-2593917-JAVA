let contentMenu = null;
let btnAtras = null;
let btnSiguiente = null;
let waitContent = null;

window.onload = function () {
	contentMenu = document.getElementById("contentMenu");
	btnAtras = document.getElementById("btnAtras");
	btnSiguiente = document.getElementById("btnSiguiente");
	waitContent = document.getElementById("waitContent");

	getPokemons("https://pokeapi.co/api/v2/pokemon");
}


// Función para obtener los Pokémon y crear los botones
function getPokemons(endpoint) {
	// Esperar 1 segundo antes de ocultar el estilo waitContent
	waitContent.style.display = 'block';
	try {
		fetch(endpoint)
			.then(res => res.json())
			.then(data => {
				contentMenu.innerHTML = "";
				for (let i = 0; i < data.results.length; i++) {

					let btnTemp = `<button class="col-2 m-1 btn btn-outline-primary">${data.results[i].name}</button>`;
					contentMenu.innerHTML += btnTemp;
				}

				btnAtras.setAttribute("data-endpoint", data.previous);
				btnSiguiente.setAttribute("data-endpoint", data.next);
				waitContent.style.display = 'none';

				// Agregar escuchadores de eventos a los botones creados
				const buttons = document.querySelectorAll('.btn-outline-primary');
				buttons.forEach(button => {
					button.addEventListener('click', () => {
						// Llamar a la función que deseas ejecutar cuando se haga clic en el botón
						mostrarPokemon(button.innerText);
					});
				});
				waitContent.style.display = 'none';
			});

	} catch (error) {
		console.log(error);
	}

}

// Función que se ejecuta cuando se hace clic en un botón ya que los botones son creado mediante codigo javascript
function mostrarPokemon(pokemonName) {
	// primero mostrarmos la informacion del pokemon 
	let name_pokemon = document.getElementById("name_pokemon");
	name_pokemon.textContent = pokemonName;
	// Hacer una solicitud para obtener la información detallada del Pokémon
	fetch(`https://pokeapi.co/api/v2/pokemon/${pokemonName}/`)
		.then(res => res.json())
		.then(pokemonData => {
			// Obtener la imagen del Pokémon y mostrarla en el elemento <img>
			let img_pokemon = document.querySelector("#name_pokemon + div img");
			img_pokemon.setAttribute("src", pokemonData.sprites.other.dream_world.front_default);
		})
}

function getNext() {
	// primero hago que se ejecute el estilo de carga despues utilizo el metodo de settimeot para delimitar el tiempo de carga 
	waitContent.style.display = 'block';
	setTimeout(() => {
		let endpoint = btnSiguiente.getAttribute("data-endpoint");
		if (endpoint != null) {
			getPokemons(endpoint);
		} else {
			waitContent.style.display = 'none';
		}
	}, 125);

}

function getBack() {

	let endpoint = btnAtras.getAttribute("data-endpoint");
	if (endpoint != null) {
		waitContent.style.display = 'block';
		getPokemons(endpoint);
	} else {
		waitContent.style.display = 'none';
	}
}
