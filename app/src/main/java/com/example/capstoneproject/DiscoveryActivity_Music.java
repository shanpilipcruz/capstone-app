package com.example.capstoneproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.capstoneproject.adapters.Info;
import com.example.capstoneproject.adapters.InfoAdapter;

import java.util.ArrayList;

public class DiscoveryActivity_Music extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capstone_discovery_loc_list);

        ArrayList<Info> info = new ArrayList<Info>();
        info.add(new Info(R.drawable.discovery_waterfront, R.string.waterfront_name, R.string.waterfront_desc, R.string.waterfront_addr, R.string.waterfront_work, R.string.waterfront_tel, R.string.waterfront_site));
        info.add(new Info(R.drawable.discovery_north, R.string.north_name, R.string.north_desc, R.string.north_addr, R.string.north_work, R.string.north_tel, R.string.north_site));
        info.add(new Info(R.drawable.discovery_pacific, R.string.pacific_name, R.string.pacific_desc, R.string.pacific_addr, R.string.pacific_work, R.string.pacific_tel, R.string.pacific_site));
        info.add(new Info(R.drawable.discovery_blu, R.string.blu_name, R.string.blu_desc, R.string.blu_addr, R.string.blu_work, R.string.blu_tel, R.string.blu_site));
        info.add(new Info(R.drawable.discovery_cubana, R.string.cubana_name, R.string.cubana_desc, R.string.cubana_addr, R.string.cubana_work, R.string.cubana_tel, R.string.cubana_site));
        info.add(new Info(R.drawable.discovery_marshall, R.string.marshall_name, R.string.marshall_desc, R.string.marshall_addr, R.string.marshall_work, R.string.marshall_tel, R.string.marshall_site));
        info.add(new Info(R.drawable.discovery_blubar, R.string.blubar_name, R.string.blubar_desc, R.string.blubar_addr, R.string.blubar_work, R.string.blubar_tel, R.string.blubar_site));


        InfoAdapter adapter = new InfoAdapter(this, info);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
