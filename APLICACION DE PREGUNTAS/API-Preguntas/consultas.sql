

SELECT preguntas.*,opciones.* FROM respuestas INNER JOIN preguntas ON 
(respuestas.id_pregunta=preguntas.id) 
INNER JOIN opciones ON 
(preguntas.id=opciones.id_pregunta) WHERE respuestas.id_cuestionario=1;
