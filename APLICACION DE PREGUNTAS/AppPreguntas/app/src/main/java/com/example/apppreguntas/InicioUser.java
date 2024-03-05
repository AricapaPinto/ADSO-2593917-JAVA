package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.SpringAnimation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import java.util.Map;

public class InicioUser extends AppCompatActivity {

    TextView name_user;
    Config configuracion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_user);
        this.name_user=findViewById(R.id.name_user);

        configuracion=new Config(getApplicationContext());
        SharedPreferences archivo=getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);
        this.name_user.setText(archivo.getString("nombres",""));
        // verificamos que aya id para no aver fallos

        String id_user=archivo.getString("id_usuario",null);
        if(id_user!=null){
            // ejecutamos la fucion
            getCuestionarios(id_user);
        }else{
            // mensaje de error
        }
    }
    // metodo para cerrar seccion
    public void cerrar(View v){
        // obtenemos los datos para eliminar
        SharedPreferences sp=getSharedPreferences("app_preguntas",Context.MODE_PRIVATE);
        // aqui estamos diciendo que vamos a editar ya sea eliminar o obtener
        SharedPreferences.Editor editor=sp.edit();
        // aqui eliminamos los datos
        editor.clear();
        // guardamos cambios
        editor.commit();
        // creamos la actividaad para devolverlo al login

        Intent intencion= new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intencion);
        // y finalisamos para que no pueda acceder a esta pagina si  no esta logueado

        finish();

    }
    public void getCuestionarios(String id_user){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url =  configuracion.getEndpoint("API-Preguntas/ObtenerCuestionario.php");;

        StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("El servidor POST responde OK");
                    JSONObject jsonObject = new JSONObject(response);
                    cuestionarioUsuarios(jsonObject);
                    System.out.println(response);

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
                params.put("id_usuario",id_user);

                return params;
            }
        };

        queue.add(solicitud);
    }

    public void cuestionarioUsuarios(JSONObject cuestionarios){
        // convertimos a json array para obtener los datos
        // obtenemos el layout el cual le vamos a meter los otros valores
        LinearLayout layoutPadre =findViewById(R.id.container_cuestionarios);

        try {
            JSONArray objetArray = cuestionarios.getJSONArray("usuarios");

            for (int i = 0; i < objetArray.length(); i++) {
                JSONObject usuario = objetArray.getJSONObject(i);

                // Datos del usuario
                int id = usuario.getInt("id");
                int idUsuario = usuario.getInt("id_usuario");
                int cantPreguntas = usuario.getInt("cant_preguntas");
                int cantOK = usuario.getInt("cant_ok");
                int cantError = usuario.getInt("cant_error");
                String fechaInicio = usuario.getString("fecha_inicio");
                String fechaFin = usuario.optString("fecha_fin", "N/A");

                // Crear un botón y agregar TextViews con los datos
                Button button = new Button(this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

                button.setPadding(40, 40, 40, 40);
                params.setMargins(20, 20, 20, 20);
                button.setLayoutParams(params);

                // aqui es para añadir un identificador unico
                button.setId(id);

                // Aqui agregamos el texto a los botones
                String buttonText = "Número: " + id + "\nFecha Inicio: " + fechaInicio +
                        "\nNúmero Preguntas: " + cantPreguntas + "\nID Usuario: " + idUsuario +
                        "\nN° OK: " + cantOK + " - N° Error: " + cantError;
                button.setText(buttonText);

                final String id_cu = usuario.getString("id");
                final String fecha=usuario.getString("fecha_inicio");

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int userId = view.getId();
                        // ahora creamos una intención para mandarlo a la otra vista
                        Intent intencion = new Intent(getApplicationContext(), detalleCuestionario.class);
                        System.out.print("CLICK");
                        // enviamos el id del cuestionario para mostrar los datos de ese cuestionario
                        intencion.putExtra("id_cuestionario", id_cu);
                        intencion.putExtra("fecha_inicio",fecha);
                        startActivity(intencion);
                    }
                });
                // Aplicar el fondo con el borde al botón
                button.setBackgroundResource(R.drawable.border_layout_blue);

                // Añadir el botón al layoutPadre
                layoutPadre.addView(button);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }

    public void crearCuestionario(View v){
        Intent intencion=new Intent(getApplicationContext(), crearCuestionario.class);
        intencion.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // Iniciamos la nueva actividad
        startActivity(intencion);
        // finalizamos para que no pueda devolverse
        finish();
    }
}