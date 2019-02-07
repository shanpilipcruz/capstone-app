package com.example.capstoneproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.capstoneproject.adapters.Info;
import com.example.capstoneproject.adapters.InfoAdapter;

import java.util.ArrayList;

public class DiscoveryActivity_Catacombs extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capstone_discovery_loc_list);

        ArrayList<Info> info = new ArrayList<Info>();
        info.add(new Info(R.drawable.discovery_ricos, R.string.one_cat_name, R.string.one_cat_desc, R.string.one_cat_addr, R.string.one_cat_work, R.string.one_cat_tel, R.string.one_cat_site));
        info.add(new Info(R.drawable.discovery_pigpalm, R.string.two_cat_name, R.string.two_cat_desc, R.string.two_cat_addr, R.string.two_cat_work, R.string.two_cat_tel, R.string.two_cat_site));
        info.add(new Info(R.drawable.discovery_tymad, R.string.three_cat_name, R.string.three_cat_desc, R.string.three_cat_addr, R.string.three_cat_work, R.string.three_cat_tel, R.string.three_cat_site));
        info.add(new Info(R.drawable.discovery_circa, R.string.circa_name, R.string.circa_desc, R.string.circa_addr, R.string.circa_work, R.string.circa_tel, R.string.circa_site));
        info.add(new Info(R.drawable.discovery_matias, R.string.matias_name, R.string.matias_desc, R.string.matias_addr, R.string.matias_work, R.string.matias_tel, R.string.matias_site));
        info.add(new Info(R.drawable.discovery_johnna, R.string.haus_name, R.string.haus_desc, R.string.haus_addr, R.string.haus_work, R.string.haus_tel, R.string.haus_site));
        info.add(new Info(R.drawable.discovery_zubochon, R.string.zubo_name, R.string.zubo_desc, R.string.zubo_addr, R.string.zubo_work, R.string.zubo_tel, R.string.zubo_site));



        InfoAdapter adapter = new InfoAdapter(this, info);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
