package cycle_detection;

public class CycleDetection {

    public void detectCycle(Iterable<Vertex> graph) {
        graph.forEach(vertex -> {
            if(!vertex.isVisited()) {
                this.depthFirstSearch(vertex);
            }
        });
    }

    private void depthFirstSearch(Vertex vertex) {
        System.out.println(String.format("\nDFS on vertex %s", vertex));
        vertex.setBeingVisited(true);
        
        System.out.println(String.format("Visiting the neighbours of %s", vertex));
        vertex.getNeighbours().forEach(neighbour -> {
            if(neighbour.isBeingVisited()) {
                System.out.println(String.format("There is a backward edge with vertex %s: so there is a cycle between vetexes %s and %s!!!",
                        neighbour,
                        vertex,
                        neighbour));
                
                return;
            }
            
            if(!neighbour.isVisited()) {
                System.out.println(String.format("Visiting vertex %s recursively...", neighbour));
                this.depthFirstSearch(neighbour);
            }
        });
        
        System.out.println(String.format("\nSet vertex %s setBeingVisited(false) and setVisited(true)...", vertex));
        vertex.setBeingVisited(false);
        vertex.setVisited(true);
    }
}