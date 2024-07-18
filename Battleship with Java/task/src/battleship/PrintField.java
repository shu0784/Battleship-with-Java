package battleship;
import java.io.*;

public class PrintField {
    static int size = 10;

   public void printGame() {

       String[][] field = new String[size][size]; //size of field

       //print column
       System.out.print("  ");
       for (int col = 1; col <= size; col++ ) {
           System.out.print(col + " ");
       }
       System.out.println();

       //print row
       String ch = "A";
       int i = ch.charAt(0) + 10;
       for (int row = ch.charAt(0); row < i; row++) {
           System.out.print((char)row + " ");
           for (int col = 1; col <= size; col++ ) {
                System.out.print('~' + " ");
           }
           System.out.print("\n");
       }
       //System.out.println();

   }



}
