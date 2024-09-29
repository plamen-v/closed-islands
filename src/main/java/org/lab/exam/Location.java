package org.lab.exam;

import java.util.Comparator;

public class Location implements Comparable<Location>{
    private int x;
    private int y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Location o) {
        return Comparator.comparing(Location::getX)
                .thenComparing(Location::getY)
                .compare(this, o);
    }
}
