package com.example.finalandroidguevara;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class SplashScreen extends Activity {
    private ProgressBar pb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        init();

        pb1.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                

                pb1.setVisibility(View.GONE);
                Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);

            }
        },2000);

    }

    private void init() {
        this.pb1 = findViewById(R.id.pb1);
    }
}
