package battleship;
import java.io.*;
import java.util.Scanner;

public class Field {
    final int size = 10;
    String[][] field = new String[size][size];
    Ship[] ships = new Ship[ShipModel.values().length];


        public void printGame() {
        //print column

        //print row
        String ch = "A";
        int i = ch.charAt(0) + 10;
        for (int row = ch.charAt(0); row < i; row++) {
            for (int col = 0; col < size; col++) {
                field[row - ch.charAt(0)][col] = Area.FOG_OF_WAR.symbol;
            }
        }
        printShip(false);

    }

    public void placeShipOnField(int row, int col) {
        field[row][col] = Area.SHIP.toString();
    }

    public void printShip(boolean isHidden) {
        //print column
        System.out.print("  ");
        for (int col = 1; col <= size; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        //print ro+-w
        String ch = "A";
        int i = ch.charAt(0) + 10;
        for (int row = ch.charAt(0); row < i; row++) {
            System.out.print((char) row + " ");
            for (int col = 0; col < size; col++) {
                if (isHidden && field[row - ch.charAt(0)][col].equals(Area.SHIP.symbol)) {
                    System.out.print("~ ");
                } else {
                    System.out.print(field[row - ch.charAt(0)][col] + " ");
                }
            }
            System.out.print("\n");
        }
        System.out.println();
    }

    public Ship getShipAt(int row, int col) {
            //go through each ship in ships and find
    }

    public boolean isShipSunk(Ship ship) {
            //go through each coordinate in ship and look on field if it has been hit
    }

    public void addShip(Ship ship) {
        ships[ship.modelShip.ordinal()] = ship;
    }
}



