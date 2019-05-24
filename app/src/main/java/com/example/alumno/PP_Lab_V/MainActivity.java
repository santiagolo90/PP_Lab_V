package com.example.alumno.PP_Lab_V;

import android.content.Intent;
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
    private final static String XML = "XML";
    public String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO Listener para los botones
        Intent i = getIntent();
        this.usuario = i.getStringExtra("usuario");

        productos = new ArrayList<Producto>();

        RecyclerView rvProductos = (RecyclerView) super.findViewById(R.id.rvProductos);

        myAdapter =  new MyAdapter(productos,this);

        LinearLayoutManager lm = new LinearLayoutManager(this);

        rvProductos.setAdapter(myAdapter);
        rvProductos.setLayoutManager(lm);


        this.handler = new Handler(this);
        MyHilo hiloUno = new MyHilo(handler,"https://onemoretry.eu/temp/Productos.xml",this.XML);
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

    public void controlStock(Producto p, String tipoBtn) {
        int index = this.productos.indexOf(p);
        //int index2 = p.getId() -1;
        if (usuario.equals("Admin")){
            if ("agregar".equals(tipoBtn)){
                Log.d(tipoBtn, p.toString());
                Number suma =  (int)p.getCantidad() + 1;
                p.setCantidad(suma);
            } else if ("eliminar".equals(tipoBtn)) {
                Log.d(tipoBtn, p.toString());
                Number resta =  (int)p.getCantidad() - 1;
                p.setCantidad(resta);
            }
        }

        this.myAdapter.notifyItemChanged(index);
    }
}
