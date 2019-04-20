package com.example.chemistrify;


import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class ElementActivity extends AppCompatActivity {
    TextView card_groupBlock, card_atomicNumber, card_symbol, card_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("hola gera");
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setIcon(R.drawable.app_icon);
        }

        //ui
        card_groupBlock = (TextView) findViewById(R.id.card_groupBlock);
        card_atomicNumber = (TextView) findViewById(R.id.card_atomicNumber);
        card_symbol = (TextView) findViewById(R.id.card_symbol);
        card_name = (TextView) findViewById(R.id.card_name);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String groupBlock = bundle.get("groupBlock").toString();
            String atomicNumber = bundle.get("atomicNumber").toString();
            String symbol = bundle.get("symbol").toString();
            String name = bundle.get("name").toString();
            //gettting element data
            card_groupBlock.setText(groupBlock);
            card_atomicNumber.setText(atomicNumber);
            card_symbol.setText(symbol);
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
