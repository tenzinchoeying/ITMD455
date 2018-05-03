package com.example.a1959freetibet.hw7n8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.widget.Toast;
import android.view.View;
import android.util.Log;
import android.widget.Spinner;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> title = new ArrayList<String>();
    private ArrayList<String> rate = new ArrayList<String>();
    private ArrayList<String> author = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SH db = new SH(this);
        Log.d("Name", "Tenzin Choeying");

        db.addBook(new Book("My Land and My People", "Dalai Lama", "5"));
        db.addBook(new Book("Republic", "Plato", "4"));
        db.addBook(new Book("Meditations", "Marcus Aurelius", "4"));

        List<Book> list = db.getAllBooks();
        int a = db.updateBook(list.get(0));
        db.deleteBook(list.get(0));
        db.getAllBooks();

        title = db.queryTitle();
        rate = db.queryRate();
        author = db.queryAuthor();

        CLA adapter = new CLA(this, title, author, rate);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        final ArrayAdapter<String> i = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, title);
        i.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(i);

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int p, long d) {
                String item = spinner.getSelectedItem().toString();
                String book = db.getBook(item);
                Toast.makeText(getApplicationContext(), "Selected: " + book, Toast.LENGTH_LONG).show();
            }

        });
    }
}
