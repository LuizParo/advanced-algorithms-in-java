package breadth_first_search;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private final int data;
    private boolean visited;
    private List<Vertex> neighbours = new ArrayList<>();

    public Vertex(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbours() {
        return new ArrayList<>(neighbours);
    }

    public void addNeighbour(Vertex vertex) {
        this.neighbours.add(vertex);
    }

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
}