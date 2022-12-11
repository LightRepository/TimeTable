package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class userAdapter extends ArrayAdapter<JSONObject> {
    int listLayout;
    ArrayList<JSONObject> list;
    Context context;

    public userAdapter(Context context, int listLayout, int field , ArrayList<JSONObject> list){
        super(context, listLayout, field, list);
        this.context = context;
        this.listLayout = listLayout;
        this.list = list;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(listLayout,parent,false);
        TextView lesson_time = itemView.findViewById(R.id.lesson_time);
        TextView lesson_name = itemView.findViewById(R.id.lesson_name);
        TextView lesson_number = itemView.findViewById(R.id.lesson_number);
        TextView group_name = itemView.findViewById(R.id.group_name);
        TextView cabinet_number = itemView.findViewById(R.id.cabinet_number);
        try {
            lesson_time.setText(list.get(position).getString("lesson_time"));
            lesson_name.setText(list.get(position).getString("lesson_name"));
            lesson_number.setText(list.get(position).getString("lesson_number"));
            group_name.setText(list.get(position).getString("group_name"));
            cabinet_number.setText(list.get(position).getString("cabinet_number"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return itemView;
    }
}
