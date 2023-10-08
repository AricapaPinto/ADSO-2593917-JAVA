package principal;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class ConsumoAPI {

    public ConsumoAPI() {
    }

    public String consumoGET(String endpoint) {
        try {
            // Paso 1: Crear una URL usando la dirección de la API
            URL url = new URL(endpoint);

            // Paso 2: Abrir una conexión HTTP hacia la URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Paso 3: Configurar la solicitud como un método GET
            connection.setRequestMethod("GET");

            // Paso 4: Obtener el código de respuesta de la API
            int responseCode = connection.getResponseCode();

            // Paso 5: Verificar si la solicitud fue exitosa (código 200)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Paso 6: Leer la respuesta de la API línea por línea
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                connection.disconnect();

                // Paso 7: Devolver la respuesta de la API como una cadena
                return response.toString();
            } else {
                // Paso 8: Manejar errores si la solicitud no fue exitosa
                System.out.println("Error al consumir la API. Código de respuesta: " + responseCode);
                connection.disconnect();
                return null;
            }
        } catch (Exception e) {
            // Paso 9: Manejar excepciones si ocurren errores durante la ejecución
            System.out.println(" -- Catch -- ");
            e.printStackTrace();
            return null;
        }
        /*En resumen, este método realiza una solicitud GET a una API, maneja la respuesta y la devuelve
        como una cadena en caso de éxito o maneja errores si 
        la solicitud falla o si ocurren excepciones durante el proceso.*/
    }

    public String consumoGET(String endpoint, Map<String, String> getData) {
        try {
            // Paso 1: Construir la URL con los datos GET si se proporcionaron
            StringBuilder urlBuilder = new StringBuilder(endpoint);
            if (!getData.isEmpty()) {
                urlBuilder.append('?'); // Inicia la cadena de consulta
                for (Map.Entry<String, String> entry : getData.entrySet()) {
                    // Agrega cada par clave=valor al URL y codifica los valores
                    urlBuilder.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    urlBuilder.append('=');
                    urlBuilder.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    urlBuilder.append('&'); // Agrega un '&' entre cada par clave=valor
                }
                urlBuilder.deleteCharAt(urlBuilder.length() - 1); // Elimina el último '&'
            }

            // Paso 2: Crear una URL usando la cadena URL construida
            URL url = new URL(urlBuilder.toString());

            // Paso 3: Abrir una conexión HTTP hacia la URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Paso 4: Obtener el código de respuesta de la API
            int responseCode = connection.getResponseCode();

            // Paso 5: Verificar si la solicitud fue exitosa (código 200)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Paso 6: Leer la respuesta de la API línea por línea
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                connection.disconnect();

                // Paso 7: Devolver la respuesta de la API como una cadena
                return response.toString();
            } else {
                // Paso 8: Manejar errores si la solicitud no fue exitosa
                System.out.println("Error al consumir la API. Código de respuesta: " + responseCode);
                connection.disconnect();
                return null;
            }
        } catch (Exception e) {
            // Paso 9: Manejar excepciones si ocurren errores durante la ejecución
            System.out.println(" -- Catch -- ");
            e.printStackTrace();
            return null;
        }
    }

    public String consumoPOST(String endpoint) {
        try {
            // URL de la API
            URL url = new URL(endpoint);

            // Abrir una conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar la conexión para el método POST sin Datos
            connection.setRequestMethod("POST");
            connection.setDoOutput(false);

            // Obtener el código de respuesta enviado por el Servidor
            int responseCode = connection.getResponseCode();

            // En caso de respuesta exitosa convertir la respuesta en String
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Leer la respuesta de la API
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                connection.disconnect();
                return response.toString();
            } else {
                System.out.println("Error al consumir la API. Código de respuesta: " + responseCode);
                connection.disconnect();
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public String consumoPOST(String endpoint, Map<String, String> postData) {
        try {
            // URL de la API
            URL url = new URL(endpoint);

            // Abrir una conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar la conexión para el método POST
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Construir la cadena de datos a enviar
            StringBuilder data = new StringBuilder();
            for (Map.Entry<String, String> entry : postData.entrySet()) {
                if (data.length() != 0) {
                    data.append('&');
                }
                data.append(entry.getKey());
                data.append('=');
                data.append(entry.getValue());
            }

            // Enviar los datos en el cuerpo de la solicitud
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.writeBytes(data.toString());
                wr.flush();
            }

            // Obtener el código de respuesta
            int responseCode = connection.getResponseCode();

            // En caso de respuesta exitosa convertir la respuesta en String
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Leer la respuesta de la API
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                connection.disconnect();
                return response.toString();
            } else {
                System.out.println("Error al consumir la API. Código de respuesta: " + responseCode);
                connection.disconnect();
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
    public Persona[] listaPersonas() {
        
        // este es el controlador de esta clase 
        Gson gson = new Gson();

        //ahora manipulamos la respuesta que nos de el consumo get 
        String respuestaAll = consumoGET("http://localhost/APIenPHP/Obtener.php");

        JsonObject objetoPersona = JsonParser.parseString(respuestaAll).getAsJsonObject();

        JsonArray aregloPersona = objetoPersona.get("registros").getAsJsonArray();
        Persona[] listaTemporal = new Persona[aregloPersona.size()];

        for (int i = 0; i < aregloPersona.size(); i++) {

            Persona temp = gson.fromJson(aregloPersona.get(i).getAsJsonObject(), Persona.class);
            listaTemporal[i] = temp;
        }
        
        return listaTemporal;
    }
    
    
}
