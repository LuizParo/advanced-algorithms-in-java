package topological_ordering;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Vertex {
    private final String data;
    private boolean visited;
    private Collection<Vertex> neighbours = new ArrayList<>();
    
    public Vertex(String data) {
        this.data = data;
    }
    
    public String getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Collection<Vertex> getNeighbours() {
        return Collections.unmodifiableCollection(neighbours);
    }
    
    public void addNeighbour(Vertex vertex) {
        this.neighbours.add(vertex);
    }
    
    @Override
    public String toString() {
        return this.data;
    }
}