<?php
include 'Conexion.php';

if(!empty($_GET['correo'])  && !empty($_GET['password']) || !empty($_POST['correo'])  && !empty($_POST['password'])){
    $correo=(!empty($_POST["correo"]))?$_POST["correo"] :$_GET["correo"] ;
    $password=(!empty($_POST["password"]))?md5($_POST["password"]) :md5($_GET["password"]);

    

    $consulta=$base_de_datos->prepare("SELECT id_usuario,nombres FROM usuarios WHERE correo=:cor AND password=:pass");
    $consulta->bindParam(':cor',$correo);
    $consulta->bindParam(':pass',$password);
    $consulta->execute();
    // esto es para que no traiga registros duplicados y haga la repuesta mas rapida a la hora de la solicitud
    $datos= $consulta->fetchAll(PDO::FETCH_ASSOC);
    //esto sirver para la conversion de datos para que accepte caracteres de versiones mas modernas 
    $datos=mb_convert_encoding($datos,'UTF-8','iso-8859-1');

    if($datos){
        $respuesta=[
            'status'=>true,
            'message'=>"#USER FOUND#",
            'user'=>$datos[0]
        ];

        echo json_encode($respuesta);
    }else{
        $respuesta=[
            'status'=>false,
            'message'=>'#USER NO FOUND#'
        ];
        echo json_encode($respuesta);
    }

}else{
    $respuesta=[
        "status"=>false,
        "message"=>"#ERROR-DATA#"
    ];
    echo json_encode($respuesta);

}


?>