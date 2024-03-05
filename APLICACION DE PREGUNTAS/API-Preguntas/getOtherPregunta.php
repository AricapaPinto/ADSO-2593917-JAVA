<?php
include "Conexion.php";

// Obtener la cantidad total de preguntas
$queryTotalPreguntas = $base_de_datos->query("SELECT COUNT(*) as total FROM preguntas");
$totalPreguntas = $queryTotalPreguntas->fetch(PDO::FETCH_ASSOC)['total'];

// Obtener un número aleatorio entre 1 y el total de preguntas
$preguntaAleatoriaID = rand(1, $totalPreguntas);

// Consultar la pregunta aleatoria
$queryPreguntaAleatoria = $base_de_datos->prepare("SELECT * FROM preguntas WHERE id = :idPregunta");
$queryPreguntaAleatoria->bindParam(':idPregunta', $preguntaAleatoriaID);
$queryPreguntaAleatoria->execute();
$preguntaAleatoria = $queryPreguntaAleatoria->fetch(PDO::FETCH_ASSOC);

// consultamos la cantidad de preguntas 



if ($preguntaAleatoria) {
    // Obtener las opciones de la pregunta aleatoria
    $id_pregunta = $preguntaAleatoria['id'];

    $queryOpciones = $base_de_datos->prepare("SELECT * FROM opciones WHERE opciones.id_pregunta = :idPregunta");
    $queryOpciones->bindParam(':idPregunta', $id_pregunta);
    $queryOpciones->execute();
    $opciones = $queryOpciones->fetchAll(PDO::FETCH_ASSOC);

    // Aquí agregamos la pregunta y las opciones referentes a la respuesta
    $respuesta = [
        'status' => true,
        'pregunta_a' => [
            'pregunta' => $preguntaAleatoria,
            'opciones' => $opciones,
            'cantidad'=>$totalPreguntas
        ]
    ];

    // Imprimimos la respuesta JSON al final del script
    echo json_encode($respuesta);
} else {
    $respuesta = [
        'status' => false,
        'message' => 'No se encontró la pregunta aleatoria.'
    ];

    echo json_encode($respuesta);
}
?>
