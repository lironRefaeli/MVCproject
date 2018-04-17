package algorithms.mazeGenerators;

/**
 * This class represents the position of the player in a maze
 */
public class Position {

    int rowIndex;
    int columnIndex;

    public Position(int rowNumber, int columnNumber) {
        this.rowIndex = rowNumber;
        this.columnIndex = columnNumber;
    }

    public int getRowIndex(){
       return this.rowIndex;
    }

    public int getColumnIndex(){
        return this.columnIndex;
    }

    @Override
    public String toString() {
        return String.format(this.rowIndex + ", " + this.columnIndex);
    }
}
