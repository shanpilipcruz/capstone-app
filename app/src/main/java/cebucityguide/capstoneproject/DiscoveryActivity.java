package cebucityguide.capstoneproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DiscoveryActivity extends HomeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.capstone_discovery_activity, frameLayout);
        setTitle("Activities");

        setCustomOnClickListener(R.id.hotel, DiscoveryActivity_Hotels.class);
        setCustomOnClickListener(R.id.cafes, DiscoveryActivity_Cafe.class);
        setCustomOnClickListener(R.id.fam_attract, DiscoveryActivity_FamAttr.class);
        setCustomOnClickListener(R.id.museums, DiscoveryActivity_Museum.class);
        setCustomOnClickListener(R.id.catacombs, DiscoveryActivity_Catacombs.class);
        setCustomOnClickListener(R.id.music, DiscoveryActivity_Music.class);
    }

    public void setCustomOnClickListener(int resourceID, final Class className) {
        View view = findViewById(resourceID);
        view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), className);
                        startActivity(intent);
                    }
                }
        );
    }
}
