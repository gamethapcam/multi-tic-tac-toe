package robson.games.tictactoe.game;

import robson.games.tictactoe.game.exception.UnableToContinueException;
import robson.games.tictactoe.io.Config;
import robson.games.tictactoe.model.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayersManager {

    public List<Player> load(Config config) {
        Set<Player> result = new HashSet<>();
        Player first = new Player(config.getFirstPlayerChar());
        result.add(first);

        Player second = new Player(config.getSecondPlayerChar());

        if (first.equals(second)) {
            throw new UnableToContinueException("Duplicate characters for first and second players; please, review your configuration file.");
        }

        result.add(second);

        Player computer = new Player(config.getComputerPlayerChar(), false);

        if (result.contains(computer)) {
            throw new UnableToContinueException("Cannot load computer player because its character already exists; please, review your configuration file.");
        }

        result.add(computer);

        return new ArrayList<>(result);
    }

    public List<Player> twoRobots() {
        List<Player> players = new ArrayList<>();
        players.add(new Player('O', false));
        players.add(new Player('X', false));
        return players;
    }

    public List<Player> singlePlayer() {
        List<Player> players = new ArrayList<>();
        players.add(new Player('O'));
        players.add(new Player('X', false));
        return players;
    }

}
