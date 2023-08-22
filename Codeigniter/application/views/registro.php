<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Formulario de Registro</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
		integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>
	<style>
		body {
			background-color: #1375AB;
		}

		.container {
			display: flex;
			justify-content: center;
			align-items: center;
		}

		form {
			width: 30%;
			background-color: white;
			padding: 20px;
			border-radius: 20px;
		}

		h2 {
			text-align: center;
		}
	</style>
	<div class="container mt-5">
		<form>
			<h2 class="mb-4"><i class="fas fa-user-plus"></i> Registro de Persona</h2>
			<div class="row">
				<div class="col-md-6">
					<div class="mb-3">
						<label for="cedula" class="form-label"><i class="fas fa-id-card"></i> Cedula:</label>
						<input type="text" class="form-control" name="cedula_new" required>
					</div>
				</div>
				<div class="col-md-6">
					<div class="mb-3">
						<label for="nombre" class="form-label"><i class="fas fa-user"></i> Nombres:</label>
						<input type="text" class="form-control" name="nombre_new" required>
					</div>
				</div>
				<div class="col-md-6">
					<div class="mb-3">
						<label for="apellido" class="form-label"><i class="fas fa-user"></i> Apellidos:</label>
						<input type="text" class="form-control" name="apellido_new" required>
					</div>
				</div>
				<div class="col-md-6">
					<div class="mb-3">
						<label for="telefono" class="form-label"><i class="fas fa-phone"></i> Telefono:</label>
						<input type="text" class="form-control" name="telefono_new" required>
					</div>
				</div>
				<div class="col-md-6">
					<div class="mb-3">
						<label for="direccion" class="form-label"><i class="fas fa-map-marker-alt"></i>
							Dirección:</label>
						<input type="text" class="form-control" name="direccion_new" required>
					</div>
				</div>
				<div class="col-md-6">
					<div class="mb-3">
						<label for="email" class="form-label"><i class="fas fa-envelope"></i> Email:</label>
						<input type="email" class="form-control" name="email_new" required>
					</div>
				</div>
				<div class="col-md-6">
					<div class="mb-3">
						<label for="foto" class="form-label"><i class="fas fa-image"></i> URL de la foto:</label>
						<input type="text" class="form-control" name="foto_new" required>
					</div>
				</div>
			</div>

			<div class="mt-4">
				<button type="submit" class="btn btn-primary"><i class="bi bi-person-plus"></i> Registrar
					Persona</button>
			</div>
		</form>

	</div>
</body>

</html>