package battleship;

public class CoordinatesShip {
    String start;
    String end;
    String coordinates;
    int startRow;
    int endRow;
    int startCol;
    int endCol;
    int maxCol;
    int minCol;
    int maxRow;
    int minRow;
    static int length = 0;

    public CoordinatesShip(String coordinates) {
        this.coordinates = coordinates;
        String regex = " ";
        String[] coordinatesArray = coordinates.split(regex);
        start = coordinatesArray[0];
        end = coordinatesArray[1];

        startRow = start.charAt(0) - 'A';//row from start coordinate
        endRow = end.charAt(0) - 'A'; //row from end coordinate
        startCol = Integer.parseInt(start.substring(1)) - 1; //column from start coordinate
        endCol = Integer.parseInt(end.substring(1)) - 1; //column from end coordinate

        length = (startRow == endRow) ? Math.abs(startCol - endCol) + 1 : Math.abs(startRow - endRow) + 1;

        maxCol = Math.max(startCol, endCol); //the max column
        minCol = Math.min(startCol, endCol); // the min column
        maxRow = Math.max(startRow, endRow); //the max row
        minRow = Math.min(startRow, endRow); // the min row


    }

    public int getMaxCol() {
        return maxCol;
    }

    public int getMinCol() {
        return minCol;
    }

    public int getMaxRow() {
        return maxRow;
    }

    public int getMinRow() {
        return minRow;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public int getEndCol() {
        return endCol;
    }


}
