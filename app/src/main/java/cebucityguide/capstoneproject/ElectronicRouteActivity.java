package cebucityguide.capstoneproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import cebucityguide.capstoneproject.eRouteBackend.eRouteBackend;

public class ElectronicRouteActivity extends HomeActivity {

    TextView get_direction;
    String records= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.capstone_electronic_route_activity, frameLayout);
        setTitle("E-Route");

        Spinner spinner = findViewById(R.id.spinner);
        get_direction= findViewById(R.id.view_direction);


        eRouteBackend dbBackend = new eRouteBackend(ElectronicRouteActivity.this);
        String[] spinnerLists = dbBackend.getAllSpinnerContent();

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(ElectronicRouteActivity.this, android.R.layout.simple_spinner_item, spinnerLists);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        records = getResources().getString(R.string.x01K);
                        break;

                    case 1:
                        records = getResources().getString(R.string.xx01K);
                        break;

                    case 2:
                        records = getResources().getString(R.string.x14D);
                        break;

                    case 3:
                        records = getResources().getString(R.string.xx14D);
                        break;

                    case 4:
                        records = getResources().getString(R.string.xxx14D);
                        break;

                    case 5:
                        records = getResources().getString(R.string.x04L);
                        break;

                    case 6:
                        records = getResources().getString(R.string.xx04L);
                        break;

                    case 7:
                        records = getResources().getString(R.string.x03A);
                        break;

                    case 8:
                        records = getResources().getString(R.string.xx03A);
                        break;

                    case 9:
                        records = getResources().getString(R.string.x17C);
                        break;

                    case 10:
                        records = getResources().getString(R.string.xx17C);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @SuppressLint("ResourceAsColor")
    public void getDirection (View view)
    {
        get_direction.setTextSize(18);
        get_direction.setTextColor(R.color.black);
        get_direction.setText(records);
    }
}
