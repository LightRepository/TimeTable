package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    ListView ListView;
//    JSONArray jsonArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView = findViewById(R.id.listView);
        Database db = new Database();
        System.out.println(Arrays.toString(db.lesson_name_arr));
        final String[] lessss = db.lesson_name_arr;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.new_item , R.id.lesson_name, lessss);

        ListView.setAdapter(adapter);
//        try {
//            JSONObject jsonObject = new JSONObject(getJSonData("users.json"));
//            jsonArray = jsonObject.getJSONArray("ZhuikovKF");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//
//
//
//
////        JSONArray jsonArray = getJSonData("users.json");
//        ArrayList<JSONObject> listItems= getArrayListFromJSONArray(jsonArray);
//        ListAdapter adapter = new userAdapter(this, R.layout.new_item, R.id.lesson_time, listItems);
//        ListView.setAdapter(adapter);
//    }
//
////    private JSONArray getJSonData(String filename){
//        private String getJSonData(String filename){
////        JSONArray jsonArray = null;
////        String jsonArray = null;
//            String json = null;
//        try {
//            InputStream inputStream = getResources().getAssets().open(filename);
//            int size = inputStream.available();
//            byte[] data = new byte[size];
//            inputStream.read(data);
//            inputStream.close();
////            String json = new String(data,"UTF-8");
//            json = new String(data,"UTF-8");
////            jsonArray = new JSONArray(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////        return jsonArray;
//        return json;
//    }
//
//    private ArrayList<JSONObject> getArrayListFromJSONArray (JSONArray jsonArray){
//        ArrayList<JSONObject> aList = new ArrayList<JSONObject>();
//        try {
//            if(jsonArray != null) {
//                for (int i = 0;i<jsonArray.length();i++){
//                    aList.add(jsonArray.getJSONObject(i));
//                }
//            }
//        } catch (JSONException js) {
//            js.printStackTrace();
//        }
//        return aList;

    }
}
