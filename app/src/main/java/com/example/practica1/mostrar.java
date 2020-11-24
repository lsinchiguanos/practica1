package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class mostrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        TextView fechaNac = (TextView) findViewById(R.id.lbFechaNac);
        TextView telefono = (TextView) findViewById(R.id.lbTelefono);
        TextView nombre = (TextView) findViewById(R.id.lbNombre);
        TextView genero = (TextView) findViewById(R.id.lbGenero);

        Bundle c = this.getIntent().getExtras();

        nombre.setText(c.getString("NOMBRE"));
        telefono.setText(c.getString("TELEFONO"));
        fechaNac.setText(c.getString("FECHA"));
        genero.setText(c.getString("GENERO"));

    }
}