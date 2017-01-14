package depth_first_serch;

import java.util.List;

public class DepthFirstSearchWithRecursion {

    public void search(final List<Vertex> cluster) {
        cluster.forEach(vertex -> {
            if(!vertex.isVisited()) {
                this.searchWithRecursion(vertex);
            }
        });
    }

    private void searchWithRecursion(Vertex vertex) {
        System.out.print(vertex + " ");
        
        vertex.getNeighbours().forEach(neighbour -> {
            if(!neighbour.isVisited()) {
                neighbour.setVisited(true);
                searchWithRecursion(neighbour);
            }
        });
    }
}