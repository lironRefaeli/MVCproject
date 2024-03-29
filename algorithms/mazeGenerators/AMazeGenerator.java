package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator {

    @Override
    abstract public Maze generate(int numOfRows, int numOfColumns);


    @Override
    public long measureAlgorithmTimeMillis(int numOfRows, int numOfColumns) {
        long startTime = System.currentTimeMillis();
        generate(numOfRows, numOfColumns);
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }
}
