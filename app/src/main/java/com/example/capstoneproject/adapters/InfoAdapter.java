package com.example.capstoneproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.capstoneproject.R;

import java.util.List;

public class InfoAdapter extends ArrayAdapter<Info> {


    public InfoAdapter(Context context, List<Info> info) {
        super(context, 0, info);
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.capstone_discovery_list_item, parent, false);
        }

        Info currentLocation = getItem(position);

        ImageView imageView = listItemView.findViewById(R.id.photoImageView);
        imageView.setImageResource(currentLocation.getImageResourceId());
        imageView.setVisibility(View.VISIBLE);

        TextView nameLocationTextView = listItemView.findViewById(R.id.nameTextView);
        nameLocationTextView.setText(currentLocation.getName());

        TextView descriptionLocationTextView = listItemView.findViewById(R.id.descriptionTextView);
        descriptionLocationTextView.setText(currentLocation.getDesc());

        TextView addressLocationTextView = listItemView.findViewById(R.id.addressTextView);
        addressLocationTextView.setText(currentLocation.getAddress());

        TextView workHoursLocationTextView = listItemView.findViewById(R.id.workHoursTextView);
        workHoursLocationTextView.setText(currentLocation.getWorkHours());

        TextView phoneLocationTextView = listItemView.findViewById(R.id.phoneTextView);
        phoneLocationTextView.setText(currentLocation.getTel());

        TextView siteLocationTextView = listItemView.findViewById(R.id.siteTextView);
        siteLocationTextView.setText(currentLocation.getSite());

        return listItemView;
    }
}

