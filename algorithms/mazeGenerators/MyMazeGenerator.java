package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;



public class MyMazeGenerator extends AMazeGenerator {

    public static void main(String[] args) {
        IMazeGenerator myMazeGenerator = new MyMazeGenerator();
         long estimatedTime = myMazeGenerator.measureAlgorithmTimeMillis(1000, 1000);
         System.out.println(estimatedTime);
        Maze maze = myMazeGenerator.generate(10,10);
        maze.print();
    }

    @Override
    public Maze generate(int numOfRows, int numOfColumns) {

        Position startPosition = getRandomStartPosition(numOfRows);
        Position goalPosition=getRandomGoalPosition(numOfColumns);
        Maze m_maze=new Maze(numOfRows,numOfColumns,startPosition,goalPosition);
        generatingPath(m_maze);
        generateRandomly(m_maze);
        return m_maze;
    }

    private void generateRandomly(Maze maze) {
        for (int i = 0; i < maze.getM_rows(); i++) {
            for (int j = 0; j < maze.getM_columns(); j++) {
                if (maze.getM_maze()[i][j] != 0) {
                    if (Math.random() < 0.2)
                        maze.getM_maze()[i][j] = 0;
                    else
                        maze.getM_maze()[i][j] = 1;
                }
            }
        }

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

    private int getCellValue(Maze maze, int row, int col)
    {
        return maze.getM_maze()[row][col];
    }

    private void generatingPath(Maze maze)
    {
        Position current=maze.getStartPosition();
        maze.getM_maze()[current.getRowIndex()][current.getColumnIndex()] = 0;

        Position chosen;
        List<Position> currentNeighbors;
        Stack<Position> alternativePath = new Stack<>();

        //while the goalPosition cell is unvisited
        while(maze.getM_maze()[maze.getGoalPosition().getRowIndex()][maze.getGoalPosition().getColumnIndex()] == 1)
        {
            chosen = null;
            currentNeighbors=findNeighbors(maze,current);

            if(currentNeighbors.size()!=0) {

                for(int i = 0; i < currentNeighbors.size(); i++){
                    if(currentNeighbors.get(i).isEqual(maze.getGoalPosition())){
                        chosen = maze.getGoalPosition();
                        break;
                    }
                }

                if(chosen == null) {
                    int randomNeighbor = (int) (Math.random() * (currentNeighbors.size()));
                    chosen = currentNeighbors.get(randomNeighbor);
                  //  System.out.println(randomNeighbor);
                }


                alternativePath.push(current);
                maze.getM_maze()[chosen.getRowIndex()][chosen.getColumnIndex()]=0;
                current=chosen;
              //  System.out.println("**************");
              //  maze.print();
               // System.out.println("**************");

            }
            else
            {
                current=alternativePath.pop();
            }

        }

    }

    private List<Position> findNeighbors(Maze maze,Position current)
    {
        List<Position> neighborsList = new ArrayList<>();
        boolean isAvailable;

            if (!isOutOfBounds(current.getRowIndex(), current.getColumnIndex() + 1, maze)) {
                isAvailable=true;
                if (maze.getM_maze()[current.getRowIndex()][current.getColumnIndex() + 1] == 1) {

                    if(!isOutOfBounds(current.getRowIndex()-1, current.getColumnIndex() + 1, maze))
                    {
                        if(getCellValue(maze,current.getRowIndex()-1, current.getColumnIndex() + 1 )!=1)
                            isAvailable=false;
                    }

                    if(isAvailable && !isOutOfBounds(current.getRowIndex()+1, current.getColumnIndex() + 1, maze))
                    {
                        if(getCellValue(maze,current.getRowIndex()+1, current.getColumnIndex() + 1 )!=1)
                            isAvailable=false;
                    }

                    if(isAvailable && !isOutOfBounds(current.getRowIndex(), current.getColumnIndex() + 2, maze))
                    {
                        if(getCellValue(maze,current.getRowIndex(), current.getColumnIndex() + 2 )!=1)
                            isAvailable=false;
                    }

                    if(isAvailable) {
                        Position p = new Position(current.getRowIndex(), current.getColumnIndex() + 1);
                        neighborsList.add(p);
                    }

                }
            }


            if (!isOutOfBounds(current.getRowIndex() - 1, current.getColumnIndex(), maze)) {
               isAvailable=true;

                if (maze.getM_maze()[current.getRowIndex() - 1][current.getColumnIndex()] == 1) {

                    if(!isOutOfBounds(current.getRowIndex()-1, current.getColumnIndex() + 1, maze))
                    {
                        if(getCellValue(maze,current.getRowIndex()-1, current.getColumnIndex() + 1 )!=1)
                            isAvailable=false;
                    }

                    if(isAvailable && !isOutOfBounds(current.getRowIndex()-1, current.getColumnIndex() - 1, maze))
                    {
                        if(getCellValue(maze,current.getRowIndex()-1, current.getColumnIndex() - 1 )!=1)
                            isAvailable=false;
                    }

                    if(isAvailable && !isOutOfBounds(current.getRowIndex()-2, current.getColumnIndex() , maze))
                    {
                        if(getCellValue(maze,current.getRowIndex()-2, current.getColumnIndex() )!=1)
                            isAvailable=false;
                    }

                    if(isAvailable) {
                        Position p = new Position(current.getRowIndex() - 1, current.getColumnIndex());
                        neighborsList.add(p);
                    }
                }
            }



            if (!isOutOfBounds(current.getRowIndex() + 1, current.getColumnIndex(), maze)) {
                isAvailable=true;

                if (maze.getM_maze()[current.getRowIndex() + 1][current.getColumnIndex()] == 1) {

                    if(!isOutOfBounds(current.getRowIndex()+1, current.getColumnIndex()-1 , maze))
                    {
                        if(getCellValue(maze,current.getRowIndex()+1, current.getColumnIndex()-1 )!=1)
                            isAvailable=false;
                    }

                    if(isAvailable && !isOutOfBounds(current.getRowIndex()+1, current.getColumnIndex()+1 , maze))
                    {
                        if(getCellValue(maze,current.getRowIndex()+1, current.getColumnIndex()+1 )!=1)
                            isAvailable=false;
                    }

                    if(isAvailable && !isOutOfBounds(current.getRowIndex()+2, current.getColumnIndex() , maze))
                    {
                        if(getCellValue(maze,current.getRowIndex()+2, current.getColumnIndex() )!=1)
                            isAvailable=false;
                    }
                   if(isAvailable) {
                       Position p = new Position(current.getRowIndex() + 1, current.getColumnIndex());
                       neighborsList.add(p);
                   }
                }
            }


            if (!isOutOfBounds(current.getRowIndex(), current.getColumnIndex() - 1, maze)) {
               isAvailable=true;
                if (maze.getM_maze()[current.getRowIndex()][current.getColumnIndex() - 1] == 1) {

                    if(!isOutOfBounds(current.getRowIndex()-1, current.getColumnIndex()-1 , maze))
                    {
                        if(getCellValue(maze,current.getRowIndex()-1, current.getColumnIndex()-1 )!=1)
                            isAvailable=false;

                    }

                    if(isAvailable && !isOutOfBounds(current.getRowIndex()+1, current.getColumnIndex()-1 , maze))
                    {
                        if(getCellValue(maze,current.getRowIndex()+1, current.getColumnIndex()-1 )!=1)
                            isAvailable=false;

                    }

                    if(!isOutOfBounds(current.getRowIndex(), current.getColumnIndex()-2 , maze))
                    {
                        if(getCellValue(maze,current.getRowIndex(), current.getColumnIndex()-2 )!=1)
                            isAvailable=false;

                    }


                   if(isAvailable) {
                       Position p = new Position(current.getRowIndex(), current.getColumnIndex() - 1);
                       neighborsList.add(p);
                   }
                }
            }




        return neighborsList;
    }
    private boolean isOutOfBounds(int row, int col, Maze maze) {
        return (row < 0 || col < 0 || row >= maze.getM_rows()|| col >= maze.getM_columns());
    }
}