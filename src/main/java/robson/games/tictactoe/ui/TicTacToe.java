package robson.games.tictactoe.ui;

import robson.games.tictactoe.game.ai.AIEngine;
import robson.games.tictactoe.game.PlayersManager;
import robson.games.tictactoe.game.ValidationChecker;
import robson.games.tictactoe.io.Config;
import robson.games.tictactoe.io.ConfigurationReader;
import robson.games.tictactoe.model.Player;
import robson.games.tictactoe.model.Playfield;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    private ConfigurationReader configurationReader = new ConfigurationReader();

    private PlayersManager playersManager = new PlayersManager();

    private AIEngine aiEngine = new AIEngine();


    public void play(String args[]) {
        try {
            Printer.info("Welcome to Robson's TicTacToc :)");

            Config config = getConfig(args);

            Printer.info(String.format("Configuration is loaded as: playfieldsize=%d, firstplayerchar=%s, secondplayerchar=%s and computerchar=%s", config.getPlayfieldSize(), config.getFirstPlayerChar(), config.getSecondPlayerChar(), config.getComputerPlayerChar()));

            Printer.info("You can quit the game at any time by typing the combination 'CTRL+C'");


            List<Player> players = playersManager.load(config);
            Collections.shuffle(players);

            Playfield playfield = new Playfield(config.getPlayfieldSize(), config.getPlayfieldSize());
            print(playfield);

            Scanner userControl = new Scanner(System.in);
            while (!playfield.isOver()) {
                for (Player player : players) {
                    if (player.isHuman()) {
                        boolean isValidInput = false;
                        InputValue inputValue = null;
                        while (!isValidInput) {
                            Printer.info(String.format("Player %s, please enter your game. Format: <line, column> e.g. 1,2", player.getCharacter()));

                            String userOption = userControl.nextLine();
                            inputValue = new InputValue(userOption);
                            if (!inputValue.isValid()) {
                                Printer.err("Invalid input. Format: <line, column> e.g. 1,2");
                                isValidInput = false;
                                continue;
                            }
                            if (!playfield.hasField(inputValue.getLineValue(), inputValue.getColumnValue())) {
                                Printer.err("Invalid input. Format: <line, column> e.g. 1,2 (within the square limits)");
                                isValidInput = false;
                                continue;
                            }

                            if (!playfield.isFieldAvailable(inputValue.getLineValue(), inputValue.getColumnValue())) {
                                Printer.err("Invalid input. Selected field is in use.");
                                isValidInput = false;
                                continue;
                            }

                            //all set?
                            isValidInput = true;
                        }
                        playfield.select(player, inputValue.getLineValue(), inputValue.getColumnValue());

                    } else {
                        Printer.info(String.format("Computer %s is playing...", player.getCharacter()));
                        aiEngine.select(player, playfield);
                    }

                    print(playfield);
                    if (playfield.isOver()) {
                        //check the result and show it off
                        if (playfield.hasWinner()) {
                            Printer.info(String.format("Congratulations player %s, you win! \\o/", playfield.getWinner().getCharacter()));
                        } else {
                            assert (playfield.isTied());
                            Printer.info("Game is tied! :(");
                        }

                        break;
                    }
                }
            }

        } catch (Exception e) {
            Printer.err(e.getMessage());
            e.printStackTrace();
        }
    }

    private Config getConfig(String[] args) throws IOException {
        Config config = Config.defaultConfiguration();
        if (args.length > 1 && "--config".equals(args[0])) {
            config = configurationReader.fromFile(args[1]);
            ValidationChecker.validatePlayfieldSize(config.getPlayfieldSize());
        } else {
            Printer.warn("No configuration file provided. Assuming default values.");
        }
        return config;
    }

    private void print(Playfield playfield) {
        for (int i = 0; i < playfield.getRows(); i++) {
            for (int j = 0; j < playfield.getColumns(); j++) {
                System.out.print(String.format("[%s]", playfield.getFields()[i][j].isAssigned() ? playfield.getFields()[i][j].getAssigned().getCharacter() : "-"));
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        new TicTacToe().play(args);
    }
}
