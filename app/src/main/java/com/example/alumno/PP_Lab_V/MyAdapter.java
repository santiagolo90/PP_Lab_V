
package com.example.alumno.PP_Lab_V;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;




public class MyAdapter extends RecyclerView.Adapter<MyViewHoleder> {
    List<Producto> productos;
    MainActivity miapp;


    public MyAdapter(List<Producto> productos,MainActivity mipp ) {
        this.productos = productos;
        this.miapp = mipp;
    }

    @Override
    public MyViewHoleder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v =null;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.producto_rv,parent,false);

        MyViewHoleder myViewHoleder = new MyViewHoleder(v);

        return myViewHoleder;
    }

    @Override
    public void onBindViewHolder(MyViewHoleder holder, int position) {

        Producto p = this.productos.get(position);
        holder.setTvNombre(p.getNombre());
        holder.setTvCantidad(p.getCantidad().toString());
        holder.setTvPrecio(p.getPrecio().toString());
        holder.setProductoBuscado(p);

    }

    @Override
    public int getItemCount() {

        return this.productos.size();
    }

    public void setProducts(List<Producto> p){
        this.productos= p;
    }


}
