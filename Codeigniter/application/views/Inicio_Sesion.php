<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link href="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.20/dist/sweetalert2.min.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.20/dist/sweetalert2.all.min.js"></script>
</head>

<body>

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h4>Iniciar Sesión</h4>
                    </div>
                    <div class="card-body">
                        <!--  esta condicion es ara saber si los datos son correctos ono-->
                        <?php if (isset($ErrorInData)): ?>
                            <div class="mt-4 text-center alert alert-danger">
                                NO EXISTE UN USUARIO CON LOS DATOS
                            </div>
                        <?php endif ?>
                        <!-- este es para saber si los datos esta incompletos  -->
                        <?php if (isset($ErrorInData)): ?>
                            <div class="mt-4 text-center alert alert-danger">
                                DATOS INCOMPLETOS
                            </div>
                            <script>
                                Swal.fire({
                                    title: 'DATOS INVALIDOS',
                                    text: 'El correo y contraseña son obligatorios.',
                                    icon: 'error',
                                });
                            </script>
                        <?php endif ?>
                        <form action="<?= base_url('index.php/Login/ValidarIngreso') ?>" method="post">
                            <div class="mb-3">
                                <label for="email" class="form-label">Correo Electrónico</label>
                                <input type="email"
                                    class="form-control <?= (isset($valueEmail) && $valueEmail != '') ? 'is-valid' : ((isset($errorInData)) ? 'is-invalid' : '') ?>"
                                    id="email" placeholder="correo@example.com" name="campo_email"
                                    value="<?= (isset($valueEmail)) ? $valueEmail : '' ?>">
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Contraseña</label>
                                <input type="password"
                                    class="form-control <?= (isset($valueEmail) && $valuePassword != '') ? 'is-valid' : ((isset($errorInData)) ? 'is-invalid' : '') ?>"
                                    id="password" name="campo_password"
                                    value="<?= (isset($valuePassword)) ? $valuePassword : '' ?>">
                            </div>
                            <div class="mb-3 form-check">
                                <input type="checkbox" class="form-check-input" id="remember">
                                <label class="form-check-label" for="remember">Recordarme</label>
                            </div>
                            <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
                        </form>
                        <div class="mt-3">
                            <a href="#">¿Olvidaste tu contraseña?</a>
                        </div>
                    </div>
                    <div class="card-footer">
                        <p>¿No tienes una cuenta? <a href="<?= base_url('index.php/Login/registrar') ?>">Regístrate aquí</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>