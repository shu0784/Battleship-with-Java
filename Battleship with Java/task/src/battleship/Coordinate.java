package battleship;

public class Coordinate {
    int row;
    int col;
    String coordinate;



    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Coordinate(String coordinate) {
        this.coordinate = coordinate;
        row = coordinate.charAt(0) - 'A';//row from start coordinate
        col = Integer.parseInt(coordinate.substring(1)) - 1;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }



}
