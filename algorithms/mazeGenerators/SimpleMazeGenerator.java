package algorithms.mazeGenerators;

/**
 * Creating a simple random maze, having a fixed correct path from the
 * startPosition to the end Position
 * @since 17.4.18
 */

public class SimpleMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int numOfRows, int numOfColumns) {
        Position startPosition = new Position(0, 0);
        Position endPosition = new Position(numOfRows-1, numOfColumns-1);
        Maze myMaze = new Maze(numOfRows, numOfColumns, startPosition, endPosition);
        generatingPath(myMaze, numOfRows, numOfColumns);
        generateRandomly(myMaze, numOfRows, numOfColumns);

        return myMaze;
    }

    /**
     * Creating the fixed correct path from S to E
     * @param myMaze
     * @param numOfRows
     * @param numOfColumns
     */
    private void generatingPath(Maze myMaze, int numOfRows, int numOfColumns) {
        for(int i = 0; i < numOfRows/2; i++){
            myMaze.getM_maze()[i][0] = 0;
        }
        for(int i = 0; i < numOfColumns; i++){
            myMaze.getM_maze()[numOfRows/2 - 1][i] = 0;
        }
        for(int i = numOfRows/2; i < numOfRows; i++){
            myMaze.getM_maze()[i][numOfColumns - 1] = 0;
        }
    }

    /**
     * Choose a value of 0(not wall) or 1(wall) for cell,
     * but the cells that represent the path
     * @param myMaze
     * @param numOfRows
     * @param numOfColumns
     */
    private void generateRandomly(Maze myMaze, int numOfRows, int numOfColumns) {
        for(int i = 0; i < numOfRows; i++){
            for (int j = 0; j < numOfColumns; j++){
                if(myMaze.getM_maze()[i][j] != 0){
                    if(Math.random() < 0.5)
                        myMaze.getM_maze()[i][j] = 0;
                    else
                        myMaze.getM_maze()[i][j] = 1;
                }
            }
        }
    }
    //just a way to check that this class works fine
    public static void main(String[] args) {
        IMazeGenerator simpleMazeGenerator = new MyMazeGenerator();
        long estimatedTime = simpleMazeGenerator.measureAlgorithmTimeMillis(1000, 1000);
        System.out.println(estimatedTime);
        // Maze maze = myMazeGenerator.generate(10,10);
        // maze.print();
    }
}
