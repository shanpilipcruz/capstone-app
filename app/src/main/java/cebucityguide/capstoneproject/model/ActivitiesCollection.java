package cebucityguide.capstoneproject.model;

import java.util.List;

public class ActivitiesCollection {

    private int headerTitle;
    private List<cebucityguide.capstoneproject.model.Activities> listOfAttractions;

    public ActivitiesCollection(int headerTextResId, List<cebucityguide.capstoneproject.model.Activities> listOfAttractions) {
        this.headerTitle = headerTextResId;
        this.listOfAttractions = listOfAttractions;
    }

    public int getHeaderTitle() {
        return headerTitle;
    }

    public List<cebucityguide.capstoneproject.model.Activities> getAttractions() {
        return listOfAttractions;
    }
}

