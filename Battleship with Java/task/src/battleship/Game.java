package battleship;

import java.util.Scanner;

public class Game {
    CoordinatesShip coordinatesShip;
    Field field;
    Scanner sc = new Scanner(System.in);

    public Game(Field field) {
        this.field = field;
    }

    public boolean isOutOfBounds(int startRow, int endRow, int startCol, int endCol) {
        int lengthOfField = PrintField.size;
        //check for error if columns or rows is more or less than field size
        if (startRow < 0 || startRow >= lengthOfField || endRow < 0 || endRow >= lengthOfField
                || startCol < 0 || startCol >= lengthOfField || endCol < 0 || endCol >= lengthOfField) {
            return true;
        } else if (startRow != endRow && startCol != endCol) {
            return true;
        }
        return false;
    }

    public void enterShip() {
        boolean check; //= true;
        int length = 0; //= Ship.length;

        for (ShipModel modelShip : ShipModel.values()) {
            check = true;
            System.out.printf("Enter the coordinates of the %s (%d cells): ", modelShip.shipName, modelShip.shipLength);
            Ship ship = null;
            while (check) {
                String coordinates = sc.nextLine();
                coordinatesShip = new CoordinatesShip(coordinates.toUpperCase());
                ship = new Ship(coordinatesShip, modelShip);
                if (isOutOfBounds(coordinatesShip.startRow, coordinatesShip.endRow, coordinatesShip.startCol, coordinatesShip.endCol)) {
                    System.out.println("Error! Wrong ship location! Try again:");
                    continue;
                }
                if (!shipPlacement(coordinatesShip.startRow, coordinatesShip.endRow, coordinatesShip.startCol, coordinatesShip.endCol)) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    continue;
                }

                if (coordinatesShip.startRow == coordinatesShip.endRow) {
                    length = coordinatesShip.maxCol - coordinatesShip.minCol + 1;
                } else if (coordinatesShip.startCol == coordinatesShip.endCol) {
                    length = coordinatesShip.maxRow - coordinatesShip.minRow + 1;
                }

                if (length == modelShip.shipLength) {
                    check = false;
                } else {
                    System.out.printf("Error! Wrong length of the %s! Try again:", modelShip.shipName);
                }

             }
            for (int i = coordinatesShip.minRow; i <= coordinatesShip.maxRow; i++) {
                for (int j = coordinatesShip.minCol; j <= coordinatesShip.maxCol; j++) {
                    field.placeShipOnField(i, j);
                }
            }
            field.addShip(ship);
            field.printShip(false);
        }
    }

    public boolean shipPlacement(int startRow, int endRow, int startCol, int endCol) {
        int lineAboveInput = Math.min(startRow, endRow) - 1;
        int lineBelowInput = Math.max(startRow, endRow) + 1;
        int rowLeft = Math.min(startCol, endCol) - 1;
        int rowRight = Math.max(startCol, endCol) + 1;

        for (int i = Math.max(0, lineAboveInput); i <= Math.min(9, lineBelowInput); i++) {
            for (int j = Math.max(0, rowLeft); j <= Math.min(9, rowRight); j++) {
                if (this.field.field[i][j].equals("O")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void gameStart() {
        System.out.println("The game starts!" +"\n");
        field.printShip(true);
        boolean gameStarted = true;

        while (gameStarted) {
            System.out.println("Take a shot!\n");
            String coordinates = sc.next();
            Coordinate coordinate = new Coordinate(coordinates.toUpperCase());
            if(isCorrectShotCoordinates(coordinate)) {
                System.out.println("Error! You entered the wrong coordinates! Try again: \n");
                continue;
            }
            if(isShipPosition(coordinate)) {
                field.field[coordinate.row][coordinate.col] = Area.HIT.symbol;
                field.printShip(true);
                //field.printShip(true);
                continue;
            } else {
                field.field[coordinate.row][coordinate.col] = Area.MISS.symbol;
                field.printShip(true);
                System.out.println("You missed!\n");
                //field.printShip(true);
                continue;
            }
        }
    }

    //check if you have a ship placed on the given coordinate if empty miss if there is ship
    // display miss
    public boolean isShipPosition(Coordinate coordinate) {
        return field.field[coordinate.row][coordinate.col].equals(Area.SHIP.symbol);
    }

    //check for errors out of bounds
    public boolean isCorrectShotCoordinates(Coordinate coordinate) {
        return coordinate.row < 0 || coordinate.row > field.size || coordinate.col < 0 || coordinate.col >= field.size;
    }



}






