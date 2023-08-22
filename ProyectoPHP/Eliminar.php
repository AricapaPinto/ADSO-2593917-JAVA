<?php
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST");
header("Access-Control-Allow-Headers: Content-Type");
include_once("Conexion.php");

// hacemos la eliminacion de el cliente dependiendo de la condicion de la cedula es igual a la de la base de datos 

if (!empty($_POST['cedula'])) {
        $cedula = $_POST['cedula'];
        try {
          $eliminar=$base_de_datos->prepare("DELETE FROM personas WHERE cedula=:cedula");
          $eliminar->bindParam(':cedula', $cedula);

          $respuesta_BD = $eliminar->execute();

          if($respuesta_BD){
            $respuesta = [
              'status' => true,
              'mesagge' => "OK##CLIENT##DELETE"
            ];
            echo json_encode($respuesta);

          }else{
            $respuesta = [
              'status' => false,
              'mesagge' => "ERROR##CLIENT##DELETE"
            ];
            echo json_encode($respuesta);
          }
        } catch (Exception $e) {
          $respuesta = [
            'status' => false,
            'mesagge' => "ERROR##SQL##NOT DELETE",
            'exception' => $e
          ];
          echo json_encode($respuesta);
        }
} else {
  $respuesta['respuesta'] = [
    'status' => false,
    'mesagge' => "ERROR##DELETE##POST",
  ];
  echo json_encode($respuesta);
}

?>