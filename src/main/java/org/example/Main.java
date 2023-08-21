package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Console console = new Console();
        Game game = new Game();

        game.init();
        console.log("Game started");
        while (game.STATE == StateEnum.GAME_GOING){
            Integer x = input.nextInt();
            Integer y = input.nextInt();
            game.makeTurn(x, y, PlayerType.HUMAN);
            game.drawField();
            //return ;
        }
    }
}