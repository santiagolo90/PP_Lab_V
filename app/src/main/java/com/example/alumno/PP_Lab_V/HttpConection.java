package com.example.alumno.PP_Lab_V;

import android.net.Uri;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by alumno on 11/05/2017.
 */

public class HttpConection {
    private String metodo;
    private JSONObject datos;
    private String Header;


    public HttpConection(String metodo) {
        this.metodo = metodo;
    }


    public JSONObject getDatos() {
        return datos;
    }

    public void setDatos(JSONObject datos) {
        this.datos = datos;
    }




    public static byte[] conectarseImagen(String miUrl){

        return getBytesData(miUrl);
    }

    public static String conectarseString(String miUrl){
        String respuesta = new String(getBytesData(miUrl));
        return respuesta;

    }



    public static byte[] getBytesData(String strUrl) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            int response = urlConnection.getResponseCode();
            Log.d("http", "Response code:" + response);
            if (response == 200){
                //enlace de comunicacion lo uso para leer
                InputStream is = urlConnection.getInputStream();
                // esta en el servidor porque no tiene new
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length = 0;
                while ((length = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, length);
                }
                is.close();
                return baos.toByteArray();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;


    }


    public String getStringData(String strUrl) throws IOException {
        URL url = new URL(strUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod(this.metodo);
        if (this.metodo == "POST"){
            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("Content-Type","application/json");
            urlConnection.setRequestProperty("Host", "android.schoolportal.gr");

            OutputStream os = urlConnection.getOutputStream();
            byte[] outputInBytes = this.datos.toString().getBytes("UTF-8");
            os.write( outputInBytes );
            Log.d("HC",this.datos.toString());
            os.close();
        } else {
            urlConnection.connect();
        }
        int response = urlConnection.getResponseCode();
        Log.d("http", "Response code:" + response);
        if(response==200) {
            InputStream is = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = is.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            is.close();
            return new String( baos.toByteArray(),"UTF-8");

        }
        else
            throw new IOException();
    }



/*
    @Override
    protected String doInBackground(String... miUrl) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(miUrl[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();


            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            //StringBuffer buffer = new StringBuffer();
            StringBuilder sb = new StringBuilder();
            String line = "";

            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }

            String buffer = sb.toString();
            return buffer;

        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    */
/*
    @Deprecated
    protected void convertToJson(String datos) {
        carrusels = new ArrayList<Carrusel>();
        try {

            JSONArray jsonarray = new JSONArray(datos);
            //ArrayList<HashMap<String, String>> personas = new ArrayList<>();

            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject c = jsonarray.getJSONObject(i);
                Number idCarrusel = c.getInt("idCarrusel");
                String titulo = c.getString("titulo");
                String subtitulo = c.getString("subtitulo");
                String orden = c.getString("orden");
                String tipo_carrusel = c.getString("tipo_carrusel");
                String foto = c.getString("foto");

                carrusels.add(new Carrusel(idCarrusel,titulo,subtitulo,orden,tipo_carrusel,foto));

                // tmp hash map for json
                //HashMap<String, String> myCarusel = new HashMap<>();

                // adding each child node to HashMap key => value
                //myCarusel.put("idCarrusel", idCarrusel);
                //myCarusel.put("titulo", titulo);
                //myCarusel.put("subtitulo", subtitulo);
                //myCarusel.put("tipo_carrusel", tipo_carrusel);
                //myCarusel.put("foto", foto);
                //personas.add(myCarusel);
                //return myCarusel;

            }

            //for (int i = 0; i < carrusels.size(); i++) {
            //    Log.d("lista",String.valueOf(carrusels.get(i)));
            //}

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
 */
}

