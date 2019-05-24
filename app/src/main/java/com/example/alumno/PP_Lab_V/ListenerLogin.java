package com.example.alumno.PP_Lab_V;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
/**
 * Created by alumno on 23/05/19.
 */

public class ListenerLogin implements View.OnClickListener {
    Activity miapp;

    public ListenerLogin(Activity miapp) {
        this.miapp = miapp;
    }

    @Override
    public void onClick(View v) {
        //this.miapp.personas.add(new Persona("Nueva","Persona","555-555"));
        if (v.getId() == R.id.btnIngresar){
            Intent i = new Intent(miapp,MainActivity.class);
            miapp.startActivity(i);
        }else{
            miapp.finish();
        }
        //this.miapp.myAdapter.notifyDataSetChanged();

    }
}
