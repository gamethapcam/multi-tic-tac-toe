package robson.games.tictactoe.io;

public class Config {

    public static final int PLAYFIELD_SIZE = 5;
    public static final char FIRST_PLAYER_CHAR = 'O';
    public static final char SECOND_PLAYER_CHAR = 'X';
    public static final char COMPUTER_PLAYER_CHAR = 'R';
    private Integer playfieldSize;
    private Character firstPlayerChar;
    private Character secondPlayerChar;
    private Character computerPlayerChar;

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
