package com.example.a1959freetibet.hw7n8;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CLA extends ArrayAdapter<String> {
    private final Activity context;

    private  ArrayList<String> title = new ArrayList<String>();
    private  ArrayList<String> author = new ArrayList<String>();
    private  ArrayList<String> rate = new ArrayList<String>();
    public CLA(Activity context, ArrayList<String> title, ArrayList<String> author, ArrayList<String> rate)
    {
        super (context, R.layout.mybooks, title);
        this.context = context;

        this.title = title;
        this.author = author;
        this.rate = rate;

    }

    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mybooks,null,true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.title);
        TextView txtAuthor = (TextView) rowView.findViewById(R.id.author);
        TextView txtRating = (TextView) rowView.findViewById(R.id.rate);
        txtTitle.setText(title.get(position));
        txtAuthor.setText(author.get(position));
        txtRating.setText(rate.get(position));
        return rowView;
    }

}
