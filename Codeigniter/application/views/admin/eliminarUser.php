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
    <!-- Formulario de búsqueda -->
    <form method="post" action="<?php echo base_url('index.php/admin/DeleteUser/buscar'); ?>">
        <input type="text" name="busqueda" placeholder="Buscar por cedula,correo, etc.">
        <button type="submit">Buscar</button>
    </form>

    <div class="col-12 m-0 p-3">
        <h1 class="text-primary text-center">TABLA CON LISTA DE USUARIOS</h1>

        <table class="table">
            <thead class="table-dark">
                <tr>
                    <th scope="col">Cedula</th>
                    <th scope="col">Email</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Eliminar</th>
                </tr>
            </thead>
            <tbody id="date_user">
                <?php if (isset($exitoso)): ?>
                    <script>
                        Swal.fire({
                            title: 'ELIMINACION EXITOSO',
                            text: 'EL usuario ha sido eliminado con éxito',
                            icon: 'success',
                        });
                    </script>
                <?php endif ?>
                <?php if (isset($error)): ?>
                    <script>
                        Swal.fire({
                            title: 'NO SE PUDO ELIMINAR',
                            text: 'Hubo un problema a la eliminacion del usuario',
                            icon: 'error',
                        });
                    </script>
                <?php endif ?>
                <?php
                if (!empty($resultado)) {
                    // esta parte toca correjirla todavia no encuentro la solucion para poder mostrar el usuario buscado sin que me muestre todos literalmente nose si me busca 
                    foreach ($resultado as $usuario) {
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
                                <form method="post"
                                    action="<?php echo base_url('index.php/admin/DeleteUser/eliminar/' . $usuario->cedula); ?>">
                                    <button type="submit" class="btn btn-danger">Eliminar</button>
                                </form>
                            </td>
                        </tr>
                        <?php
                    }
                } else {
                    // sino hace busqueda se le muestra los datos normales 
                    foreach ($lista as $usuario) {
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
                                <form method="post"
                                    action="<?php echo base_url('index.php/admin/DeleteUser/eliminar/' . $usuario->cedula); ?>">
                                    <button type="submit" class="btn btn-danger">Eliminar</button>
                                </form>
                            </td>
                        </tr>
                        <?php
                    }
                }
                ?>
            </tbody>
        </table>
    </div>
</div>
<!-- cargamos el footer -->
<?php
$this->load->view('layouts/footer');
?>