package algorithms.mazeGenerators;

import java.util.Arrays;

/**
 <h1>maze class</h1>
 The concrete class is representing the maze object.
 @author refaeli.liron
 @since 2018-04-17
 */
public class Maze {

    private int m_rows;
    private int m_columns;
    private int[][]m_maze;
    private Position startPosition;
    private Position goalPosition;

    public Maze(int row, int column, Position start, Position goal) {
        this.m_rows=row;
        this.m_columns=column;
        this.m_maze= new int[m_rows][m_columns];
        this.startPosition=start;
        this.goalPosition=goal;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                m_maze[i][j] = 1;
            }

        }
    }

    public int getM_rows() {
        return m_rows;
    }

    public int getM_columns() {
        return m_columns;
    }

    public int[][] getM_maze(){ return this.m_maze; }

    /**
     * this method is used to get the start position of the maze
     * @return start position
     */
    public Position getStartPosition() {
        return startPosition;
    }

    /**
     *this method is used to get the goal position of the maze
     * @return goal position
     */
    public Position getGoalPosition() {
        return goalPosition;
    }

    /**
     * this method is used to print the maze
     */
    public void print(){
        for(int i = 0; i<m_rows; i++)
        {
            for(int j = 0; j<m_columns; j++)
            {
                if(i==startPosition.getRowIndex() && j==startPosition.getColumnIndex())
                    System.out.print("S");
                else if(i==goalPosition.getRowIndex() && j==goalPosition.getColumnIndex())
                    System.out.print("E");
                else
                    System.out.print(m_maze[i][j]);
            }
            System.out.println();
        }
    }
}
