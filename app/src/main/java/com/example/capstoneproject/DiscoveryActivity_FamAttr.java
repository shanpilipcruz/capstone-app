package com.example.capstoneproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.capstoneproject.adapters.Info;
import com.example.capstoneproject.adapters.InfoAdapter;

import java.util.ArrayList;

public class DiscoveryActivity_FamAttr extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capstone_discovery_loc_list);

        ArrayList<Info> info = new ArrayList<Info>();

        info.add(new Info(R.drawable.discovery_paradise, R.string.one_mus_name, R.string.one_mus_desc, R.string.one_mus_addr, R.string.one_mus_work, R.string.one_mus_tel, R.string.one_mus_site));
        info.add(new Info(R.drawable.discovery_lambug, R.string.two_mus_name, R.string.two_mus_desc, R.string.two_mus_addr, R.string.two_mus_work, R.string.one_mus_tel, R.string.two_mus_site));
        info.add(new Info(R.drawable.discovery_bounty, R.string.three_mus_name, R.string.three_mus_desc, R.string.three_mus_addr, R.string.three_mus_work, R.string.three_mus_tel, R.string.three_mus_site));
        info.add(new Info(R.drawable.discovery_hermit_cove, R.string.four_mus_name, R.string.four_mus_desc, R.string.four_mus_addr, R.string.four_mus_work, R.string.four_mus_tel, R.string.four_mus_site));
        info.add(new Info(R.drawable.discovery_langub, R.string.langub_name, R.string.langub_desc, R.string.langub_addr, R.string.langub_work, R.string.langub_tel, R.string.langub_site));



        InfoAdapter adapter = new InfoAdapter(this, info);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
