package depth_first_serch;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class DepthFirstSearchWithStack {
    private final Deque<Vertex> stack = new ArrayDeque<>();

    public void search(final List<Vertex> clusters) {
        clusters.forEach(vertex -> {
            if(!vertex.isVisited()) {
                this.searchWithStack(vertex);
            }
        });
    }

    private void searchWithStack(Vertex rootVertex) {
        this.stack.add(rootVertex);
        rootVertex.setVisited(true);
        
        while(!this.stack.isEmpty()) {
            Vertex actualVertex = this.stack.pop();
            System.out.print(actualVertex + " ");
            
            actualVertex.getNeighbours().forEach(neighbour -> {
                if(!neighbour.isVisited()) {
                    neighbour.setVisited(true);
                    this.stack.push(neighbour);
                }
            });
        }
    }
}