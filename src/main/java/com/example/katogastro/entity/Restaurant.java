package com.example.katogastro.entity;

public class Restaurant {
   private Long id;
   private float degrees;
   private float minutes;
   private String address;
   private String name;
   private String cuisine;
   private boolean visited;

    public Restaurant() {
    }

    public Restaurant(float degrees, float minutes, String address, String name, String cuisine, boolean visited) {
        this.degrees = degrees;
        this.minutes = minutes;
        this.address = address;
        this.name = name;
        this.cuisine = cuisine;
        this.visited = visited;
    }

    public Restaurant(Long id, float degrees, float minutes, String address, String name, String cuisine, boolean visited) {
        this.id = id;
        this.degrees = degrees;
        this.minutes = minutes;
        this.address = address;
        this.name = name;
        this.cuisine = cuisine;
        this.visited = visited;
    }

    public float getDegrees() {
        return degrees;
    }

    public void setDegrees(float degrees) {
        this.degrees = degrees;
    }

    public float getMinutes() {
        return minutes;
    }

    public void setMinutes(float minutes) {
        this.minutes = minutes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "degrees=" + degrees +
                ", minutes=" + minutes +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", visited=" + visited +
                '}';
    }
}
