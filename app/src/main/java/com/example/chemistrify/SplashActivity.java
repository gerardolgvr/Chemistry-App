package com.example.chemistrify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        try{
            Thread.sleep(5000);
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } catch(InterruptedException e ) {
            System.out.println("jpa");
        }


    }
}
