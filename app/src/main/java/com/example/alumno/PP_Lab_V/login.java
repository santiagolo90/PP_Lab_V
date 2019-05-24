package com.example.alumno.PP_Lab_V;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class login extends AppCompatActivity implements Handler.Callback ,View.OnClickListener {
    Button btnIngresar;
    ListenerLogin myListener;
    public Handler handler;
    public MyHilo hiloUno;
    private EditText etMail;
    private EditText etClave;


    private final static String JSON = "JSON";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.myListener = new ListenerLogin(this);

        this.btnIngresar = (Button) this.findViewById(R.id.btnIngresar);
        this.btnIngresar.setOnClickListener(this);


    }



    @Override
    public boolean handleMessage(Message msg) {
        Log.d("msg", msg.obj.toString());

        if (msg.obj.equals("Admin")){
            Intent i = new Intent(this,MainActivity.class);
            i.putExtra("usuario",msg.obj.toString());
            this.startActivity(i);
        }
        if (msg.obj.equals("User")){
            Intent i = new Intent(this,MainActivity.class);
            i.putExtra("usuario",msg.obj.toString());
            this.startActivity(i);
        }


        return false;
    }

    @Override
    public void onClick(View v) {
        this.etMail = (EditText)this.findViewById(R.id.txtMail);
        this.etClave = (EditText)this.findViewById(R.id.txtClave);
        String email = String.valueOf(this.etMail.getText());
        String clave = String.valueOf(this.etClave.getText());

        this.handler = new Handler(this);
        //MyHilo hiloUno = new MyHilo(handler,"http://192.168.2.194:3000/login/admin/1234",this.JSON);
        MyHilo hiloUno = new MyHilo(handler,"http://192.168.2.194:3000/login/".concat(clave).concat("/").concat(email),this.JSON);

        hiloUno.start();
    }
}
