package com.example.chemistrify;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;


public class ElementActivity extends AppCompatActivity {
    TextView card_groupBlock, card_atomicNumber, card_symbol, card_atomicMass, card_name, card_electronicConfiguration, txt_standardState, txt_ionizationEnergy, txt_density, txt_yearDiscovered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);

        //ui
        card_groupBlock = (TextView) findViewById(R.id.card_groupBlock);
        card_atomicNumber = (TextView) findViewById(R.id.card_atomicNumber);
        card_symbol = (TextView) findViewById(R.id.card_symbol);
        card_atomicMass = (TextView) findViewById(R.id.card_atomicMass);
        card_name = (TextView) findViewById(R.id.card_name);
        card_electronicConfiguration = (TextView) findViewById(R.id.card_electronicConfiguration);
        txt_standardState = (TextView) findViewById(R.id.txt_standardState);
        txt_ionizationEnergy = (TextView) findViewById(R.id.txt_ionizationEnergy);
        txt_density = (TextView) findViewById(R.id.txt_density);
        txt_yearDiscovered = (TextView) findViewById(R.id.txt_yearDiscovered);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            //gettin data from bundle
            String groupBlock = bundle.get("groupBlock").toString();
            String atomicNumber = bundle.get("atomicNumber").toString();
            String symbol = bundle.get("symbol").toString();
            String atomicMass = bundle.get("atomicMass").toString();
            String name = bundle.get("name").toString();
            String electronicConfiguration = bundle.get("electronicConfiguration").toString();
            String standardState = bundle.get("standardState").toString();
            String ionizationEnergy = bundle.get("ionizationEnergy").toString();
            String density = bundle.get("density").toString();
            String yearDiscovered = bundle.get("yearDiscovered").toString();

            ActionBar actionBar = getSupportActionBar();
            if(actionBar != null){
                actionBar.setTitle(name);
                actionBar.setDisplayHomeAsUpEnabled(true);
            } else {
                actionBar.setTitle("Chemistrify");
            }

            //settting element data in layout
            card_groupBlock.setText(groupBlock);
            card_atomicNumber.setText(atomicNumber);
            card_symbol.setText(symbol);
            card_atomicMass.setText(atomicMass);
            card_name.setText(name);
            card_electronicConfiguration.setText(electronicConfiguration);
            txt_standardState.setText(standardState);
            txt_ionizationEnergy.setText(ionizationEnergy);
            txt_density.setText(density);
            txt_yearDiscovered.setText(yearDiscovered);
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
