package org.lab.exam;

import java.util.Comparator;
import java.util.Objects;

public class Location{
    private int x;
    private int y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Location)) {
            return false;
        }

        Location l = (Location) o;
        return this.getX() == l.getX() && this.getY() == l.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
