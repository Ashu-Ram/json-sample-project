package com.json.demo.model;

public class MergedData {
    private String id;
    private double latitude;
    private double longitude;
    private String type;
    private double rating;
    private int reviews;

    // Constructor
    public MergedData(String id, double latitude, double longitude, String type, double rating, int reviews) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.rating = rating;
        this.reviews = reviews;
    }

    // Getters
    public String getId() { return id; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public String getType() { return type; }
    public double getRating() { return rating; }
    public int getReviews() { return reviews; }
}