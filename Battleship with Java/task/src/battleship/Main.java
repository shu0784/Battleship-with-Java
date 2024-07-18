package battleship;
import java.lang.*;;
public class Main {

    public static void main(String[] args) {

        Field field = new Field();
        field.printGame();
        Game game = new Game(field);
        game.enterShip();
        game.gameStart();
    }
}


