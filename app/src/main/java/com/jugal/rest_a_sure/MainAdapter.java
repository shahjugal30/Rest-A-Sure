package com.jugal.rest_a_sure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainAdapter extends BaseAdapter {

    private CuisineFragment context;
    private LayoutInflater inflater;
    private String[] dishes_name;
    private int[] dishes_img;


    public MainAdapter(CuisineFragment c, String[] dishes_name, int[] dishes_img)
    {
        context = c;
        this.dishes_name=dishes_name;
        this.dishes_img=dishes_img;

    }

    @Override
    public int getCount() {
        return dishes_name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
        {
            inflater = (LayoutInflater) context.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.row_item,null);
        }
        ImageView imageView = convertView.findViewById(R.id.image_view68);
        TextView textView = convertView.findViewById(R.id.text_view68);

        imageView.setImageResource(dishes_img[position]);
        textView.setText(dishes_name[position]);
        return convertView;
    }
}
