package com.example.alumno.PP_Lab_V;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MyHilo extends Thread {

    public Handler handler;
    public String url;
    public String tipo;

    public MyHilo(Handler handler, String url,String tipo) {
        this.handler = handler;
        this.url = url;
        this.tipo = tipo;
    }

    @Override
    public void run(){
        Message mensaje = new Message();
        String respuesta = HttpConection.conectarseString(this.url);
        Log.d("URL2", this.url);
        Log.d("URL2", "Response code:" + respuesta);
        if (this.tipo == "XML"){
            mensaje.obj = XmlParser.obtenerPersonas(respuesta);
        }else if(this.tipo == "JSON"){
            mensaje.obj = this.convertToJson(respuesta);
            Log.d("JSON", mensaje.obj.toString());
        }

        this.handler.sendMessage(mensaje);


    }

    protected String convertToJson(String datos) {

        try {
            JSONObject json = new JSONObject(datos);
            String type = json.getString("type");
            return type;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
