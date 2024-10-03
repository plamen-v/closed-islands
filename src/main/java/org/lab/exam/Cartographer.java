package org.lab.exam;

import java.util.Objects;

public class Cartographer {
    int[][] map;
    Tracer tracer;
    Land land;
    private int n;
    private int m;

    public int getClosedIslandsCount(int[][] pMap){
        map = pMap;
        if(!isMapValid()){
            return 0;
        }

        int count = 0;
        tracer = new Tracer(n, m);

        for(int i = 0; i < n; i+= (Objects.isNull(land)? 1 : 0)){
            for(int j = 0; j < m; j+= (Objects.isNull(land)? 1 : 0)) {
                if(map[i][j]  == 0 || (tracer.isLandVisited(i,j))){
                    continue;
                }else if(map[i][j]  == 1){
                    tracer.visitLand(i,j);

                    //Start new land tracing
                    if(Objects.isNull(land)) {
                        land = new Land(new Location(i, j));
                    }
                    
                    processLand(i,j);

                    //Loop control
                    if(tracer.getRoute().isEmpty()){
                        //If no more lands for current island to explore. Check state and continue
                        if(land.isClosed()){
                            count++;
                        }
                        i = land.getStart().getX();
                        j = land.getStart().getY();
                        land = null;
                    }else{
                        //Jump to the neighbor.
                        Location location = tracer.getRoute().removeLast();
                        i = location.getX();
                        j = location.getY();
                    }
                }
            }
        }
        return count;
    }

    private boolean isMapValid(){
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

        //Not matrix bounds
        for(int i = 0; i < n; i++){
            if(map[i].length != m){
                return false;
            }
        }
        return true;
    }

    private void processLand(int i, int j){
        boolean test = true;
        test &= isClosedFromRightLand(i, j);
        test &= isClosedFromBottomLand(i, j);
        test &= isClosedFromLeftLand(i, j);
        test &= isClosedFromTopLand(i, j);
        test &= land.isClosed();
        land.setClosed(test);
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
            int land = map[i][j];
            if(land == 0 || tracer.isLandVisited(i,j)){
                return true;
            }
            if(land == 1){
                tracer.getRoute().add(new Location(i, j));
                return true;
            }
        }
        catch(IndexOutOfBoundsException ex){
            return false;
        }
        return false;
    }
}
