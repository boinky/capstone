package com.example.android.buktogo;

import com.mapswithme.maps.api.MWMPoint;

/**
 * Created by jan on 12/9/15.
 */
public class MwmDataItem {

    private final String id;
    private final String name;
    private final String description;
    private final double lat;
    private final double lon;

    public MwmDataItem(String id, String name, String description, double lat, double lon) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public String toString() {
        return name;
    }

    public MWMPoint toMWMPoint() {
        return new MWMPoint(lat, lon, name, id);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }




    public static MwmDataItem[] ITEMS = {
            new MwmDataItem("2116650", "Baungon", "Municipality of Baungon", 8.312594, 124.687185),
            new MwmDataItem("2116651", "Cabanglasan", "Municipality of Cabanglasan", 8.076538, 125.301185),
            new MwmDataItem("2116652", "Damulog", "Municipality of Damulog", 7.48139, 124.938843),
            new MwmDataItem("2116653", "Dangcagan", "Municipality of Dangcagan", 7.609997, 125.004117),
            new MwmDataItem("2116654", "Don Carlos", "Municipality of Don Carlos", 7.683809, 124.99463),
            new MwmDataItem("2116655", "Impasug-ong", "Municipality of Impasug-ong", 8.303395, 125.000832),
            new MwmDataItem("2116656", "Kadingilan", "Municipality of Kadingilan", 7.600126, 124.909926),
            new MwmDataItem("2116657", "Kalilangan", "Municipality of Kalilangan", 7.746855, 124.748095),
            new MwmDataItem("2116658", "Kibawe", "Municipality of Kibawe", 7.567833, 124.990323),
            new MwmDataItem("2116659", "Lantapan", "Municipality of Lantapan", 8.02327, 124.988),
            new MwmDataItem("2116660", "Libona", "Municipality of Libona", 8.328322, 124.756944),
            new MwmDataItem("2116661", "Malaybalay", "City of Malaybalay", 8.155399, 125.130449),
            new MwmDataItem("2116662", "Maramag", "Municipality of Maramag", 7.761122, 125.004793),
            new MwmDataItem("2116663", "Malitbog", "Municipality of Malitbog", 8.516667, 124.933334),
            new MwmDataItem("2116664", "Manolo Fortich", "Municipality of Manolo Fortich", 8.365963, 124.863782),
            new MwmDataItem("2116665", "Pangantucan", "Municipality of Pangantucan", 7.832224, 124.828232),
            new MwmDataItem("2116666", "Quezon", "Municipality of Quezon", 7.733333, 125.133333),
            new MwmDataItem("2116667", "San Fernando", "Municipality of San Fernando", 7.916795, 125.32872),
            new MwmDataItem("2116668", "Sumilao", "Municipality of Sumilao", 8.327045, 124.97796),
            new MwmDataItem("2116669", "Talakag", "Municipality of Talakag", 8.23227, 124.60357),
            new MwmDataItem("2116670", "Valencia", "City of Valencia", 7.902885, 125.089803)
    };
}
