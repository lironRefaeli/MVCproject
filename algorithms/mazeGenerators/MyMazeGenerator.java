package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;


/**
 * This class represents a DFS maze generator.
 * The depth-first search algorithm of maze generation is frequently implemented using backtracking.
 * @since 18.4.18
 */
public class MyMazeGenerator extends AMazeGenerator {

    /*public static void main(String[] args) {
        IMazeGenerator myMazeGenerator = new MyMazeGenerator();
         long estimatedTime = myMazeGenerator.measureAlgorithmTimeMillis(1000, 1000);
         System.out.println(estimatedTime);
        Maze maze = myMazeGenerator.generate(10,10);
        maze.print();
    }
    */

    /**
     * This method gets the num of rows of the maze, and return random
     * position which is updated as the maze's start position.
     * @param numOfRows
     * @return start Position
     */
    private Position getRandomStartPosition(int numOfRows) {
        Random rand = new Random();
        int randomStart= rand.nextInt(numOfRows-1);
        Position startPosition=new Position(randomStart,0);
        return startPosition;

    }
    /**
     * This method gets the num of columns and rows of the maze, and return random
     * position which is updated as the maze's goal position.
     * @param numOfColumns
     * @param numOfRows
     * @return goal Position
     */
    private Position getRandomGoalPosition(int numOfRows,int numOfColumns) {
        Random rand = new Random();
        int randomGoal= rand.nextInt(numOfRows-1);
        Position goalPosition=new Position(randomGoal,numOfColumns-1);
        return goalPosition;
    }

    /**
     * This method gets a maze and position(num of row and column)
     * and return if the cell in the maze is free(the value:0), or if it's a wall(the value:1)
     * @param maze
     * @param row
     * @param col
     * @return 0 for free cell, 1 for a wall
     */
    private int getCellValue(Maze maze, int row, int col)
    {
        return maze.getM_maze()[row][col];
    }

    /**
     * This method checks if a given position(row and column) is out of the bounds of the maze.
     * @param row
     * @param col
     * @param maze
     * @return true for a cell which is out of bound.
     */
    private boolean isOutOfBounds(int row, int col, Maze maze) {
        return (row < 0 || col < 0 || row >= maze.getM_rows()|| col >= maze.getM_columns());
    }

    /**
     * This method return a list of positions which are neighbors of the current given position,
     * aren't a wall cells, and their location is in the maze's bounds.
     * This list is important for choosing random neighbor to develop the maze's path from the
     * current position to him.
     * @param maze
     * @param current
     * @return a list of positions
     */
    private List<Position> findNeighbors(Maze maze,Position current) {
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

    /**
     * This method is generating the path of the maze from the start position to the
     * goal position. the generation is done by DFS algorithm. The neighbors are chosen randomly.
     * @param maze
     */
    private void generatingPath(Maze maze) {
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

    /**
     * This method is spreading randomly 0 and 1 on the blocked cells in the maze,
     * in order to make the maze more difficult to solve.
     * @param maze
     */
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


    /**
     *  This method gets num of rows and num of columns and return a maze
     *  In the method start position and goal position are choosen randomly.
     *  The maze includes a solution path from the start position to the end position.
     *  The path was generated by the DFS algorithm.
     * @param numOfRows
     * @param numOfColumns
     * @return maze
     */
    public Maze generate(int numOfRows, int numOfColumns) {

        Position startPosition = getRandomStartPosition(numOfRows);
        Position goalPosition=getRandomGoalPosition(numOfRows,numOfColumns);
        Maze m_maze=new Maze(numOfRows,numOfColumns,startPosition,goalPosition);
        generatingPath(m_maze);
        generateRandomly(m_maze);
        return m_maze;
    }


}