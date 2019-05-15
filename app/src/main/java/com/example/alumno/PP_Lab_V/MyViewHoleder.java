package com.example.alumno.PP_Lab_V;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MyViewHoleder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView tvNombre;
    private TextView tvCantidad;
    private TextView tvPrecio;
    private Producto productoBuscado;

    public MyViewHoleder(View itemView) {
        super(itemView);

        this.tvNombre = (TextView)itemView.findViewById(R.id.tvNombreProducto);
        this.tvCantidad = (TextView)itemView.findViewById(R.id.tvCantidad);
        this.tvPrecio = (TextView)itemView.findViewById(R.id.tvPrecio);

        itemView.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {

    }
}
