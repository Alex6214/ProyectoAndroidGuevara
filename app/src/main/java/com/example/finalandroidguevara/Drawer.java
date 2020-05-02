package com.example.finalandroidguevara;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Drawer extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    EditText tvpaciente,dia;
    TextView tvresultado;
    RadioButton rbfemenino,rbmasculino, rbA, rbB, rbC;
    Button cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_drawer);

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




        //--------------------------------------------------

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
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
