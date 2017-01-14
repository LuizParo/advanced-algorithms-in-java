package maze_problem;

public class App {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader("maze.txt", 7, 7);
        fileReader.parseFile();
        
        MazeResolver mazeResolver = new MazeResolver(fileReader.getMap(), fileReader.getStartPositionRow(), fileReader.getStartPositionCol());
        mazeResolver.findWayOut();
    }
}