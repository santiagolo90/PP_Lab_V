package com.example.alumno.PP_Lab_V;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MyViewHoleder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView tvNombre;
    private TextView tvCantidad;
    private TextView tvPrecio;
    private Producto productoBuscado;
    private Button btnAgregar;
    private Button btnEliminar;
    private MyListener myListener;

    private MainActivity miapp;

    public MyViewHoleder(View itemView,MainActivity miapp) {
        super(itemView);
        this.myListener = new MyListener(this);
        this.miapp = miapp;

        this.tvNombre = (TextView)itemView.findViewById(R.id.tvNombreProducto);
        this.tvCantidad = (TextView)itemView.findViewById(R.id.tvCantidad);
        this.tvPrecio = (TextView)itemView.findViewById(R.id.tvPrecio);

        this.btnAgregar = (Button) itemView.findViewById(R.id.btnAgregar);
        this.btnAgregar.setOnClickListener(this.myListener);

        this.btnEliminar = (Button) itemView.findViewById(R.id.btnEliminar);
        this.btnEliminar.setOnClickListener(this.myListener);

        //itemView.setOnClickListener(this);
    }

    public TextView getTvNombre() {
        return tvNombre;
    }

    public void setTvNombre(String tvNombre) {
        this.tvNombre.setText(tvNombre);
    }

    public TextView getTvCantidad() {
        return tvCantidad;
    }

    public void setTvCantidad(String cantidad) {
        this.tvCantidad.setText("Cantidad: " + cantidad);
    }

    public TextView getTvPrecio() {
        return tvPrecio;
    }

    public void setTvPrecio(String tvPrecio) {
        this.tvPrecio.setText("Precio unidad: " + tvPrecio);
    }

    public Producto getProductoBuscado() {
        return productoBuscado;
    }

    public void setProductoBuscado(Producto productoBuscado) {
        this.productoBuscado = productoBuscado;
    }

    public MainActivity getMiapp() {
        return miapp;
    }

    @Override
    public void onClick(View v) {
        Log.d("Click",this.productoBuscado.toString());
    }
}
