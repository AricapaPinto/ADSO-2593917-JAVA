package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apppreguntas.utils.Config;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class crearCuestionario extends AppCompatActivity {
    TextView nombre,fecha;
    Config Configuracion;
   String id_usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuestionario);
        this.nombre=findViewById(R.id.usuario);
        this.fecha=findViewById(R.id.fecha);
        this.Configuracion=new Config(getApplicationContext());

        SharedPreferences archivo=getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);
        this.nombre.setText(archivo.getString("nombres",""));
        id_usuario=archivo.getString("id_usuario","");
        Calendar calendar = Calendar.getInstance();
         // Formatear la fecha y hora en el formato deseado (por ejemplo, "yyyy-MM-dd HH:mm:ss")
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String fechaHoraFormateada = sdf.format(calendar.getTime());

        // Imprimir o utilizar la fecha y hora formateada
        this.fecha.setText(fechaHoraFormateada);
    }

    public void inicioCuestionario(View v){
        // insertamos el cuestionario
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url =Configuracion.getEndpoint("API-Preguntas/InsertCuestionario.php");

        StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("El servidor POST responde OK");
                    JSONObject jsonObject = new JSONObject(response);
                    System.out.println(jsonObject);
                    // verifamoc el estado y obtenemos el id del cuestionario

                    boolean estado=jsonObject.getBoolean("status");
                    if(estado){
                        // lo mandamos a la siguiente vista con los datos
                        String id_cuestionario=jsonObject.getString("id_cuestionario");
                        Intent intencion= new Intent(getApplicationContext(),cuestionarioPreguntas.class);
                        intencion.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intencion.putExtra("fecha",fecha.getText().toString());
                        intencion.putExtra("nombres",nombre.getText().toString());
                        intencion.putExtra("id_cuestionario",id_cuestionario);
                        startActivity(intencion);

                    }

                } catch (JSONException e) {
                    System.out.println("El servidor POST responde con un error: 1");

                    System.out.println(e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor POST responde con un error: 2");
                System.out.println(error.getMessage());
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<>();
                params.put("id_usuario",id_usuario);
                params.put("fecha_inicio",fecha.getText().toString());
                return params;
            }
        };
        queue.add(solicitud);

    }



    public void cancelarCuestionario(View v){
        Intent intencion= new Intent(getApplicationContext(),InicioUser.class);
        startActivity(intencion);
        finish();
    }
}