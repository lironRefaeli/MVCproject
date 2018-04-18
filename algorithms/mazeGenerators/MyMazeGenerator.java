package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;



public class MyMazeGenerator extends AMazeGenerator {

    public static void main(String[] args) {
        IMazeGenerator myMazeGenerator = new MyMazeGenerator();
        // long estimatedTime = simpleMazeGenerator.measureAlgorithmTimeMillis(1000, 1000);
        // System.out.println(estimatedTime);
        Maze maze = myMazeGenerator.generate(6,6);
        maze.print();
    }

    @Override
    public Maze generate(int numOfRows, int numOfColumns) {

        Position startPosition=getRandomStartPosition(numOfRows);
        Position goalPosition=getRandomGoalPosition(numOfColumns);
        Maze m_maze=new Maze(numOfRows,numOfColumns,startPosition,goalPosition);
        m_maze=generatingPath(m_maze);
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
        Position current=maze.getStartPosition();
        maze.getM_maze()[current.getRowIndex()][current.getColumnIndex()]=0;

        Position choosen;
        List<Position> currentNeighbors;
        Stack<Position> alternativePath=new Stack<Position>();

        //while the goalPosition cell is unvisited
        while(maze.getM_maze()[maze.getGoalPosition().getRowIndex()][maze.getGoalPosition().getColumnIndex()]==1)
        {
            currentNeighbors=findNeighbors(maze,current);



            if(currentNeighbors.size()!=0) {

                if(currentNeighbors.size()!=1) {
                    Random rand = new Random();
                    int randomNeighbor = rand.nextInt(currentNeighbors.size() - 1);
                    choosen = currentNeighbors.get(randomNeighbor);

                }
                else
                {
                    choosen = currentNeighbors.get(0);
                }
                alternativePath.push(current);
                maze.getM_maze()[choosen.getRowIndex()][choosen.getColumnIndex()]=0;
                current=choosen;

            }
            else
            {
                current=alternativePath.pop();
            }


        }

        return maze;
    }

    private List<Position> findNeighbors(Maze maze,Position current)
    {
        List<Position> neighborsList = new ArrayList<>();



            if(!isOutOfBounds(current.getRowIndex()-1,current.getColumnIndex(),maze))
            {
                if(maze.getM_maze()[current.getRowIndex()-1][current.getColumnIndex()]==1)
                {
                    Position p=new Position(current.getRowIndex()-1,current.getColumnIndex());
                    neighborsList.add(p);
                }
            }
             if(!isOutOfBounds(current.getRowIndex()+1,current.getColumnIndex(),maze))
            {
                if(maze.getM_maze()[current.getRowIndex()+1][current.getColumnIndex()]==1) {
                    Position p = new Position(current.getRowIndex() + 1, current.getColumnIndex());
                    neighborsList.add(p);
                }
            }
             if(!isOutOfBounds(current.getRowIndex(),current.getColumnIndex()-1,maze)) {
                 if (maze.getM_maze()[current.getRowIndex()][current.getColumnIndex() - 1] == 1) {
                     Position p = new Position(current.getRowIndex(), current.getColumnIndex() - 1);
                     neighborsList.add(p);
                 }
             }
             if(!isOutOfBounds(current.getRowIndex(),current.getColumnIndex()+1,maze)) {
                 if (maze.getM_maze()[current.getRowIndex()][current.getColumnIndex() + 1] == 1) {
                     Position p = new Position(current.getRowIndex(), current.getColumnIndex() + 1);
                     neighborsList.add(p);
                 }
             }


        return neighborsList;
    }
    private boolean isOutOfBounds(int row, int col, Maze maze) {
        return (row < 0 || col < 0 || row >= maze.getM_rows()|| col >= maze.getM_columns());
    }
}
