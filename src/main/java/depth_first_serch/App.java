package depth_first_serch;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        dfsWithStack();
        System.out.println();
        dfsWithRecursion();
    }

    private static void dfsWithStack() {
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        
        v1.addNeighbour(v2);
        v1.addNeighbour(v3);
        v3.addNeighbour(v4);
        v4.addNeighbour(v5);
        
        DepthFirstSearchWithStack dfs = new DepthFirstSearchWithStack();
        dfs.search(Arrays.asList(v1, v2, v3, v4, v5));
    }
    
    private static void dfsWithRecursion() {
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        
        v1.addNeighbour(v2);
        v1.addNeighbour(v3);
        v3.addNeighbour(v4);
        v4.addNeighbour(v5);
        
        DepthFirstSearchWithRecursion dfs = new DepthFirstSearchWithRecursion();
        dfs.search(Arrays.asList(v1, v2, v3, v4, v5));
    }
}