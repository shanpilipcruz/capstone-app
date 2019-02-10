package cebucityguide.capstoneproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import cebucityguide.capstoneproject.adapters.Info;
import cebucityguide.capstoneproject.adapters.InfoAdapter;

public class DiscoveryActivity_Museum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capstone_discovery_loc_list);

        ArrayList<Info> info = new ArrayList<Info>();

        info.add(new Info(R.drawable.discovery_sinulog, R.string.one_fam_name, R.string.one_fam_desc, R.string.one_fam_addr, R.string.one_fam_work, R.string.one_fam_tel, R.string.one_fam_site));
        info.add(new Info(R.drawable.discovery_tagbo, R.string.two_fam_name, R.string.two_fam_desc, R.string.two_fam_addr, R.string.two_fam_work, R.string.two_fam_tel, R.string.two_fam_site));
        info.add(new Info(R.drawable.discovery_silmugi, R.string.three_fam_name, R.string.three_fam_desc, R.string.three_fam_addr, R.string.three_fam_work, R.string.three_fam_tel, R.string.three_fam_site));
        info.add(new Info(R.drawable.discovery_bodbod, R.string.four_fam_name, R.string.four_fam_desc, R.string.four_fam_addr, R.string.four_fam_work, R.string.four_fam_tel, R.string.four_fam_site));
        info.add(new Info(R.drawable.discovery_kabayo, R.string.five_fam_name, R.string.five_fam_desc, R.string.five_fam_addr, R.string.five_fam_work, R.string.five_fam_tel, R.string.five_fam_site));
        info.add(new Info(R.drawable.discovery_sarok, R.string.sarok_name, R.string.sarok_desc, R.string.sarok_addr, R.string.sarok_work, R.string.sarok_tel, R.string.sarok_site));
        info.add(new Info(R.drawable.discovery_soli_soli, R.string.sarok_name, R.string.sarok_desc, R.string.sarok_addr, R.string.sarok_work, R.string.sarok_tel, R.string.sarok_site));
        info.add(new Info(R.drawable.discovery_tostado, R.string.tostado_name, R.string.tostado_desc, R.string.tostado_addr, R.string.tostado_work, R.string.tostado_tel, R.string.tostado_site));
        info.add(new Info(R.drawable.discovery_haladaya, R.string.haladaya_name, R.string.haladaya_desc, R.string.haladaya_addr, R.string.haladaya_work, R.string.haladaya_tel, R.string.haladaya_site));
        info.add(new Info(R.drawable.discovery_bahug, R.string.bahug_name, R.string.bahug_desc, R.string.bahug_addr, R.string.bahug_work, R.string.bahug_tel, R.string.bahug_site));



        InfoAdapter adapter = new InfoAdapter(this, info);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
