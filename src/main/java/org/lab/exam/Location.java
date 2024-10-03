package org.lab.exam;

import java.util.Comparator;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        if (!(o instanceof Location)) {
            return false;
        }

        Location c = (Location) o;
        return this.getX() == c.getX() && this.getY() == c.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
