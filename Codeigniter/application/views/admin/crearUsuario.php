<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet"
    href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<?= base_url('plugins/fontawesome-free/css/all.min.css') ?>">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet"
    href="<?= base_url('plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css') ?>">
  <!-- Theme style -->
  <link rel="stylesheet" href="<?= base_url('dist/css/adminlte.min.css') ?>">

  <!-- url de mensaje de ok de mensaje link  -->
  <link href="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.20/dist/sweetalert2.min.css" rel="stylesheet">


  <!-- scrip para mostra el mensaje de que el usuario a sido creado con exito  -->
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.20/dist/sweetalert2.all.min.js"></script>

</head>

<body class="hold-transition sidebar-mini layout-fixed">
  <div class="wrapper">

    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
      <!-- Left navbar links -->
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
        </li>
      </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
      <!-- Brand Logo -->
      <a href="index3.html" class="brand-link">
        <img src="<?= base_url('dist/img/AdminLTELogo.png') ?>" alt="AdminLTE Logo"
          class="brand-image img-circle elevation-3" style="opacity: .8">
        <span class="brand-text font-weight-light">Proyecto MVC</span>
      </a>

      <!-- Sidebar -->
      <div class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
          <div class="image">
            <img src="<?= base_url('dist/img/users/' . $session['foto']) ?>" class="img-circle elevation-2"
              alt="User Image">
          </div>
          <div class="info">
            <a href="#" class="d-block">
              <?= explode(" ", $session['nombres'])[0] . " " . explode(" ", $session['apellidos'])[0] ?>
            </a>
          </div>
        </div>

        <!-- Sidebar Menu -->
        <nav class="mt-2">
          <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
            <li class="nav-header">MENU ADMIN</li>
            <li class="nav-item">
              <a href="<?= base_url('index.php/admin/Inicio/openCreateUser') ?>" class="nav-link">
                <i class="nav-icon far fa-calendar-alt"></i>
                <p>
                  Crear Usuario
                </p>
              </a>
            </li>
            <li class="nav-item">
              <a href="<?= base_url('index.php/admin/listenUsers/getListenUsers') ?>" class="nav-link">
                <i class="nav-icon far fa-image"></i>
                <p>
                  Ver Usuarios
                </p>
              </a>
            </li>
            <li class="nav-item">
              <a href="<?= base_url('index.php/Login/cerrarSession') ?>" class="nav-link">
                <i class="nav-icon fas fa-columns"></i>
                <p>
                  Cerrar Sesion
                </p>
              </a>
            </li>

          </ul>
        </nav>
        <!-- /.sidebar-menu -->
      </div>
      <!-- /.sidebar -->
    </aside>

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
                  text: 'EL usuario a sido creado con exito',
                  icon: 'success',
                  });
              </script>
            <?php endif ?>

            <div class="mb-3">
              <label for="exampleInputCedula" class="form-label">
                <i class="fas fa-id-card"></i> Cédula
              </label>
              <input type="number" class="form-control" name="new_cedula">
            </div>
            <div class="mb-3">
              <label for="exampleInputCorreo" class="form-label">
                <i class="fas fa-envelope"></i> Correo
              </label>
              <input type="email" class="form-control" name="new_correo">
            </div>
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">
                <i class="fas fa-lock"></i> Password
              </label>
              <input type="password" class="form-control" name="new_password">
            </div>
            <div class="mb-3">
              <label for="exampleInputTipo" class="form-label">
                <i class="fas fa-user"></i> Tipo
              </label>
              <select class="form-select" name="new_tipo">
                <option value="VENDEDOR">VENDEDOR</option>
                <option value="ADMIN">ADMINISTRADOR</option>
              </select>
            </div>
            <div class="text-center">
              <button type="submit" class="btn btn-primary">Create User</button>

            </div>
          </form>
        </div>
      </div>


    </div>
  </div>

  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <strong>Copyright &copy; 2023 <a href="https://adminlte.io">ADSO 2593917</a>.</strong>
    All rights reserved.
    <div class="float-right d-none d-sm-inline-block">
      <b>Version</b> 3.2.0
    </div>
  </footer>
  </div>
  <!-- ./wrapper -->

  <!-- jQuery -->
  <script src="<?= base_url('plugins/jquery/jquery.min.js') ?>"></script>
  <!-- Bootstrap 4 -->
  <script src="<?= base_url('plugins/bootstrap/js/bootstrap.bundle.min.js') ?>"></script>
  <!-- AdminLTE App -->
  <script src="<?= base_url('dist/js/adminlte.js') ?>"></script>

  <!-- error de insercion de datos -->
  <?php if ($error_insert): ?>
    <script>
      Swal.fire({
        title: 'ERROR 404',
        text: 'No se pudo ingresar los datos',
        icon: 'error',
      });
    </script>
  <?php endif ?>
</body>

</html>