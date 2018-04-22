package com.example.e460.currencyexchange;

import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView1;
    ListView listView2;

    ArrayList<String> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 = findViewById(R.id.listView1);
        listView2 = findViewById(R.id.listView2);

        countries = new ArrayList<>();
        countries.add("VND");
        countries.add("USD");
        countries.add("EUR");

        /*ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.activity_main, countries);
        listView1.setAdapter(adapter);
        listView2.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String text = listView1.getItemAtPosition(position).toString();

            }
        });*/
    }
}
