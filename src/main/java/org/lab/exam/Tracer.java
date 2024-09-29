package org.lab.exam;

import java.util.TreeSet;

public class Tracer {
    private TreeSet<Location> route;
    private int[][] map;

    public Tracer(int n, int m){
        map = new int[n][m];
        route = new TreeSet<Location>();
    }
    public boolean isLandVisited(int i, int j) {
        return map[i][j] == 1;
    }
    public void visitLand(int i, int j) {
        map[i][j] = 1;
    }

    public TreeSet<Location> getRoute() {
        return route;
    }
}
