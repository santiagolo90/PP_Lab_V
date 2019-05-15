/*
package com.example.alumno.PP_Lab_V;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;


public class XmlParser {

    public static List<Producto> obtenerPersonas(String xml){
        
        XmlPullParser xmlPullParser = Xml.newPullParser();
        try {
            xmlPullParser.setInput(new StringReader(xml));
            int event = xmlPullParser.getEventType();
			
            while (event != XmlPullParser.END_DOCUMENT){

                
                event = xmlPullParser.next();
            }



        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
*/