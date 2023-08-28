<?php 
  $dataHeader['titulo']= "Inicio";
  $this->load->view('layouts/header',$dataHeader)
  
?>
<!-- este es el sidebar -->
<?php 
   $dataSidebar['session']=$session;
  //  cargamos la vista
  $this->load->view('layouts/sidebar',$dataSidebar);
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
            </tr>
          </thead>
          <tbody id="date_user">
            <?php foreach ($lista as $usuario) { ?>
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
                
              </tr>
            <?php } ?>
          </tbody>

        </table>
      </div>
    </div>

    <!-- cargamos el footer -->
<?php
$this->load->view('layouts/footer');
?>

