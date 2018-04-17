package algorithms.mazeGenerators;

import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {


    @Override
    public Maze generate(int numOfRows, int numOfColumns) {

        Position startPosition=getRandomStartPosition(numOfRows);
        Position goalPosition=getRandomGoalPosition(numOfColumns);
        Maze m_maze=new Maze(numOfRows,numOfColumns,startPosition,goalPosition);

        return m_maze;
    }

    private Position getRandomStartPosition(int numOfRows)
    {
        Random rand = new Random();
        int randomStart= rand.nextInt(numOfRows-1);
        Position startPosition=new Position(randomStart,0);
        return startPosition;

    }

    private Position getRandomGoalPosition(int numOfColumns)
    {
        Random rand = new Random();
        int randomGoal= rand.nextInt(numOfColumns-1);
        Position goalPosition=new Position(randomGoal,numOfColumns-1);
        return goalPosition;
    }

    private Maze generatingPath(Maze maze)
    {

    }

    private boolean isOutOfBounds(int row, int col, Maze maze) {
        return (row < 0 || col < 0 || row >= maze || col >= numOfColumns);
    };
}
