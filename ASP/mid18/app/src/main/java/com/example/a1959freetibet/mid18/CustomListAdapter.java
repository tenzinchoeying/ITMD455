package com.example.a1959freetibet.mid18;

/**
 * Created by 1959freetibet on 3/5/18.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.a1959freetibet.mid18.my2nd;

import org.w3c.dom.Text;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity Context;
    private final String[] ListItemsName;
    private final String[] ListItemsDetail;

    public CustomListAdapter(Activity context, String[] content, String[] description)
    {
        super(context, R.layout.classlist, content);

        this.Context = context;
        this.ListItemsName = content;
        this.ListItemsDetail = description;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = Context.getLayoutInflater();
        View ListViewSingle = inflater.inflate(R.layout.classlist,null, true);

        TextView ListViewItems = (TextView)
                ListViewSingle.findViewById(R.id.name);
        TextView ListViewDetail = (TextView)
                ListViewSingle.findViewById(R.id.detail);

        ListViewItems.setText(ListItemsName[position]);
        ListViewDetail.setText(ListItemsDetail[position]);

        return ListViewSingle;
    };
}