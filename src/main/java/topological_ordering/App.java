package topological_ordering;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class App {

    public static void main(String[] args) {
        TopologicalOrdering topologicalOrdering = new TopologicalOrdering();
        
        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        
        v2.addNeighbour(v3);
        v3.addNeighbour(v1);
        v4.addNeighbour(v0);
        v4.addNeighbour(v1);
        v5.addNeighbour(v0);
        v5.addNeighbour(v2);
        
        List<Vertex> graph = Arrays.asList(v0, v1, v2, v3, v4, v5);
        graph.forEach(vertex -> {
            if(!vertex.isVisited()) {
                topologicalOrdering.search(vertex);
            }
        });
        
        Deque<Vertex> stack = topologicalOrdering.getStack();
        stack.forEach(System.out::println);
    }
}