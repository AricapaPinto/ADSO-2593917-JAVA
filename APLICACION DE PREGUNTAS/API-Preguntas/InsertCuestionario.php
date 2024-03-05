<?php
include 'Conexion.php';

if (!empty($_GET['id_usuario']) && !empty($_GET['fecha_inicio']) || !empty($_POST['id_usuario']) && !empty($_POST['fecha_inicio'])) {

    $id_usuario = (!empty($_POST["id_usuario"])) ? $_POST["id_usuario"] : $_GET["id_usuario"];
    $fecha = (!empty($_POST["fecha_inicio"])) ? $_POST["fecha_inicio"] : $_GET["fecha_inicio"];

    try {

        $consulta = $base_de_datos->prepare("INSERT INTO cuestionarios (id_usuario, fecha_inicio) VALUES (:id, :fe)");
        $consulta->bindParam(':id', $id_usuario);
        $consulta->bindParam(':fe', $fecha);
        $proceso = $consulta->execute();

        if ($proceso) {
            // Obtenemos el id del cuestionario recién insertado
            $id_cuestionario = $base_de_datos->lastInsertId();

            $respuesta = [
                'status' => true,
                'message' => '#OK##CUESTIONARIO##INSERT',
                'id_cuestionario' => $id_cuestionario
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'message' => '#ERROR##CUESTIONARIO##INSERT'
            ];
            echo json_encode($respuesta);
        }
    } catch (Exception $e) {
        $respuesta = [
            'status' => false,
            'type' => 500,
            'mesagge' => "ERROR##SQL",
            'exception' => $e
        ];
        echo json_encode($respuesta);
    }
} else {
    $respuesta = [
        "status" => false,
        "message" => "#ERROR-DATA#"
    ];
    echo json_encode($respuesta);
}
