package org.lab.exam;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Tracer {
    private LinkedHashSet<Location> route;
    private int[][] map;

    public Tracer(int n, int m){
        map = new int[n][m];
        route = new LinkedHashSet<Location>();
    }
    public boolean isLandVisited(int i, int j) {
        return map[i][j] == 1;
    }
    public void visitLand(int i, int j) {
        map[i][j] = 1;
    }

    public LinkedHashSet<Location> getRoute() {
        return route;
    }
}
