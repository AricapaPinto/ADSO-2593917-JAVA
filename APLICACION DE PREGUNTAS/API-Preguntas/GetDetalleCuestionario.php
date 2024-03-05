<?php
include "Conexion.php";

if (!empty($_GET['id_cuestionario']) || !empty($_POST['id_cuestionario'])) {

    $id_cuestionario = (!empty($_POST['id_cuestionario'])) ? $_POST['id_cuestionario'] : $_GET['id_cuestionario'];

    // Consulta para obtener respuestas
    $queryRespuestas = $base_de_datos->prepare("SELECT * FROM respuestas WHERE id_cuestionario = :idCuest");
    $queryRespuestas->bindParam(':idCuest', $id_cuestionario);
    $queryRespuestas->execute();
    $respuestas = $queryRespuestas->fetchAll(PDO::FETCH_ASSOC);

    if ($respuestas) {
        $respuesta = [
            'status' => true,
            'message' => 'DETAIL##FOUND',
            'respuestas' => []
        ];

        // Para cada respuesta, obtener la pregunta relacionada y las opciones
        foreach ($respuestas as $respuestaItem) {
            $id_pregunta = $respuestaItem['id_pregunta'];

            $queryPregunta = $base_de_datos->prepare("SELECT preguntas.*,opciones.id AS respuesta, respuestas.estado FROM preguntas 
            INNER JOIN respuestas ON (preguntas.id = respuestas.id_pregunta)
            INNER JOIN opciones ON (respuestas.respuesta = opciones.descripcion)
            WHERE preguntas.id = :idPregunta");

            $queryPregunta->bindParam(':idPregunta', $id_pregunta);
            $queryPregunta->execute();
            $pregunta = $queryPregunta->fetch(PDO::FETCH_ASSOC);
            //esto sirver para la conversion de datos para que accepte caracteres de versiones mas modernas 
            

            // aqui verificamos si se encontro una pregunta antes de seguir obteniendo el ultimo valor

            if ($pregunta) {
                $queryOpciones = $base_de_datos->prepare("SELECT * FROM opciones WHERE opciones.id_pregunta = :idPregunta");
                $queryOpciones->bindParam(':idPregunta', $id_pregunta);
                $queryOpciones->execute();
                $opciones = $queryOpciones->fetchAll(PDO::FETCH_ASSOC);

                // aqui agremos la pregunta y las opciones referente a la respuesta
                $respuesta['respuestas'][] = [
                    'pregunta' => $pregunta,
                    'opciones' => $opciones
                ];
            }
        }

        echo json_encode($respuesta);
    } else {
        $respuesta = [
            'status' => false,
            'message' => 'DETAIL##NOT##FOUND'
        ];
        echo json_encode($respuesta);
    }
} else {
    $respuesta = [
        'status' => false,
        'message' => '#ERROR IN DATE ENTER#',
    ];
    echo json_encode($respuesta);
}
