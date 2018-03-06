package com.example.a1959freetibet.mylistviewcities;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    ListView list;

    String[] citynames = { "Bodhgaya", "Boudha", "Chicago", "Pokhara", "Seoul", "Toronto"};

    Integer[] imageid = {R.drawable.bodhgaya, R.drawable.boudha, R.drawable.chicago,
                         R.drawable.pokhara, R.drawable.seoul, R.drawable.toronto};

    String[] yearvisited = {"2002", "2006", "2009", "1996 - Where I was born", "2009", "2010"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomListAdapter adapter = new CustomListAdapter(this, citynames, imageid, yearvisited);
        list = (ListView) findViewById(R.id.citylist);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Slecteditem = citynames[+position];
                Toast.makeText(getApplicationContext(),
                        Slecteditem, Toast.LENGTH_LONG).show();
            }
        });
    }
}
