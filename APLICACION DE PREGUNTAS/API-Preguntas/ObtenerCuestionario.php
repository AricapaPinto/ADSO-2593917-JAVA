<?php
// incluimos el archivo php
include "Conexion.php";

if (!empty($_GET['id_usuario']) || !empty($_POST['id_usuario'])){

    $id_usuario = (!empty($_POST['id_usuario'])) ? $_POST['id_usuario'] : $_GET['id_usuario'];

    $peticion=$base_de_datos->prepare("SELECT * FROM cuestionarios WHERE id_usuario=:id");
    $peticion->bindParam(':id',$id_usuario);

    $peticion->execute();

    $datos=$peticion->fetchAll(PDO::FETCH_ASSOC);
    //esto sirver para la conversion de datos para que accepte caracteres de versiones mas modernas 
    $datos=mb_convert_encoding($datos,'UTF-8','iso-8859-1');
    if ($datos) {
        $respuesta =[
                        'status' =>true,
                        'message' =>'USER##FOUND',
                        'usuarios' =>$datos
                    ];
        echo json_encode($respuesta);
    }else{
        $respuesta =[
                        'status' =>false,
                        'message' =>'USER##NOT##FOUND'
                    ];
        echo json_encode($respuesta);
    }
}else{
    $respuesta=[
        'status'=>false,
        'message'=>'#ERROR IN DATE ENTER#',
    ];
    echo json_encode($respuesta);
}


?>