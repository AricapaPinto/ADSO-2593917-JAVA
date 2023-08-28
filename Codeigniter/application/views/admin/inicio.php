<?php
$dataHeader['titulo'] = "Inicio";
$this->load->view('layouts/header', $dataHeader)

  ?>
<!-- este es el sidebar -->
<?php

//  cargamos la vista
$this->load->view('layouts/sidebar');
?>

<!-- este es el unico contenido que cambiaria  -->

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <div class="col-12 m-0 p-3">
    <h1 class="text-primary text-center">INICIO DEL ADMIN</h1>
  </div>
</div>

<!-- cargamos el footer -->
<?php
$this->load->view('layouts/footer');
?>
