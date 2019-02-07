package com.example.capstoneproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.capstoneproject.adapters.Info;
import com.example.capstoneproject.adapters.InfoAdapter;

import java.util.ArrayList;

public class DiscoveryActivity_Cafe extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capstone_discovery_loc_list);

        ArrayList<Info> info = new ArrayList<Info>();
        info.add(new Info(R.drawable.discovery_osmena_peak, R.string.one_cafe_name, R.string.one_cafe_desc, R.string.one_cafe_addr, R.string.one_cafe_work, R.string.one_cafe_tel, R.string.one_cafe_site));
        info.add(new Info(R.drawable.discovery_mt_naupa, R.string.two_cafe_name, R.string.two_cafe_desc, R.string.two_cafe_addr, R.string.two_cafe_work, R.string.two_cafe_tel, R.string.two_cafe_site));
        info.add(new Info(R.drawable.discovery_mt_kan, R.string.three_cafe_name, R.string.three_cafe_desc, R.string.three_cafe_addr, R.string.three_cafe_work, R.string.three_cafe_tel, R.string.three_cafe_site));
        info.add(new Info(R.drawable.discovery_mt_mauyog, R.string.four_cafe_name, R.string.four_cafe_desc, R.string.four_cafe_addr, R.string.four_cafe_work, R.string.four_cafe_tel, R.string.four_cafe_site));
        info.add(new Info(R.drawable.discovery_mt_manunggal, R.string.five_cafe_name, R.string.five_cafe_desc, R.string.five_cafe_addr, R.string.five_cafe_work, R.string.five_cafe_tel, R.string.five_cafe_site));
        info.add(new Info(R.drawable.discovery_mt_lanaya, R.string.lanaya_name, R.string.lanaya_desc, R.string.lanaya_addr, R.string.lanaya_work, R.string.lanaya_tel, R.string.lanaya_site));


        InfoAdapter adapter = new InfoAdapter(this, info);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
