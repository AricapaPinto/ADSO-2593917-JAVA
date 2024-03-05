<?php
// incluimos el archivo php
include "Conexion.php";



try {
    

    $peticion = $base_de_datos->prepare("SELECT * FROM usuarios");
   

    $peticion->execute();
    $datos = $peticion->fetchAll(PDO::FETCH_ASSOC);
    if ($datos) {
        $respuesta = [
            'status' => true,
            'message' => 'USER##FOUND',
            'usuarios' => $datos
        ];
        echo json_encode($respuesta);
    } else {
        $respuesta = [
            'status' => false,
            'message' => 'USER##NOT##FOUND'
        ];
        echo json_encode($respuesta);
    }
} catch (Exception $e) {

    $respuesta = [
        'status' => false,
        'message' => '##ERROR AL CONSULTAR ##'
    ];
    echo json_encode($respuesta);
}
