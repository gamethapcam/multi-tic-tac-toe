package robson.games.tictactoe.io;

public class Config {

    private static final int PLAYFIELD_SIZE = 3;
    private static final char FIRST_PLAYER_CHAR = 'O';
    private static final char SECOND_PLAYER_CHAR = 'X';
    private static final char COMPUTER_PLAYER_CHAR = 'R';
    private final Integer playfieldSize;
    private final Character firstPlayerChar;
    private final Character secondPlayerChar;
    private final Character computerPlayerChar;

    public Config(Integer playfieldSize, Character firstPlayerChar, Character secondPlayerChar, Character computerPlayerChar) {
        this.playfieldSize = playfieldSize;
        this.firstPlayerChar = firstPlayerChar;
        this.secondPlayerChar = secondPlayerChar;
        this.computerPlayerChar = computerPlayerChar;
    }

    public Integer getPlayfieldSize() {
        return playfieldSize;
    }

    public Character getFirstPlayerChar() {
        return firstPlayerChar;
    }

    public Character getSecondPlayerChar() {
        return secondPlayerChar;
    }

    public Character getComputerPlayerChar() {
        return computerPlayerChar;
    }

    public static Config defaultConfiguration() {
        return new Config(PLAYFIELD_SIZE, FIRST_PLAYER_CHAR, SECOND_PLAYER_CHAR, COMPUTER_PLAYER_CHAR);
    }
}
