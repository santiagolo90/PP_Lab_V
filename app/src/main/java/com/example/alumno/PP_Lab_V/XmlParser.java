
package com.example.alumno.PP_Lab_V;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


public class XmlParser {

    public static List<Producto> obtenerPersonas(String xml){
        List<Producto> productos = new ArrayList<>();
        
        XmlPullParser xmlPullParser = Xml.newPullParser();
        try {
            xmlPullParser.setInput(new StringReader(xml));

            int event = xmlPullParser.getEventType();
            Producto p = null;
            while (event != XmlPullParser.END_DOCUMENT){

                if (event == XmlPullParser.START_TAG){
                    if ("producto".equals(xmlPullParser.getName())){
                        p = new Producto();
                    }
                    if ("id".equals(xmlPullParser.getName()) && p != null){
                        p.setId(Integer.valueOf(xmlPullParser.nextText()));
                    }
                    if ("nombre".equals(xmlPullParser.getName())&& p != null){
                        p.setNombre(xmlPullParser.nextText());
                    }
                    if ("precio".equals(xmlPullParser.getName())&& p != null){
                        p.setPrecio(Double.valueOf(xmlPullParser.nextText()));
                    }
                    if ("cantidad".equals(xmlPullParser.getName())&& p != null){
                        p.setCantidad(Integer.valueOf(xmlPullParser.nextText()));
                    }
                }
                if (event == XmlPullParser.END_TAG){
                    if ("producto".equals(xmlPullParser.getName()) && p != null) {
                        productos.add(p);
                        p = null;
                    }
                }
                event = xmlPullParser.next();
            }

            return productos;

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
