package robson.games.tictactoe.game;

import robson.games.tictactoe.game.exception.UnableToContinueException;

public class ValidationChecker {

    private static final int MAX_PLAYFIELD_SIZE = 10;
    private static final int MIN_PLAYFIELD_SIZE = 3;


    public static void validatePlayfieldSize(int size) {
        if (size > MAX_PLAYFIELD_SIZE) {
            throw new UnableToContinueException(String.format("Playfield size (%d) is greater than the limit (%d); please review your configuration file.", size, MAX_PLAYFIELD_SIZE));
        }

        if (size < MIN_PLAYFIELD_SIZE) {
            throw new UnableToContinueException(String.format("Playfield size (%d) is lower than the limit (%d); please review your configuration file.", size, MIN_PLAYFIELD_SIZE));
        }
    }
}
