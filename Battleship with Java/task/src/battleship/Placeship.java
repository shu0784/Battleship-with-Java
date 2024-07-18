package battleship;

public class Placeship {
    String start;
    String end;
    String coordinates;


    public void shipLength(String coordinates) {
        this.coordinates = coordinates;
        String regex= " ";
        String[] coordinatesArray = coordinates.split(regex);
        String start = coordinatesArray[0];
        String end = coordinatesArray[1];
        int lengthOfField = PrintField.size;
        int startRow = start.charAt(0) - 'A' ;//row from start coordinate
        int endRow = end.charAt(0) - 'A'; //row from end coordinate
        int startCol = (start.length()== 2) ? Integer.parseInt(start.substring(1, 2)) : Integer.parseInt(start.substring(1, 3)); //column from start coordinate
        int endCol = (end.length() == 2) ? Integer.parseInt(end.substring(1, 2)) : Integer.parseInt(end.substring(1, 3)); //column from end coordinate

        int maxCol = Math.max(startCol, endCol); //the max column
        int minCol = Math.min(startCol, endCol); // the min column
        int maxRow = Math.max(startRow, endRow); //the max row
        int minRow = Math.min(startRow, endRow); // the min row

        int count = 0;
        boolean correctCoordinates = false;
        String result = "";

        //check for error if columns or rows is more or less than field size
        if (startRow < 0 || startRow > lengthOfField || endRow < 0 || endRow > lengthOfField
                || startCol <= 0 || startCol >= lengthOfField || endCol < 0 || endCol > lengthOfField) {
            correctCoordinates = true;
            isCoordinatesCorrect(correctCoordinates);
        } else {
            //print length and parts
            //print parts of ship
            int length = (startRow == endRow) ? Math.abs(startCol - endCol) + 1: Math.abs(startRow - endRow) + 1;
            if(startRow == endRow) {//horizontal
                System.out.print("Length: " + length +"\nParts: ");
                for (int col = minCol; col <= maxCol; col++) {
                    System.out.print((char) ('A' + startRow) + "" + (col) + " ");
                }

            } else if (startCol == endCol) {//vertical
                System.out.print("Length: " + length +"\nParts: ");
                for (int row = minRow; row <= maxRow; row++) {
                   System.out.print((char) ('A' + row) + "" + (startCol) + " ");

                }

            } else {//diagonal
                correctCoordinates = true;
                isCoordinatesCorrect(correctCoordinates);
            }
        }
    }

    public void isCoordinatesCorrect(boolean b) {
        if (b) {
            //print error message
            System.out.println("Error!");
        }
    }

//    public void getLength(int length) {
//        //print the length
//        System.out.println("Length: " + length + "\nPart: ");
//    }
}
