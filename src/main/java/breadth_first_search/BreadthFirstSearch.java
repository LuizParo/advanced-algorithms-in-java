package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public void search(Vertex root) {
        final Queue<Vertex> queue = new LinkedList<>();
        root.setVisited(true);
        queue.add(root);

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();

            System.out.println(vertex);

            vertex.getNeighbours().forEach(neighbour -> {
                if(!neighbour.isVisited()) {
                    neighbour.setVisited(true);
                    queue.add(neighbour);
                }
            });
        }
    }
}