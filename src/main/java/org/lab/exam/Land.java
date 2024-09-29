package org.lab.exam;

public class Land {
    private boolean isClosed = true;
    private Location start;

    public Land(Location start){
        this.isClosed = true;
        this.start = start;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }
}
