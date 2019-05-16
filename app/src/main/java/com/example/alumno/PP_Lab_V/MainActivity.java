package com.example.alumno.PP_Lab_V;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    List<Producto> productos;
    MyAdapter myAdapter;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO Listener para los botones



        productos = new ArrayList<Producto>();
        productos.add(new Producto(1,"producto 1",10,11.15));
        productos.add(new Producto(2,"producto 2",20,21.25));
        productos.add(new Producto(3,"producto 3",30,31.35));
        productos.add(new Producto(4,"producto 4",40,41.45));
        productos.add(new Producto(5,"producto 5",50,51.55));
        productos.add(new Producto(6,"producto 6",60,61.65));
        productos.add(new Producto(7,"producto 7",70,71.75));
        productos.add(new Producto(8,"producto 8",80,81.85));

        RecyclerView rvProductos = (RecyclerView) super.findViewById(R.id.rvProductos);

        myAdapter =  new MyAdapter(productos,this);

        LinearLayoutManager lm = new LinearLayoutManager(this);

        rvProductos.setAdapter(myAdapter);
        rvProductos.setLayoutManager(lm);

        this.handler = new Handler(this);
        MyHilo hiloUno = new MyHilo(handler,"https://onemoretry.eu/temp/Productos.xml");
        hiloUno.start();


    }

    @Override
    public boolean handleMessage(Message msg) {
/*
        for (Producto p: (List<Producto>)msg.obj){
            Log.d("desde el hilo texto",p.toString());
        }
*/
        this.productos.addAll((List<Producto>)msg.obj);
        this.myAdapter.notifyDataSetChanged();
        return false;
    }
}
