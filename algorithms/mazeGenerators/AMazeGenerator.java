package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator {

    @Override
    abstract public Maze generate(int numOfRows, int numOfColumns);


    @Override
    public long measureAlgorithmTimeMilles(int numOfRows, int numOfColumns) {
        long startTime = System.currentTimeMillis();
        generate(numOfRows, numOfColumns);
        return (System.currentTimeMillis() - startTime);
    }
}
