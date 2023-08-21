package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    final int BOARD_SIZE = 9;
    static final List<Integer> availableXY = Arrays.asList(1, 2, 3);
    Map<Coords, Integer> coordsMap = new HashMap<>();

    StateEnum STATE;
    int[] field;

    public static final Game INSTANCE = new Game();
    public Game() {
    }

    public void init(){
        this.STATE = StateEnum.GAME_GOING;

        //initializing game board and coords map
        this.field = new int[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            this.field[i] = 0;
            coordsMap.put(new Coords((i)%3+1,(i)/3+1), i);
        }
    }

    public boolean makeTurn(Integer x, Integer y, PlayerType playerType){
        /**
         *  Returns status of a turn.
         *  Correct - true, Incorrect - false
         *
         *  All validations here
         */

        if (!availableXY.contains(x) || !availableXY.contains(y)){
            System.out.println("wrong coodinates");
            return false;
        }

        /**
         * At this point we are sure that x and y is valid
         *     +-----+-----+-----+
         *     |  1  |  2  |  3  |
         *     +-----+-----+-----+
         *     |  4  |  5  |  6  |
         *     +-----+-----+-----+
         *     |  7  |  8  |  9  |
         *     +-----+-----+-----+
         *
         *     +-----+-----+-----+
         *     | 1,1 | 2,1 | 3,1 |
         *     +-----+-----+-----+
         *     | 1,2 | 2,2 | 3,2 |
         *     +-----+-----+-----+
         *     | 1,3 | 2,3 | 3,3 |
         *     +-----+-----+-----+
         */

        Coords coordsInput = new Coords(x,y);
        Integer temp = coordsMap.get(coordsInput);
        System.out.println(temp);
        if (field[temp] != 0){
            System.out.println("Cell is already taken!");
            return false;
        }

        if (playerType == PlayerType.BOT){
            //BOT
            field[temp] = 2; //Not a magic numbers! Essencial game logic!
        } else {
            //HUMAN
            field[temp] = 1;
        }

        return true;
    }

    public void drawField(){
        System.out.print("""
                            +-----+-----+-----+
                            |  %s  |  %s  |  %s  |
                            +-----+-----+-----+
                            |  %s  |  %s  |  %s  |
                            +-----+-----+-----+
                            |  %s  |  %s  |  %s  |
                            +-----+-----+-----+
                            """
                .formatted(field[0], field[1], field[2],
                           field[3], field[4], field[5],
                           field[6], field[7], field[8]));
    }
}
