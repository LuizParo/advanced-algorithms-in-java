package maze_problem;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
    private final int[][] map;
    private final String fileName;
    private final int numberOfRows;
    private final int numberOfColumns;
    private int startPositionRow;
    private int startPositionCol;
    
    public FileReader(String fileName, int numberOfRows, int numberOfColumns) {
        this.fileName = fileName;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.map = new int[numberOfRows][numberOfColumns];
    }
    
    public void parseFile() {
        try(Scanner scanner = new Scanner(this.getFile())) {
            
            for(int i = 0; i < this.numberOfRows; i++) {
                for (int j = 0; j < this.numberOfColumns; j++) {
                    this.map[i][j] = scanner.nextInt();
                    
                    if(this.map[i][j] == 2) {
                        this.startPositionRow = i;
                        this.startPositionCol = j;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private File getFile() {
        ClassLoader classLoader = FileReader.class.getClassLoader();
        return new File(classLoader.getResource(this.fileName).getFile());
    }
    
    public int[][] getMap() {
        return map;
    }

    public String getFileName() {
        return fileName;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getStartPositionRow() {
        return startPositionRow;
    }

    public int getStartPositionCol() {
        return startPositionCol;
    }
}