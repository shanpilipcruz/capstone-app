package com.example.capstoneproject.model;

import java.util.List;

public class ActivitiesCollection {

    private int headerTitle;
    private List<Activities> listOfAttractions;

    public ActivitiesCollection(int headerTextResId, List<Activities> listOfAttractions) {
        this.headerTitle = headerTextResId;
        this.listOfAttractions = listOfAttractions;
    }

    public int getHeaderTitle() {
        return headerTitle;
    }

    public List<Activities> getAttractions() {
        return listOfAttractions;
    }
}

