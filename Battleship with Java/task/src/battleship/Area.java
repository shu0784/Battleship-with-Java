package battleship;

public enum Area {
    FOG_OF_WAR("~"),
    SHIP("O"),
    HIT("X"),
    MISS("M");

    final String symbol;

    Area(String symbol) {
        this.symbol = symbol;
    }

    boolean isEmpty() {
        return this.compareTo(FOG_OF_WAR) == 0;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
