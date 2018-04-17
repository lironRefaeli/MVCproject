/**
 * This interface is responsible for defining the methods
 * for the concrete classes that are going to create the mazes for us
 * @author david rosenberg
 * @since 17.4.18
 */

package algorithms.mazeGenerators;

public interface IMazeGenerator {

    /**
     * generate method creates the mazes
     * @param numOfRows
     * @param numOfColumns
     * @return Maze object
     */
    Maze generate(int numOfRows, int numOfColumns);

    /**
     * measureAlgorithmTimeMilles method measures how much time it takes
     * to create a single maze in milli seconds
     * @param numOfRows
     * @param numOfColumns
     * @return long
     */
    long measureAlgorithmTimeMillis(int numOfRows, int numOfColumns);


}
