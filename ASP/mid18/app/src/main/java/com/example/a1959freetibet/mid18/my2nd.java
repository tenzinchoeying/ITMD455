package com.example.a1959freetibet.mid18;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 1959freetibet on 3/5/18.
 */

public class my2nd extends MainActivity {

    String ListItemsName[] = new String[]{"BUS210","BUS371", "ITMD455", "ITMD462", "ITMD411", "IPRO300"};
    String ListItemsDetail[] = new String[]{"Accounting", "Marketing", "Andriod", "Website", "Software", "Project"};

    ListView listView;
    ListAdapter listAdapter;
    TextView welcomeuser;


    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceStats) {
        super.onCreate(savedInstanceStats);
        setContentView(R.layout.my2nd);

        listView = (ListView)findViewById(R.id.list);
        listAdapter = new CustomListAdapter(my2nd.this, ListItemsName, ListItemsDetail);

        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),ListItemsName[position], Toast.LENGTH_LONG).show();
            }
        });

        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(my2nd.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
