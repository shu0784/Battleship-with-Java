package battleship;

public enum ShipModel {
    AIRCRAFT(5, "Aircraft Carrier"),
    BATTLESHIP(4, "Battleship"),
    SUBMARINE(3, "Submarine"),
    CRUISER(3, "Cruiser"),
    DESTROYER(2, "Destroyer");

    final int shipLength;
    final String shipName;

    ShipModel(int shipLength, String shipName) {
        this.shipLength = shipLength;
        this.shipName = shipName;
    }

    public int getLength() {
        return shipLength;
    }

    public String getShipName() { return shipName; }

    public int getLengthByName(String shipName) { return shipLength; }

}
