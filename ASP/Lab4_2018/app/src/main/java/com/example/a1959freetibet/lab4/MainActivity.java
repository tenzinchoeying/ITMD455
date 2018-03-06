package com.example.a1959freetibet.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String ListItemsName[] = new String[]{"Tibetan Children's Village", "Lion's Club", "Blink Nepal", "UNICEF", "Machik", "Shanti Bhavan", "Habitat for Humanity"};
    String ListItemsDetail[] = new String[]{"Sponsoring Tibetan Kids in India", "International volunteering", "Helping kids in Nepal", "International charity", "Charity for Tibet's future", "Charity for Untouchables", "Building houses for poor people"};
    Integer ImageName[] = { R.drawable.tcv, R.drawable.lc, R.drawable.blink, R.drawable.unicef, R.drawable.machik, R.drawable.sb, R.drawable.hh };

    ListView listView;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.list);
        listAdapter = new CustomListAdapter(MainActivity.this, ListItemsName, ListItemsDetail, ImageName);

        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ListItemsName[position], Toast.LENGTH_LONG).show();

            }
        });
    }
}
