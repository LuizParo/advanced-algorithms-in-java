package maze_problem;

public class MazeResolver {
    private final int[][] maze;
    private final boolean visited[][];
    private final int startPositionRow;
    private final int startPositionCol;

    public MazeResolver(int[][] maze, int startPositionRow, int startPositionCol) {
        this.maze = maze;
        this.visited = new boolean[maze.length][maze.length];
        this.startPositionRow = startPositionRow;
        this.startPositionCol = startPositionCol;
    }

    public void findWayOut() {
        try {
            this.depthFirstSearch(this.startPositionRow, this.startPositionCol);
            throw new NoSoutionFoundException("No solution found...");
        } catch (FoundWayOutException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private void depthFirstSearch(int rowIndex, int colIndex) {
        System.out.println(String.format("\nVisiting i = %d, j = %d", rowIndex, colIndex));
        int endOfMap = this.maze.length - 1;
        
        if(this.maze[rowIndex][colIndex] == 3) {
            throw new FoundWayOutException("Route found to exit");
        }
        
        if(this.visited[rowIndex][colIndex]) {
            System.out.println(String.format("i = %d, j = %d already visited!", rowIndex, colIndex));
            return;
        } 
        
        if(rowIndex < 0 || rowIndex >= endOfMap) {
            System.out.println(String.format("i = %d out of map!", rowIndex));
            return;
        } 
        
        if(colIndex < 0 || colIndex >= endOfMap) {
            System.out.println(String.format("j = %d out of map!", colIndex));
            return;
        }
        
        if(this.maze[rowIndex][colIndex] == 1) {
            System.out.println(String.format("i = %d, j = %d hit the wall!", rowIndex, colIndex));
            return;
        }
        
        this.visited[rowIndex][colIndex] = true;
        
        this.depthFirstSearch(rowIndex + 1, colIndex); // further down
        this.depthFirstSearch(rowIndex, colIndex + 1); // further right
        this.depthFirstSearch(rowIndex, colIndex - 1); // further left
        this.depthFirstSearch(rowIndex - 1, colIndex); // further up
    }
}