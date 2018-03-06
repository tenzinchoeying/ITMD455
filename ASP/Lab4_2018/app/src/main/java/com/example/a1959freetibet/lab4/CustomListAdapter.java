package com.example.a1959freetibet.lab4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.a1959freetibet.lab4.MainActivity;

import org.w3c.dom.Text;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity Context;
    private final String[] ListItemsName;
    private final String[] ListItemsDetail;
    private final Integer[] ImageName;

    public CustomListAdapter(Activity context, String[] content, String[] description, Integer[] ImageName)
    {
        super(context, R.layout.charities, content);

        this.Context = context;
        this.ListItemsName = content;
        this.ListItemsDetail = description;
        this.ImageName = ImageName;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = Context.getLayoutInflater();
        View ListViewSingle = inflater.inflate(R.layout.charities,null, true);

        TextView ListViewItems = (TextView)
                ListViewSingle.findViewById(R.id.name);
        TextView ListViewDetail = (TextView)
                ListViewSingle.findViewById(R.id.detail);
        ImageView ListViewImage = (ImageView)
                ListViewSingle.findViewById(R.id.icon);

        ListViewItems.setText(ListItemsName[position]);
        ListViewDetail.setText(ListItemsDetail[position]);
        ListViewImage.setImageResource(ImageName[position]);

        return ListViewSingle;
    };
}
