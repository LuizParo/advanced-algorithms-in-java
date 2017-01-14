package depth_first_serch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vertex {
    private final String name;
    private final List<Vertex> neighbours = new ArrayList<>();
    private boolean visited;
    
    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Vertex> getNeighbours() {
        return Collections.unmodifiableList(this.neighbours);
    }
    
    public boolean isVisited() {
        return visited;
    }
    
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    public void addNeighbour(Vertex neighbour) {
        this.neighbours.add(neighbour);
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}