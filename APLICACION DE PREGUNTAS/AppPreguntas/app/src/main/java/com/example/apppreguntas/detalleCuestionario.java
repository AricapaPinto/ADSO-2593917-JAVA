package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apppreguntas.utils.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class detalleCuestionario extends AppCompatActivity {

    Config configuracion;
    TextView nombre_user,fecha_inicio,can_preguntas_c,cant_incorrectas_v,cant_correctas_v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_cuestionario);
        this.nombre_user=findViewById(R.id.nombre_user);
        this.fecha_inicio=findViewById(R.id.fecha_inicio);
        this.can_preguntas_c=findViewById(R.id.cant_preguntas);
        this.cant_incorrectas_v=findViewById(R.id.cant_incorrectas);
        this.cant_correctas_v=findViewById(R.id.cant_correctas);
        configuracion=new Config(getApplicationContext());
        // obtenemos aqui la intencion
        Intent intent=getIntent();
        // recuperamos el objeto Json

        String id_cuestionario=intent.getStringExtra("id_cuestionario");
        String fecha=intent.getStringExtra("fecha_inicio");
        if(!id_cuestionario.equals("") && !fecha.equals("")){

            // mostramos el nombre del usuario la fecha de inicio
            //obtenemos el valor de shared
            SharedPreferences archivo=getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);
            this.nombre_user.setText(archivo.getString("nombres",""));
            this.fecha_inicio.append(fecha);
            // ejecutamos la funcion
            detalleCuestionario(id_cuestionario);
        }

    }

    // creamos metodo para mostrar los datos de ese cuestionario
    public void detalleCuestionario(String id_cuestionario){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url =  configuracion.getEndpoint("API-Preguntas/GetDetalleCuestionario.php");;

        StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("El servidor POST responde OK");
                    JSONObject jsonObject = new JSONObject(response);

                    System.out.println(response);
                    mostrarDetalles(jsonObject);

                } catch (JSONException e) {
                    System.out.println("El servidor POST responde con un error 1:");
                    System.out.println(e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor POST responde con un error 2:");
                System.out.println(error.getMessage());
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put("id_cuestionario",id_cuestionario);
                return params;
            }
        };

        queue.add(solicitud);
    }
    public void mostrarDetalles(JSONObject jsonRespuestas) {

        try {
            // Obtener el valor de "status"
            boolean status = jsonRespuestas.getBoolean("status");
            // Verificar si se encontraron detalles
            if (status) {
                // Obtener el array "respuestas"
                JSONArray respuestasArray = jsonRespuestas.getJSONArray("respuestas");

                int cant_preguntas=0;
                cant_preguntas=respuestasArray.length();
                this.can_preguntas_c.append(""+cant_preguntas);

                //  iniciamos la variable en cero
                int cantIncorrectas=0;
                int cantCorrectas=0;


                LinearLayout layoutPadre = findViewById(R.id.container_descripcion);

                for (int i = 0; i < respuestasArray.length(); i++) {
                    // Obtener el objeto "pregunta"
                    JSONObject respuestaObj = respuestasArray.getJSONObject(i);
                    JSONObject preguntaObj = respuestaObj.getJSONObject("pregunta");

                    // Obtener datos de la pregunta
                    int idPregunta = preguntaObj.getInt("id");
                    String descripcionPregunta = preguntaObj.getString("descripcion");
                    String urlImagen = preguntaObj.getString("url_imagen");
                    int respuestaPregunta = preguntaObj.getInt("respuesta");
                    String estadoPregunta = preguntaObj.getString("estado");


                    // Crear un nuevo LinearLayout para la pregunta
                    LinearLayout layoutPregunta = new LinearLayout(this);
                    layoutPregunta.setOrientation(LinearLayout.VERTICAL);
                    LinearLayout.LayoutParams paramsPregunta = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    layoutPregunta.setLayoutParams(paramsPregunta);

                    // Crear un TextView para mostrar el número de la pregunta
                    TextView textViewNumeroPregunta = new TextView(this);

                    // Establecer el texto y formato
                    textViewNumeroPregunta.setText("Pregunta " + idPregunta);
                    textViewNumeroPregunta.setTextSize(18);
                    textViewNumeroPregunta.setTypeface(null, Typeface.BOLD);
                    // Agregar el TextView al layout
                    layoutPregunta.addView(textViewNumeroPregunta);

                    // Crear un TextView para mostrar la descripción de la pregunta
                    TextView textViewDescripcionPregunta = new TextView(this);
                    textViewDescripcionPregunta.setText(descripcionPregunta);
                    layoutPregunta.addView(textViewDescripcionPregunta);
                    // con esto obtenemos los valores de las respuestas correctas e incorrectas
                    String respuestaSeleccionada = preguntaObj.getString("respuesta");
                    String respuestaCorrecta = preguntaObj.getString("id_correcta");
                    //System.out.println("Respuestas Selecionada "+respuestaSeleccionada +"Respuesta Correcta");

                    if (!respuestaSeleccionada.equals(respuestaCorrecta)) {
                        cantIncorrectas++;
                    }else{
                        cantCorrectas++;
                    }
                    // Iterar sobre cada elemento en "opciones"
                    JSONArray opcionesArray = respuestaObj.getJSONArray("opciones");
                    for (int j = 0; j < opcionesArray.length(); j++) {
                        JSONObject opcionObj = opcionesArray.getJSONObject(j);

                        // Obtener datos de cada opción
                        int idOpcion = opcionObj.getInt("id");
                        int idPreguntaOpcion = opcionObj.getInt("id_pregunta");
                        String descripcionOpcion = opcionObj.getString("descripcion");

                        // Crear un TextView para mostrar la opción
                        TextView textViewOpcion = new TextView(this);

                        // Establecer el texto y formato, o sea el punto.
                        textViewOpcion.setText("\u2022 " + descripcionOpcion);
                        textViewOpcion.setTextSize(16);

                        // Verificar si la opción es la que seleccionó el usuario
                        if (respuestaSeleccionada.equals(String.valueOf(idOpcion))) {

                            if (respuestaCorrecta.equals(respuestaSeleccionada)) {

                                textViewOpcion.setTextColor(Color.GREEN);
                                System.out.println("Opción en verde");
                            } else {

                                textViewOpcion.setTextColor(Color.RED);
                                System.out.println("Opción en rojo");
                            }
                        }
                        layoutPregunta.addView(textViewOpcion);
                    }

                    // Agregar el LinearLayout de la pregunta al layoutPadre
                    layoutPadre.addView(layoutPregunta);
                }

                // aqui agregamos los valores de la cantidad de correctas e incorrectas

                this.cant_incorrectas_v.append(""+cantIncorrectas);
                this.cant_correctas_v.append(""+cantCorrectas);
                //System.out.println("cantidad Preguntas\n"+cant_preguntas+"Cant incorrectas\n"+cantIncorrectas);
            } else {
                // Manejar el caso en el que no se encontraron detalles
            }
        } catch (JSONException e) {
            e.printStackTrace();
            // Manejar errores de parsing JSON
        }
    }

    public void volverAtras(View v){
        // creamos la itencion para mandarlo atras
        Intent intencion= new Intent(getApplicationContext(),InicioUser.class);
        startActivity(intencion);

        finish();
    }
}