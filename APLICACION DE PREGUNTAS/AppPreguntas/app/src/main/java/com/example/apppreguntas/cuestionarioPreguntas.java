package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apppreguntas.utils.Config;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class cuestionarioPreguntas extends AppCompatActivity {
    Config Configuracion;
    private Set<Integer> preguntasSeleccionadas = new HashSet<>();
    private JSONObject preguntaActual;
    private JSONObject preguntaCompleta;

    private String idOpcionSeleccionada = "";
    private String fecha,nombre,id_cuestionario, opcionSeleccionada = "";

    TextView usuario_actual,pregunta_actual,inicio_fecha;

    private Boolean siguiente_pregunta=false,Guardar=false;
    Button siguienteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuracion = new Config(getApplicationContext());
        setContentView(R.layout.activity_cuestionario_preguntas);
        // Aquí ejecutamos el método para obtener la primera pregunta
        obtenerPreguntaDesdeServidor();
        this.siguienteButton = findViewById(R.id.buttonSiguiente);
        this.usuario_actual=findViewById(R.id.nombre_user);
        this.pregunta_actual=findViewById(R.id.pregunta_actual);
        this.inicio_fecha=findViewById(R.id.fecha_inicio);

        // obtenemos los valores de la fecha
        // Recuperar la fecha del Intent
        Intent intent = getIntent();
        this.fecha = intent.getStringExtra("fecha");
        this.nombre = intent.getStringExtra("nombres");
        this.usuario_actual.setText("Usuario:"+nombre);
        this.inicio_fecha.append(" "+fecha);
        this.id_cuestionario = intent.getStringExtra("id_cuestionario");

        siguienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // preguntamos primero si hay valores seleccionados
                if(siguiente_pregunta){
                    siguiente_pregunta=false;
                    obtenerPreguntaDesdeServidor();

                }else{
                    System.out.println("Seleccionar una opcion");
                }
            }
        });
    }

    private void obtenerPreguntaDesdeServidor() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = Configuracion.getEndpoint("API-Preguntas/getOtherPregunta.php");
        JsonObjectRequest solicitud = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    boolean status = response.getBoolean("status");
                    if (status) {
                        // Obtén el objeto "pregunta_a" del JSON de respuesta
                        JSONObject preguntaA = response.getJSONObject("pregunta_a");

                        // Obtén la cantidad de preguntas directamente desde el objeto "pregunta_a"
                        int cantidad_b = preguntaA.getInt("cantidad");

                        int preguntasRespondidas = preguntasSeleccionadas.size();
                        if (preguntasRespondidas == cantidad_b) {
                            System.out.println("Se han usado todas las preguntas Metodo get ");
                            // ene este acaso cerramos esta vista y lo mandamos a la vista del cuestionario
                            // creamos la itencion para mandarlo atras
                            Intent intencion= new Intent(getApplicationContext(),InicioUser.class);
                            startActivity(intencion);
                            // cerramos para que no acceda a esto datos de nuevo
                            finish();
                        } else {
                            obtenerPregunta(response);
                        }
                    } else {
                        String message = response.getString("message");
                        // Maneja el caso en el que no hay más preguntas disponibles
                        System.out.println("Respuesta del servidor sin pregunta válida: " + message);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor responde con un error:");
                System.out.println(error.getMessage());
            }
        });

        queue.add(solicitud);
    }

    public void obtenerPregunta(JSONObject pregunta) {
        // validamos que esa pregunta no esté
        try {
            preguntaCompleta = pregunta.getJSONObject("pregunta_a");
            preguntaActual = preguntaCompleta.getJSONObject("pregunta");
            System.out.println("ID PREGUNTA CORRECTA:"+preguntaActual.optString("id_correcta"));
            int cantidad = preguntaActual.optInt("cantidad");
            int idPregunta = preguntaActual.optInt("id");

            //  aquí preguntamos si el ID recibido ya está o si no, que haga otra cosa
            if (!preguntasSeleccionadas.contains(idPregunta)) {
                // en este caso, la añadimos
                preguntasSeleccionadas.add(idPregunta);
                // mostramos la pregunta
                mostrarPregunta();
            } else {
                int preguntasRespondidas = preguntasSeleccionadas.size();
                if (preguntasRespondidas == cantidad) {
                    System.out.println("Se han usado todas las preguntas Meto obten");
                    // No hay necesidad de hacer nada más
                }
                // Colocar la llamada fuera de la condición
                obtenerPreguntaDesdeServidor();
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }



    // Función para mostrar la pregunta actual
    private void mostrarPregunta() {
        // Obtener referencia al LinearLayout principal
        LinearLayout contenedorPrincipal = findViewById(R.id.contenedorPrincipal);


        // CREO QUE EL PROBLEMA VIENE DE AQUI 
        // Limpiar el LinearLayout antes de agregar nuevos elementos
        contenedorPrincipal.removeAllViews();

        // Crear TextView para la pregunta
        TextView textViewPregunta = new TextView(this);
        textViewPregunta.setText("Pregunta seleccionada: " + preguntaActual.optString("descripcion"));
        this.pregunta_actual.setText("Pregunta Actual :"+preguntaActual.optInt("id"));

        // Crear ImageView para la imagen (usando Picasso )
        int ancho = 450;
        int alto = 450;

        // Crear ImageView para la imagen (usando Picasso como ejemplo)
        ImageView imageViewPregunta = new ImageView(this);
        String urlImagen = preguntaActual.optString("url_imagen");

        Picasso.get().load(urlImagen)
                .resize(ancho, alto)
                .centerCrop() // Opcional: Puedes usar centerCrop() para recortar la imagen si no coincide exactamente con el tamaño especificado.
                .into(imageViewPregunta);


        // Agregar TextView e ImageView al LinearLayout principal
        contenedorPrincipal.addView(textViewPregunta);
        contenedorPrincipal.addView(imageViewPregunta);
        try {
            JSONArray opcionesArray = preguntaCompleta.getJSONArray("opciones");
            // Crear un RadioGroup
            RadioGroup radioGroup = new RadioGroup(this);
            radioGroup.setOrientation(RadioGroup.VERTICAL);

            for (int i = 0; i < opcionesArray.length(); i++) {
                JSONObject opcion = opcionesArray.getJSONObject(i);

                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(opcion.optString("descripcion"));
                radioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    if (isChecked) {
                        // Actualizar los valores de la opción seleccionada
                        opcionSeleccionada = opcion.optString("descripcion");
                        idOpcionSeleccionada = opcion.optString("id");
                        System.out.println("Opcione seleccionada"+idOpcionSeleccionada);
                        siguiente_pregunta=true;
                        Guardar=true;

                        // Llamar al nuevo método para obtener y procesar la opción seleccionada

                    }
                });

                radioGroup.addView(radioButton);
            }
            // aqui verificamo si el valor guardar es true para seguir con el procedimiento de guardado
            if(Guardar){
                obtenerOpcionSeleccionada();
            }

            // Agregar el RadioGroup al LinearLayout principal
            contenedorPrincipal.addView(radioGroup);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    private void obtenerOpcionSeleccionada() {
        if (Guardar) {
            // guardamos los valores en base de datos


            if (!opcionSeleccionada.isEmpty() && idOpcionSeleccionada!="" && !this.fecha.isEmpty() && !this.nombre.isEmpty()) {
                String id_correcta = preguntaActual.optString("id_correcta");
                String pregunta_id=preguntaActual.optString("id");
                String descripcion_pregunta=preguntaActual.optString("descripcion");



                // comparamos el id_opcion seleccionado con el id_correcta

                System.out.println("ID_CORRECTA:"+id_correcta+"  Descripcion de la pregunta: "+descripcion_pregunta);

                String estado = (idOpcionSeleccionada.equals(id_correcta)) ? "OK" : "ERROR";
                System.out.println("Estado de respuesta: "+estado);
                System.out.println("ID "+id_correcta +" LA SELECCIONADA"+ idOpcionSeleccionada);

                // Imprimir los valores de las variables
                //System.out.println("ID Cuestionario: " + id_cuestionario);
                //System.out.println("ID Pregunta: " +pregunta_id);
                //System.out.println("Respuesta: " + opcionSeleccionada);
                //System.out.println("Estado: " + estado);
                //System.out.println("Fecha: " + fecha);


                // metemos los valores
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url = Configuracion.getEndpoint("API-Preguntas/InsertRespuestaCuestionario.php");
                StringRequest solicitud = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            System.out.println("El servidor POST responde OK");
                            JSONObject jsonObject = new JSONObject(response);
                            System.out.println("Respuesta del Servidor\n"+jsonObject);
                        } catch (JSONException e) {
                            System.out.println("El servidor POST responde con un error 1:");
                            System.out.println("ERROR: "+e);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("El servidor POST responde con un error 2:");
                        System.out.println(error.getMessage());
                    }
                }) {
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put("id_cuestionario", id_cuestionario);
                        params.put("id_pregunta",pregunta_id);
                        params.put("respuesta", opcionSeleccionada);
                        params.put("estado", estado);
                        params.put("fecha", fecha);
                        return params;
                    }
                };
                queue.add(solicitud);
                // volvemos el dato a false
                Guardar=false;
            }else{
                System.out.println("Faltan datos por llennar");
            }
        }else{
            System.out.println("El valor es falso ");
        }
    }
}
