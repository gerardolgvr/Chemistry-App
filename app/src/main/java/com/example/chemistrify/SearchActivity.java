package com.example.chemistrify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
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
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    private ArrayList<Element> elements = new ArrayList<>();

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //getting data
        initList();

        //create our new array adapter
        ArrayAdapter<Element> adapter = new elementArrayAdapter(getApplicationContext(), 0, elements);

        //Find list view and bind it with the custom adapter
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        //on click event(user tap the element)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // send element data to ElementActivity
                showElement(elements.get(position));
            }
        });

    }

    //method that makes a request
    private void initList(){
        //api URL, GET Request
        mQueue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://neelpatel05.pythonanywhere.com/";

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
                        int atomicRadius = obj.getInt("atomicRadius");
                        int boilingPoint = obj.getInt("boilingPoint");
                        String bondingType = obj.getString("bondingType");
                        String cpkHexColor = obj.getString("cpkHexColor");
                        String density = obj.getString("density");
                        int electronAffinity = obj.getInt("electronAffinity");
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
                        //updating listView (forcing rendering)
                        listView.invalidateViews();
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
        Intent intent = new Intent(SearchActivity.this, ElementActivity.class);
        intent.putExtra("groupBlock", element.getGroupBlock());
        intent.putExtra("atomicNumber", element.getAtomicNumber());
        intent.putExtra("symbol", element.getSymbol());
        intent.putExtra("name", element.getName());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        return true;
    }

    //custom ArrayAdapter
    class elementArrayAdapter extends ArrayAdapter<Element> {

        private Context context;
        private List<Element> elements;

        //constructor, call on creation
        public elementArrayAdapter(Context context, int resource, ArrayList<Element> objects) {
            super(context, resource, objects);
            this.context = context;
            this.elements = objects;
        }

        //called when rendering the list
        public View getView(final int position, View convertView, ViewGroup parent) {
            //get the property we are displaying
            Element element = elements.get(position);

            //get the inflater and inflate the XML layout for each item
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.element_layout_item, null);

            TextView symbol = (TextView) view.findViewById(R.id.list_symbol);
            TextView atomicNumber = (TextView) view.findViewById(R.id.list_atomic_number);
            TextView name = (TextView) view.findViewById(R.id.list_name);

            //set price and rental attributes
            symbol.setText(element.getSymbol());
            atomicNumber.setText(String.valueOf(element.getAtomicNumber()));
            name.setText(element.getName());

            return view;
        }

    }
}
