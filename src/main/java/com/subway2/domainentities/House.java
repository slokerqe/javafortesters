package com.subway2.domainentities;

public class House implements Comparable<House>{ // need to implement Comparable to add to TreeSet
    int area;
    int price;
    String city;
    private boolean hasFurniture;

    public boolean isHasFurniture() {
        return hasFurniture;
    }

    public void setHasFurniture(boolean hasFurniture) {
        this.hasFurniture = hasFurniture;
    }

    public House(int area, int price, String city, boolean hasFurniture){
        this.area = area;
        this.price = price;
        this.city = city;
        this.hasFurniture = hasFurniture;
    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder("House {");
        sb.append("area = ").append(area);
        sb.append(", price = ").append(price);
        sb.append(", city = ").append(city);
        sb.append(", hasFurniture = ").append(hasFurniture);
        sb.append("} \n");
        return sb.toString();
    }


    public int compareTo(House anotherHouse) {
        if (this.area == anotherHouse.area){
            return 0;
        } else if (this.area < anotherHouse.area){
            return -1;
        } else{
            return 1;
        }
    }
}
