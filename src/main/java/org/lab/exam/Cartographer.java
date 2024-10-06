package org.lab.exam;

import java.util.LinkedHashSet;
import java.util.Objects;

public class Cartographer {
    private int[][] map;
    private int[][] log;
    private int n;
    private int m;
    Island island;
    private LinkedHashSet<Location> locations;
    Location location;

    public int countClosedIslands(int[][] pMap){
        if(!isMapValid(pMap)){
            return 0;
        }

        int count = 0;
        for (int i = 0; i < n; i += (exploringIsland() ? 0 : 1)) {
            for (int j = 0; j < m; j += (exploringIsland() ? 0 : 1)) {
                if (isWather(i, j) || (isVisited(i, j))) {
                    continue;
                } else if (isLand(i, j)) {
                    visit(i, j);

                    if (Objects.isNull(island)) {
                        island = new Island(new Location(i, j));
                    }

                    analyzeLand(i, j);

                    if (locations.isEmpty()) {
                        if (island.isClosed()) {
                            count++;
                        }
                        i = island.getStart().getX();
                        j = island.getStart().getY();
                        island = null;
                    } else {
                        location = locations.removeLast();
                        i = location.getX();
                        j = location.getY();
                    }
                }
            }
        }
        return count;

    }

    private boolean isMapValid(int[][] pMap){
        this.map = pMap;
        if(Objects.isNull(map)){
            return false;
        }

        n = map.length;
        if(n < 1 || n > 500){
            return false;
        }

        m = map[0].length;
        if(m < 1 || m > 500){
            return false;
        }

        for(int i = 0; i < n; i++){
            if(map[i].length != m){
                return false;
            }
        }

        log = new int[n][m];
        locations = new LinkedHashSet<Location>();
        return true;
    }

    private boolean exploringIsland(){
        return !Objects.isNull(island);
    }

    private boolean isLand(int i, int j){
        return map[i][j] == 1;
    }

    private boolean isWather(int i, int j){
        return map[i][j] == 0;
    }

    private boolean isVisited(int i, int j) {
        return log[i][j] == 1;
    }

    public void visit(int i, int j) {
        log[i][j] = 1;
    }

    private void analyzeLand(int i, int j){
        boolean test = true;
        test &= isClosedFromRightLand(i, j);
        test &= isClosedFromBottomLand(i, j);
        test &= isClosedFromLeftLand(i, j);
        test &= isClosedFromTopLand(i, j);
        test &= island.isClosed();
        island.setClosed(test);
    }

    private boolean isClosedFromRightLand(int i, int j){
        return isClosingLand(i, j+1);
    }

    private boolean isClosedFromBottomLand(int i, int j){
        return isClosingLand(i+1, j);
    }

    private boolean isClosedFromLeftLand(int i, int j){
        return isClosingLand(i, j-1);
    }

    private boolean isClosedFromTopLand(int i, int j){
        return isClosingLand(i-1, j);
    }

    private boolean isClosingLand(int i, int j){
        try{
            if(isWather(i,j) || isVisited(i,j)){
                return true;
            }
            if(isLand(i,j)){
                locations.add(new Location(i, j));
                return true;
            }
        }
        catch(IndexOutOfBoundsException ex){
            return false;
        }
        return false;
    }
}
