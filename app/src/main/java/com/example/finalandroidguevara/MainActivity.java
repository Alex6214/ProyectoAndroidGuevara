package com.example.finalandroidguevara;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText user,pass;

    Button login,register;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
       //setSupportActionBar(toolbar);

        user = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        register = (Button)findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inicio();
            }
        });


    }


    public void inicio(){

        String username = user.getText().toString();
        String password = pass.getText().toString();

        if(username.equals("alexander.guevaram@hotmail.com")&& password.equals("12345")){
            Intent e = new Intent(MainActivity.this,Drawer.class);
            startActivity(e);


        }else {

            Toast.makeText(this, "Ingrese los datos", Toast.LENGTH_SHORT).show();

        }


    }



    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.menu_main, menu);
        //return true;
    //}



    //@Override
    //public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
          //  return true;
        //}

        //return super.onOptionsItemSelected(item);
    //}
}
