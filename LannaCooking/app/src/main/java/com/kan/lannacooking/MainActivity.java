package com.kan.lannacooking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView menu_listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu_listview = (ListView)findViewById(R.id.menu_listView);

        LannaCookingDAO lannaCookingDAO = new LannaCookingDAO(getApplicationContext());
        lannaCookingDAO.open();
        ArrayList<String> listMenu = lannaCookingDAO.getAllCooking();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listMenu);
        menu_listview.setAdapter(adapter);
    }
}
