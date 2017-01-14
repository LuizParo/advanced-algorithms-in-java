package cycle_detection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Vertex {
    private final String data;
    private boolean beingVisited;
    private boolean visited;
    private Collection<Vertex> neighbours = new ArrayList<>();
    
    public Vertex(String data) {
        this.data = data;
    }
    
    public String getData() {
        return data;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Collection<Vertex> getNeighbours() {
        return Collections.unmodifiableCollection(this.neighbours);
    }
    
    public void addNeighbour(Vertex neighbour) {
        this.neighbours.add(neighbour);
    }
    
    @Override
    public String toString() {
        return this.data;
    }
}