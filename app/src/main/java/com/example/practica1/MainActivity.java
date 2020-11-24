package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.time.Year;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText txtDate;

    private int nYearIni, nMonthIni, nDayIni, sYearIni, sMonthIni, sDayIni;
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sMonthIni = C.get(Calendar.MONTH);
        sDayIni = C.get(Calendar.DAY_OF_MONTH);
        sYearIni = C.get(Calendar.YEAR);

        txtDate = (EditText) findViewById(R.id.txtDate);

        txtDate.setOnClickListener((View) -> {
            showDialog(DATE_ID);
        });

    }

    private void colocar_fecha(){
        txtDate.setText(nDayIni + "/" + (nMonthIni + 1) + "/" + nYearIni + "");
    }

    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            nYearIni = year;
            nMonthIni = month;
            nDayIni = dayOfMonth;
            colocar_fecha();
        }
    };

    protected Dialog onCreateDialog(int id){
        switch (id){
            case DATE_ID:
                return new DatePickerDialog(this, onDateSetListener, sYearIni, sMonthIni, sDayIni);
        }
        return null;
    }

    public void btnEnviar(View view){
        Intent intent = new Intent(MainActivity.this, mostrar.class);

        EditText txtNombre = (EditText) findViewById(R.id.txtNombre);
        EditText txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        EditText txtFecha = (EditText) findViewById(R.id.txtDate);
        String rb = getRadioButton();

        Bundle b = new Bundle();
        b.putString("NOMBRE", txtNombre.getText().toString());
        b.putString("TELEFONO", txtTelefono.getText().toString());
        b.putString("FECHA", txtFecha.getText().toString());
        b.putString("GENERO", rb);

        intent.putExtras(b);
        startActivity(intent);
    }

    private String getRadioButton(){
        RadioGroup rbg = (RadioGroup) findViewById(R.id.rbg1);
        int radioButtonId = rbg.getCheckedRadioButtonId();
        View radioButton = rbg.findViewById(radioButtonId);
        int indice = rbg.indexOfChild(radioButton);
        RadioButton rb = (RadioButton)  rbg.getChildAt(indice);
        String texto = rb.getText().toString();
        return texto;
    }

}