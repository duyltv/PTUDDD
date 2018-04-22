package com.example.e460.currencyexchange;

import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView1;
    ListView listView2;

    ArrayList<String> countries;

    Float exchangeValue[] = {Float.valueOf(1000000), Float.valueOf(44), Float.valueOf(36) };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 = findViewById(R.id.listView1);
        listView2 = findViewById(R.id.listView2);

        final TextView textView3 = (TextView) findViewById(R.id.textView3);
        final TextView textView2 = (TextView) findViewById(R.id.textView2);

        countries = new ArrayList<>();
        countries.add("VND");
        countries.add("USD");
        countries.add("EUR");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);
        listView1.setAdapter(adapter);
        listView2.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = listView1.getItemAtPosition(position).toString();

                textView2.setText(text);
            }
        });

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = listView2.getItemAtPosition(position).toString();

                textView3.setText(text);
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                EditText editText1 = (EditText) findViewById(R.id.editText);
                String input = editText1.getText().toString();

                Float f= Float.parseFloat(input);
                Float result = Float.valueOf(0);

                if (textView2.getText() == "VND")
                    result = f / exchangeValue[0];
                else if (textView2.getText() == "USD")
                    result = f / exchangeValue[1];
                else
                    result = f / exchangeValue[2];

                if (textView3.getText() == "VND")
                    result = result * exchangeValue[0];
                else if (textView3.getText() == "USD")
                    result = result * exchangeValue[1];
                else
                    result = result * exchangeValue[2];

                EditText editText2 = (EditText) findViewById(R.id.editText2);
                editText2.setText(result.toString());
            }
        });
    }
}
