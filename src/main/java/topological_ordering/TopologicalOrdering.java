package topological_ordering;

import java.util.ArrayDeque;
import java.util.Deque;

public class TopologicalOrdering {
    private Deque<Vertex> stack = new ArrayDeque<>();
    
    public void search(Vertex vertex) {
        vertex.setVisited(true);
        
        vertex.getNeighbours().forEach(neighbour -> {
            if(!neighbour.isVisited()) {
                this.search(neighbour);
            }
        });
        
        this.stack.push(vertex);
    }
    
    public Deque<Vertex> getStack() {
        return stack;
    }
}