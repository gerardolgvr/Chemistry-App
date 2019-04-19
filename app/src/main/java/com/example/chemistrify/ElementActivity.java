package com.example.chemistrify;


import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ElementActivity extends AppCompatActivity {
    TextView card_name;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("hola gera");
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setIcon(R.drawable.app_icon);
        } else {
            Toast.makeText(getApplicationContext(), "es null", Toast.LENGTH_SHORT).show();
        }

        //ui
        card_name = (TextView) findViewById(R.id.card_name);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            name = bundle.get("element").toString();
            //gettting element data
            card_name.setText(name);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
