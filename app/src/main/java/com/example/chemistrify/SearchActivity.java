package com.example.chemistrify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chemistrify.models.Element;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private ArrayList<Element> elements = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        //create property elements
        elements.add(new Element(10, "Ne", "Neón"));
        elements.add(new Element(11, "Na", "Sodio"));
        elements.add(new Element(28, "Ni", "Níquel"));
        elements.add(new Element(10, "Ne", "Neón"));
        elements.add(new Element(11, "Na", "Sodio"));
        elements.add(new Element(28, "Ni", "Níquel"));
        elements.add(new Element(10, "Ne", "Neón"));
        elements.add(new Element(11, "Na", "Sodio"));
        elements.add(new Element(28, "Ni", "Níquel"));
        elements.add(new Element(10, "Ne", "Neón"));
        elements.add(new Element(11, "Na", "Sodio"));
        elements.add(new Element(28, "Ni", "Níquel"));
        elements.add(new Element(10, "Ne", "Neón"));
        elements.add(new Element(11, "Na", "Sodio"));
        elements.add(new Element(28, "Ni", "Níquel"));
        elements.add(new Element(10, "Ne", "Neón"));
        elements.add(new Element(11, "Na", "Sodio"));
        elements.add(new Element(28, "Ni", "Níquel"));
        elements.add(new Element(10, "Ne", "Neón"));
        elements.add(new Element(11, "Na", "Sodio"));
        elements.add(new Element(28, "Ni", "Níquel"));
        elements.add(new Element(10, "Ne", "Neón"));
        elements.add(new Element(11, "Na", "Sodio"));
        elements.add(new Element(28, "Ni", "Níquel"));
        elements.add(new Element(10, "Ne", "Neón"));
        elements.add(new Element(11, "Na", "Sodio"));
        elements.add(new Element(28, "Ni", "Níquel"));
        elements.add(new Element(10, "Ne", "Neón"));
        elements.add(new Element(11, "Na", "Sodio"));
        elements.add(new Element(28, "Ni", "Níquel"));


        //create our new array adapter
        ArrayAdapter<Element> adapter = new elementArrayAdapter(this, 0, elements);

        //Find list view and bind it with the custom adapter
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), elements.get(position).getName() + "hola", Toast.LENGTH_SHORT).show();
                showElement(elements.get(position));
            }
        });
    }

    private void showElement(Element element){
        Intent intent = new Intent(SearchActivity.this, ElementActivity.class);
        intent.putExtra("element", element.getName());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        return true;
    }

    //custom ArrayAdapter
    class elementArrayAdapter extends ArrayAdapter<Element> /*implements AdapterView.OnItemClickListener*/ {

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
