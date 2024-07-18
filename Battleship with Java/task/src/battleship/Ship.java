package battleship;

public class Ship {
    String[] shipLength;

    CoordinatesShip coordinatesShip;
    ShipModel modelShip;

    public Ship(CoordinatesShip coordinatesShip, ShipModel modelShip) {
        this.coordinatesShip = coordinatesShip;
        this.modelShip = modelShip;

        shipLength = new String[modelShip.shipLength];
        for (int i = 0; i < shipLength.length; i++) {
            if (coordinatesShip.startRow == coordinatesShip.endRow) {// if the start and end row are the same (tel up columns)
                int temp = coordinatesShip.minCol + i + 1;
                shipLength[i] = (char) (coordinatesShip.startRow + 'A') + String.valueOf(temp);
            } else if (coordinatesShip.startCol == coordinatesShip.endCol) {// if the letters of columns are the same (tel up row)
                int temp = coordinatesShip.startRow;
                shipLength[i] = (char) (temp + 'A') + String.valueOf(coordinatesShip.startCol);
            }
        }

    }
}
