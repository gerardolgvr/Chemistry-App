package com.example.chemistrify;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.chemistrify.models.Element;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    private ArrayList<Element> elements = new ArrayList<>();
    Button[] btn_element = new Button[118];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting data
        initList(getApplicationContext());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.app_bar_search:
                //open search activity
                openSearchActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //function that opens SearchActivity
    private void openSearchActivity(){
        Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(intent);
    }

    //method that makes a request
    private void initList(final Context context){
        //api URL, GET Request
        mQueue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://api.myjson.com/bins/16qrno/";

        //handling request
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    //parsing all elements and adding to our ArrayList
                    for(int i = 0; i < response.length(); i++){
                        //get JSONObject
                        JSONObject obj = response.getJSONObject(i);
                        //getting data
                        String atomicMass = obj.getString("atomicMass");
                        int atomicNumber = obj.getInt("atomicNumber");
                        String atomicRadius = obj.get("atomicRadius").toString();
                        String boilingPoint = obj.get("boilingPoint").toString();
                        String bondingType = obj.getString("bondingType");
                        String cpkHexColor = obj.getString("cpkHexColor");
                        String density = obj.getString("density");
                        String electronAffinity = obj.get("electronAffinity").toString();
                        String electronegativity = obj.getString("electronegativity");
                        String electronicConfiguration = obj.getString("electronicConfiguration");
                        String groupBlock = obj.getString("groupBlock");
                        String ionRadius = obj.getString("ionRadius");
                        String ionizationEnergy = obj.getString("ionizationEnergy");
                        String meltingPoint = obj.getString("meltingPoint");
                        String name = obj.getString("name");
                        String oxidationStates = obj.getString("oxidationStates");
                        String standardState = obj.getString("standardState");
                        String symbol = obj.getString("symbol");
                        String vanDelWaalsRadius = obj.getString("vanDelWaalsRadius");
                        String yearDiscovered = obj.getString("yearDiscovered");

                        //creating Element and pushing to our ArrayList
                        Element element = new Element(atomicMass, atomicNumber, atomicRadius, boilingPoint, bondingType, cpkHexColor, density, electronAffinity, electronegativity, electronicConfiguration, groupBlock, ionRadius, ionizationEnergy, meltingPoint, name, oxidationStates, standardState, symbol, vanDelWaalsRadius, yearDiscovered);
                        elements.add(element);
                    }

                    for(int i = 0; i < btn_element.length; i ++){
                        int id = context.getResources().getIdentifier("btn_element_"+(i+1), "id", context.getPackageName());
                        btn_element[i] = findViewById(id);
                        btn_element[i].setText(elements.get(i).getSymbol()+"\n"+elements.get(i).getAtomicNumber());
                        final int finalI = i;
                        btn_element[i].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                showElement(elements.get(finalI));
                            }
                        });
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        //adding our resquest to the queue
        mQueue.add(request);
    }

    //intent to open ElementActivity
    private void showElement(Element element){
        Intent intent = new Intent(MainActivity.this, ElementActivity.class);
        intent.putExtra("groupBlock", element.getGroupBlock());
        intent.putExtra("atomicNumber", element.getAtomicNumber());
        intent.putExtra("symbol", element.getSymbol());
        intent.putExtra("atomicMass", element.getAtomicMass());
        intent.putExtra("name", element.getName());
        intent.putExtra("electronicConfiguration", element.getElectronicConfiguration());
        intent.putExtra("standardState", element.getStandardState());
        intent.putExtra("ionizationEnergy", element.getIonizationEnergy());
        intent.putExtra("density", element.getDensity());
        intent.putExtra("yearDiscovered", element.getYearDiscovered());
        startActivity(intent);
    }
}
