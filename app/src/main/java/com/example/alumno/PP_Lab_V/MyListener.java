package com.example.alumno.PP_Lab_V;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MyListener implements View.OnClickListener {

    private MyViewHoleder holeder;


    public MyListener(MyViewHoleder holeder) {
        this.holeder = holeder;
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnAgregar) {
            //Log.d("Click","Agrego");
            //Log.d("Click",this.holeder.getProductoBuscado().toString());
            this.holeder.getMiapp().controlStock(this.holeder.getProductoBuscado(),"agregar");
            //this.myViewHolder.getMainActivity().controlStock(this.myViewHolder.getCurrent(), MainActivity.PLUS);
        } else if (v.getId() == R.id.btnEliminar){
            //Log.d("Click","Elimino");
            this.holeder.getMiapp().controlStock(this.holeder.getProductoBuscado(),"eliminar");
        }

    }
}
