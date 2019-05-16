
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
                        switch(xmlPullParser.getName()) {
                            case "id":
                                p.setId(Integer.valueOf(xmlPullParser.nextText()));
                                break;
                            case "nombre":
                                p.setNombre(xmlPullParser.nextText());
                                break;
                            case "precio":
                                p.setPrecio(Integer.valueOf(xmlPullParser.nextText()));
                                break;
                            case "cantidad":
                                p.setCantidad(Integer.valueOf(xmlPullParser.nextText()));
                                break;
                            default:
                                // code block
                        }
                    }

                }
                if (event == XmlPullParser.END_TAG){
                    if ("producto".equals(xmlPullParser.getName()) || p != null) {
                        productos.add(p);
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
