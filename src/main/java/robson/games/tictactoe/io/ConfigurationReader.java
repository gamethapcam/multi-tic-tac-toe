package robson.games.tictactoe.io;

import robson.games.tictactoe.game.exception.UnableToContinueException;
import robson.games.tictactoe.utils.NumberUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static final String PLAYFIELD_SIZE = "playfield.size";
    private static final String PLAYFIELD_PLAYERS_FIRST_CHAR = "playfield.players.first.char";
    private static final String PLAYFIELD_PLAYERS_SECOND_CHAR = "playfield.players.second.char";
    private static final String PLAYFIELD_PLAYERS_COMPUTER_CHAR = "playfield.players.computer.char";

    public Config fromFile(String file) throws IOException {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(file);
            prop.load(input);
            return new Config(getPlayfieldSize(prop), getFirstPlayerChar(prop), getSecondPlayerChar(prop), getComputerPlayerChar(prop));
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Character getComputerPlayerChar(Properties prop) {
        String value = prop.getProperty(PLAYFIELD_PLAYERS_COMPUTER_CHAR);
        if (value == null || value.trim().isEmpty()) {
            throw new UnableToContinueException("Unable to read computer player, did you configure it? please, review your configuration file.");
        }
        return value.charAt(0);
    }

    private Character getSecondPlayerChar(Properties prop) {
        String value = prop.getProperty(PLAYFIELD_PLAYERS_SECOND_CHAR);
        if (value == null || value.trim().isEmpty()) {
            throw new UnableToContinueException("Unable to read second player, did you configure it? please, review your configuration file.");
        }
        return value.charAt(0);
    }

    private Character getFirstPlayerChar(Properties prop) {
        String value = prop.getProperty(PLAYFIELD_PLAYERS_FIRST_CHAR);
        if (value == null || value.trim().isEmpty()) {
            throw new UnableToContinueException("Unable to read first player, did you configure it? please, review your configuration file.");
        }
        return value.charAt(0);
    }

    private Integer getPlayfieldSize(Properties prop) {
        String value = prop.getProperty(PLAYFIELD_SIZE);
        if (NumberUtils.isNumeric(value)) {
            return Integer.valueOf(value);
        } else {
            throw new UnableToContinueException("Playfield size must be a number; please, review your configuration file.");
        }
    }

}
