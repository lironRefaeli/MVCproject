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

    /**
     * this method is used to get the row's index
     * @return the index of the row
     */
    public int getRowIndex(){
       return this.rowIndex;
    }

    /**
     * this method is used to get the column's index
     * @return the index of the column
     */
    public int getColumnIndex(){
        return this.columnIndex;
    }

    @Override
    public String toString() {
        return String.format(this.rowIndex + ", " + this.columnIndex);
    }
}
