<?php
include 'Conexion.php';

if (!empty($_GET['id_cuestionario']) && !empty($_GET['id_pregunta']) && !empty($_GET['respuesta']) && !empty($_GET['estado']) && !empty($_GET['fecha']) || !empty($_POST['id_cuestionario']) && !empty($_POST['id_pregunta']) && !empty($_POST['respuesta']) && !empty($_POST['estado']) && !empty($_POST['fecha'])) {

    $id_cuestionario = (!empty($_POST["id_cuestionario"])) ? $_POST["id_cuestionario"] : $_GET["id_cuestionario"];
    $id_pregunta = (!empty($_GET["id_pregunta"])) ? $_GET["id_pregunta"] : $_POST["id_pregunta"];
    $respuesta = (!empty($_GET["respuesta"])) ? $_GET["respuesta"] : $_POST["respuesta"];
    $estado = (!empty($_GET["estado"])) ? $_GET["estado"] : $_POST["estado"];
    $fecha = (!empty($_GET["fecha"])) ? $_GET["fecha"] : $_POST["fecha"];

    try {
        $consulta = $base_de_datos->prepare("INSERT INTO respuestas (id_cuestionario, id_pregunta, respuesta, estado, fecha) VALUES (:idC, :idP, :res, :es, :fe)");

        $consulta->bindParam(':idC', $id_cuestionario);
        $consulta->bindParam(':idP', $id_pregunta);
        $consulta->bindParam(':res', $respuesta);
        $consulta->bindParam(':es', $estado);
        $consulta->bindParam(':fe', $fecha);

        $proceso = $consulta->execute();

        if ($proceso) {
            $respuesta = [
                'status' => true,
                'message' => '#OK#RESPUESTA#INSERT',
                'id_respuesta' => $id_respuesta
            ];
            echo json_encode($respuesta);
        } else {
            $respuesta = [
                'status' => false,
                'message' => '#ERROR#RESPUESTA#INSERT'
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
