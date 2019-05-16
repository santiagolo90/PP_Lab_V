package com.example.alumno.PP_Lab_V;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class MyHilo extends Thread {

    public Handler handler;
    public String url;

    public MyHilo(Handler handler, String url) {
        this.handler = handler;
        this.url = url;
    }

    @Override
    public void run(){
        Message mensaje = new Message();

        String respuesta = HttpConection.conectarseString(this.url);
        Log.d("respuesta", respuesta);
        mensaje.obj = XmlParser.obtenerPersonas(respuesta);
        this.handler.sendMessage(mensaje);



        /*
        if (this.tipo == MainActivity.TEXTO){
            //String respues = myConeccion.conectarseString(url);
            //mensaje.obj = respues;
            String respues = myConeccion.conectarseString(url);
            mensaje.obj = ParseXml.getPersonas(respues);
        }else if(this.tipo == MainActivity.IMAGEN){
            byte[] respues = myConeccion.conectarseImagen(url);
            mensaje.obj = respues;

            mensaje.arg2 = currentIndex;
        }else if(this.tipo == MainActivity.MyJson){
            String respues = myConeccion.doInBackground(url);
            mensaje.obj = respues;


        }
        */

    }

}
