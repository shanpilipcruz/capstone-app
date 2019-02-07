package com.example.capstoneproject.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.VisibleForTesting;

import com.example.capstoneproject.R;

import java.util.ArrayList;
import java.util.List;

public class ActivitiesRepository {

    @SuppressWarnings({"FieldCanBeLocal", "unused"}) private Context context;
    private List<ActivitiesCollection> collections;
    @SuppressLint("StaticFieldLeak") private static ActivitiesRepository attractionRepository;

    public static ActivitiesRepository getInstance(Context packageContext) {
        if (attractionRepository == null) {
            attractionRepository = new ActivitiesRepository(packageContext);
        }
        return attractionRepository;
    }

    public ActivitiesCollection getCollection(int sectionTitle) {
        for (int i = 0; i < collections.size(); i++) {
            if (sectionTitle == collections.get(i).getHeaderTitle()) {
                return collections.get(i);
            }
        }

        return null;
    }

    private ActivitiesRepository(Context context) {
        this.context = context.getApplicationContext();
        collections = new ArrayList<>();

        // Build collection
        ActivitiesCollection activity = buildActivityCollection();
        collections.add(activity);

        ActivitiesCollection restaurants = buildRestaurantsCollection();
        collections.add(restaurants);

        ActivitiesCollection breweries = buildBreweriesCollection();
        collections.add(breweries);

        ActivitiesCollection nightLife = buildNightLifeCollection();
        collections.add(nightLife);
    }

    public List<ActivitiesCollection> getCollections() {
        return collections;
    }

    @VisibleForTesting
    static ActivitiesCollection buildActivityCollection() {
        List<Activities> attractions = new ArrayList<>();

        attractions.add(new Activities(
                        R.drawable.activities_sea_turtle_lagoon,
                        R.string.sea_turtle_lagoon_title,
                        R.string.summer_gate_away,
                        R.string.sea_turtle_lagoon_detailed_desc,
                        R.string.mq_sea_turtle_lagoon
                )
        );


        attractions.add(new Activities(
                        R.drawable.activities_cebu_westown_lagoon,
                        R.string.cebu_westown_lagoon_title,
                        R.string.best_outdoors,
                        R.string.cebu_westown_lagoon_detailed_desc,
                        R.string.mq_cebu_westown_lagoon
                )
        );

        attractions.add(new Activities(
                        R.drawable.activities_mt_babag,
                        R.string.mt_babag_title,
                        R.string.best_outdoors,
                        R.string.mt_babag_detailed_desc,
                        R.string.mq_mt_babag
                )
        );
        attractions.add(new Activities(
                        R.drawable.activities_sirao_peak,
                        R.string.sirao_peak_title,
                        R.string.mountain_hiking,
                        R.string.sirao_peak_detailed_desc,
                        R.string.mq_sirao_peak
                )
        );

        attractions.add(new Activities(
                        R.drawable.activities_oslob_cebu,
                        R.string.oslob_cebu,
                        R.string.oslob_cebu_ttile,
                        R.string.oslob_cebu_detailed_desc,
                        R.string.mq_sirao_peak
                )
        );

        attractions.add(new Activities(
                        R.drawable.activities_kawasan_falls,
                        R.string.kawasan_falls_ttile,
                        R.string.natural_wonder,
                        R.string.kawasan_falls_detailed_desc,
                        R.string.mq_kawasan_falls
                )
        );




        return new ActivitiesCollection(R.string.top_activities, attractions);
    }

    @VisibleForTesting
    static ActivitiesCollection buildRestaurantsCollection() {
        ArrayList<Activities> attractions = new ArrayList<>();

        attractions.add(new Activities(
                        R.drawable.activities_anzani_cebu,
                        R.string.anzani_cebu_title,
                        R.string.top_restaurants,
                        R.string.anzani_cebu_detailed_desc,
                        R.string.mq_anzani_cebu
                )
        );
        attractions.add(new Activities(
                        R.drawable.activities_circa_1900_cebu,
                        R.string.circa_1900_title,
                        R.string.top_restaurants,
                        R.string.circa_1900_detailed_desc,
                        R.string.mq_circa_1900
                )
        );
        attractions.add(new Activities(
                        R.drawable.activities_top_of_cebu,
                        R.string.top_of_cebu_title,
                        R.string.mountain_top,
                        R.string.top_of_cebu_detailed_desc,
                        R.string.mq_top_of_cebu
                )
        );
        attractions.add(new Activities(
                        R.drawable.activities_tavolata_cebu,
                        R.string.tavolata_cebu_title,
                        R.string.tavolata_cebu,
                        R.string.tavolata_cebu_detailed_desc,
                        R.string.mq_tavolata_cebu
                )
        );

        attractions.add(new Activities(
                        R.drawable.activities_abaca_baking_company,
                        R.string.abaca_baking_title,
                        R.string.breakfast_place,
                        R.string.abaca_baking_detailed_desc,
                        R.string.mq_abaca_baking
                )
        );
        attractions.add(new Activities(
                        R.drawable.activities_abaseria_deli,
                        R.string.abaseria_cafe_title,
                        R.string.abaseria,
                        R.string.abaseria_deli_detailed_desc,
                        R.string.mq_abaseria_deli
                )
        );

        return new ActivitiesCollection(R.string.top_restaurants, attractions);
    }

    @VisibleForTesting
    static ActivitiesCollection buildBreweriesCollection() {
        ArrayList<Activities> attractions = new ArrayList<>();

        attractions.add(new Activities(
                        R.drawable.activities_basilica_minore,
                        R.string.basilica_minore_title,
                        R.string.catholic_church,
                        R.string.basilica_minor_detailed_desc,
                        R.string.mq_basilica_minor
                )
        );
        attractions.add(new Activities(
                        R.drawable.activities_cebu_taoist_temple,
                        R.string.cebu_taoist_temple_title,
                        R.string.horticulture_display,
                        R.string.cebu_taoist_temple_detailed_desc,
                        R.string.mq_cebu_taoist_temple
                )
        );
        attractions.add(new Activities(
                        R.drawable.activities_fort_san_pedro,
                        R.string.fort_san_pedro_title,
                        R.string.best_outdoors,
                        R.string.fort_san_pedro_detailed_desc,
                        R.string.mq_fort_san_pedro
                )
        );

        return new ActivitiesCollection(R.string.top_places, attractions);
    }

    @VisibleForTesting
    static ActivitiesCollection buildNightLifeCollection() {
        ArrayList<Activities> attractions = new ArrayList<>();

        attractions.add(new Activities(
                        R.drawable.activities_wish_resto_bar,
                        R.string.wish_bar_title,
                        R.string.wish_bar,
                        R.string.wish_cebu_detailed_desc,
                        R.string.mq_wish_bar
                )
        );
        attractions.add(new Activities(
                        R.drawable.activities_blu_bar_grill,
                        R.string.blu_bar_title,
                        R.string.blu_bar,
                        R.string.blu_bar_detailed_desc,
                        R.string.mq_blu_Bar
                )
        );
        attractions.add(new Activities(
                        R.drawable.activities_morals_malice,
                        R.string.morals_malice_title,
                        R.string.morals_malice_bar,
                        R.string.morals_malice_detailed_desc,
                        R.string.mq_morals_malice
                )
        );
        attractions.add(new Activities(
                        R.drawable.activities_trademark_bar,
                        R.string.trademark_bar_title,
                        R.string.trademark_bar_beers,
                        R.string.trademark_bar_detailed_desc,
                        R.string.mq_trademark_bar
                )
        );
        attractions.add(new Activities(
                        R.drawable.activities_jump_shot,
                        R.string.jump_shot_title,
                        R.string.sports_bar,
                        R.string.jump_shot_bar_detailed_desc,
                        R.string.mq_jump_shot_bar
                )
        );
        attractions.add(new Activities(
                        R.drawable.activities_kawasan_falls,
                        R.string.kawasan_falls_ttile,
                        R.string.natural_wonder,
                        R.string.kawasan_falls_detailed_desc,
                        R.string.mq_kawasan_falls
                )
        );


        return new ActivitiesCollection(R.string.top_bars_nightlife, attractions);
    }
}
