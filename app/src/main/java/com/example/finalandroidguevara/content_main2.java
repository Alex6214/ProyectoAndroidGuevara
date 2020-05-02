package com.example.finalandroidguevara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class content_main2 extends AppCompatActivity {
    EditText tvpaciente,dia;
    TextView tvresultado;
    RadioButton rbfemenino,rbmasculino, rbA, rbB, rbC;
    Button cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main2);

        //FloatingActionButton fab = findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View view) {
                //Calcular();
                //Snackbar.make(view, "Calculando Precio", Snackbar.LENGTH_LONG)
                //.setAction("Action", null).show();

            //}
        //});

        tvpaciente = (EditText)findViewById(R.id.tvpaciente);
        dia = (EditText)findViewById(R.id.tvdia);
        tvresultado = (TextView)findViewById(R.id.tcresultado);
        rbfemenino = (RadioButton)findViewById(R.id.rbfemenino);
        rbmasculino = (RadioButton)findViewById(R.id.rbmasculino);
        rbA = (RadioButton)findViewById(R.id.rbA);
        rbB = (RadioButton)findViewById(R.id.rbB);
        rbC = (RadioButton)findViewById(R.id.rbC);
        cal = (Button)findViewById(R.id.cal);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               calcular();
            }
        });



    }





    private void calcular() {

                String  paciente = tvpaciente.getText().toString();

                int dias = Integer.parseInt(dia.getText().toString());
                int costoA = 200;
                int costoB = 280;
                int costoC = 320;
                double precio = 0;
                double porcefemenino = (costoA * 0.07);
                double porcemasculino = (costoC * 0.05);

                if (rbfemenino.isChecked()){
                    if (rbA.isChecked()){
                        precio = (costoA*dias) + porcefemenino;
                    }else if (rbB.isChecked()){
                        precio = costoB*dias;
                    }else if (rbC.isChecked()){
                        precio = costoC*dias;
                    }

                }else if (rbmasculino.isChecked()){
                    if (rbA.isChecked()){
                        precio = costoA*dias ;
                    }else if (rbB.isChecked()){
                        precio = costoB*dias;
                    }else if (rbC.isChecked()){
                        precio = (costoC*dias) + porcemasculino;
                    }
                }
                tvresultado.setText("PACIENTE: " + paciente + "\n" +"DIAS : "+dias+"\n"+ "COSTO A PAGAR:  S/ " + precio);
    }


}
