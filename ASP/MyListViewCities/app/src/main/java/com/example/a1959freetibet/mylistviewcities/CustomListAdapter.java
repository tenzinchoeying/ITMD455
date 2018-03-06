package com.example.a1959freetibet.mylistviewcities;

/**
 * Created by 1959freetibet on 10/2/17.
 */
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;
    private final String[] year;
    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid, String[] year) {
        super(context, R.layout.mycities, itemname);

        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
        this.year = year;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mycities,
            null,true);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.cityicon);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.cityname);
        TextView txtTitle1 = (TextView) rowView.findViewById(R.id.year);

        txtTitle.setText(itemname[position]);
        txtTitle1.setText(year[position]);
        imageView.setImageResource(imgid[position]);

        return rowView;
    };
}
