<?php
$dataHeader['titulo'] = "Inicio";
$this->load->view('layouts/header', $dataHeader)

  ?>
<!-- este es el sidebar -->
<?php
$dataSidebar['session'] = $session;
//  cargamos la vista
$this->load->view('layouts/sidebar', $dataSidebar);
?>

<!-- este es el unico contenido que cambiaria  -->

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

  <div class="col-12 m-0 p-3">
    <h1 class="text-primary text-center">FORMULARIO PARA CREAR USUARIO</h1>
  </div>

  <div class="container">
    <div class="row justify-content-center">
      <form class="mx-auto" action="<?= base_url('index.php/admin/crearUser/ingresarUser') ?>" method="POST">
        <?php if (isset($dateIncompletos)): ?>
          <div class="mt-4 text-center alert alert-danger">
            Faltan datos por llenar
          </div>
        <?php endif ?>
        <!-- este es para los datos correctos -->
        <?php if (isset($date_validos)): ?>
          <script>
            Swal.fire({
              title: 'DATOS VALIDOS',
              text: 'EL usuario ha sido creado con éxito',
              icon: 'success',
            });
          </script>
        <?php endif ?>

        <div class="row mb-3">
          <div class="col">
            <label for="new_cedula" class="form-label">
              <i class="fas fa-id-card"></i> Cédula
            </label>
            <input type="number" class="form-control" id="new_cedula" name="new_cedula">
          </div>
          <div class="col">
            <label for="new_nombres" class="form-label">
              <i class="fas fa-user"></i> Nombres
            </label>
            <input type="text" class="form-control" id="new_nombres" name="new_nombres">
          </div>
        </div>

        <div class="row mb-3">
          <div class="col">
            <label for="new_apellidos" class="form-label">
              <i class="fas fa-user"></i> Apellidos
            </label>
            <input type="text" class="form-control" id="new_apellidos" name="new_apellidos">
          </div>
          <div class="col">
            <label for="new_telefono" class="form-label">
              <i class="fas fa-phone"></i> Teléfono
            </label>
            <input type="tel" class="form-control" id="new_telefono" name="new_telefono">
          </div>
        </div>

        <div class="row mb-3">
          <div class="col">
            <label for="new_direccion" class="form-label">
              <i class="fas fa-map-marker-alt"></i> Dirección
            </label>
            <input type="text" class="form-control" id="new_direccion" name="new_direccion">
          </div>
        </div>

        <div class="row mb-3">
          <div class="col">
            <label for="new_correo" class="form-label">
              <i class="fas fa-envelope"></i> Correo
            </label>
            <input type="email" class="form-control" id="new_correo" name="new_correo">
          </div>
          <div class="col">
            <label for="new_password" class="form-label">
              <i class="fas fa-lock"></i> Password
            </label>
            <input type="password" class="form-control" id="new_password" name="new_password">
          </div>
        </div>

        <div class="row mb-3">
          <div class="col">
            <label for="new_tipo" class="form-label">
              <i class="fas fa-user"></i> Tipo
            </label>
            <select class="form-select" id="new_tipo" name="new_tipo">
              <option value="VENDEDOR">VENDEDOR</option>
              <option value="ADMIN">ADMINISTRADOR</option>
            </select>
          </div>
        </div>

        <div class="text-center">
          <button type="submit" class="btn btn-primary">Create User</button>
        </div>
      </form>
    </div>
  </div>



</div>

<!-- cargamos el footer -->
<?php
$this->load->view('layouts/footer');
?>