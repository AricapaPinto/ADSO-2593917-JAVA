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
    <h1 class="text-primary text-center">TABLA CON LISTA DE USUARIOS</h1>

    <table class="table">
      <thead class="table-dark">
        <tr>
          <th scope="col">Cedula</th>
          <th scope="col">Email</th>
          <th scope="col">Tipo</th>
          <th scope="col">Estado</th>
          <th scope="col">Actualizar</th>
        </tr>
      </thead>
      <tbody id="date_user">
        <?php
        $contador = 0; // Inicializa el contador en 0
        
        foreach ($lista as $usuario) {
          $contador++; // Incrementa el contador en cada iteración
          ?>
          <tr>
            <td>
              <?php echo $usuario->cedula; ?>
            </td>
            <td>
              <?php echo $usuario->email; ?>
            </td>
            <td>
              <?php echo $usuario->tipo; ?>
            </td>
            <td>
              <?php echo $usuario->estado; ?>
            </td>
            <td>
              <!-- Agregar un botón para eliminar el usuario -->
              <button type="button" onclick="getCliente(<?php echo $usuario->cedula; ?>)" class="btn btn-primary"
                data-bs-toggle="modal" data-bs-target="#exampleModal">
                Actualizar
              </button>

            </td>
          </tr>
          <?php
        }
        ?>
      </tbody>

    </table>
  </div>
</div>
<!-- model para el modal -->
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Editar User</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <!--creamos el formulario el cual vamos a agregar el usuario   -->
        <form action="#" method="POST" id="actulizarCliente">
          <div class="mb-3">
            <i class="fas fa-file"></i>
            <label for="document" class="form-label">Documento</label>
            <input type="text" class="form-control" id="editar_documento" aria-describedby="documento-identidad"
              readonly>

          </div>
          <div class="mb-3">
            <i class="fas fa-user"></i>
            <label for="name" class="form-label">Nombres</label>
            <input type="text" class="form-control" id="editar_nombre" aria-describedby="nombres_user" required>
          </div>
          <div class="mb-3">
            <i class="fas fa-user"></i>
            <label for="exampleInputEmail1" class="form-label">Apellidos</label>
            <input type="text" class="form-control" id="editar_apellido" aria-describedby="emailHelp" required>

          </div>
          <div class="mb-3">
            <i class="fas fa-phone"></i>
            <label for="exampleInputEmail1" class="form-label">Telefonos</label>
            <input type="text" class="form-control" id="editar_telefonos" aria-describedby="emailHelp" required>

          </div>
          <div class="mb-3">
            <i class="fas fa-map-marker-alt"></i>
            <label for="exampleInputEmail1" class="form-label">Direccion</label>
            <input type="text" class="form-control" id="editar_direcciones" aria-describedby="emailHelp" required>
          </div>
          <div class="mb-3">
            <i class="fas fa-envelope"></i>
            <label for="exampleInputEmail1" class="form-label">Correo</label>
            <input type="email" class="form-control" id="editar_correo" aria-describedby="emailHelp" required>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
            <button type="submit" class="btn btn-primary">Agregar</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<!-- cargamos el footer -->
<?php
$this->load->view('layouts/footer');
?>