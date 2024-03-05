package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apppreguntas.utils.Config;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    EditText campo_correo;
    EditText campo_pasword;

    Config Config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.campo_correo=findViewById(R.id.id_correo);
        this.campo_pasword=findViewById(R.id.id_password);
        this.Config =new Config(getApplicationContext());
        validarSesion();

    }
    public void validarIngreso(View vista){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = Config.getEndpoint("API-Preguntas/validarIngreso.php");
        StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("El servidor POST responde OK");
                    JSONObject jsonObject = new JSONObject(response);
                    System.out.println(response);


                    // verificamos que el estado alla sido true
                    boolean estado=jsonObject.getBoolean("status");
                    if(estado){
                        // ejecutamos el metod
                       JSONObject user=jsonObject.getJSONObject("user");

                        String id_user=user.getString("id_usuario");
                        String nombre=user.getString("nombres");
                        cambiarActivity(id_user,nombre);
                        System.out.print("Date of user: "+id_user + nombre);

                    }


                } catch (JSONException e) {
                    System.out.println("El servidor POST responde con un error:");
                    System.out.println(e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor POST responde con un error:");
                System.out.println(error.getMessage());
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<>();
                params.put("correo", campo_correo.getText().toString());
                params.put("password", campo_pasword.getText().toString());

                return params;
            }
        };

        queue.add(solicitud);

    }
    public void cambiarActivity(String usuario,String nombres){


        SharedPreferences sp=getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("id_usuario",usuario);
        editor.putString("nombres",nombres);
        editor.commit();

        Intent intencion=new Intent(getApplicationContext(),InicioUser.class);
        // Iniciamos la nueva actividad
        startActivity(intencion);
        // finalizamos para que no pueda devolverse

        finish();
    }
    public void validarSesion(){
        // aqui verificamos si hhay datos del usuario para de una vez iniciar sesion
        SharedPreferences archivo=getSharedPreferences("app_preguntas",MODE_PRIVATE);
        String id_usuario=archivo.getString("id_usuario",null);
        String nombres=archivo.getString("nombres",null);

        // vericamos que los datos existan

        if(id_usuario!=null && nombres!=null){
            Intent intencion=new Intent(getApplicationContext(),InicioUser.class);
            // Iniciamos la nueva actividad
            startActivity(intencion);
            // finalizamos para que no pueda devolverse
            finish();
        }

    }
}