package com.example.chemistrify;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ElementActivity extends AppCompatActivity {
    TextView card_name;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);

        //ui
        card_name = (TextView) findViewById(R.id.card_name);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            name = bundle.get("element").toString();

            card_name.setText(name);
        }

    }
}
