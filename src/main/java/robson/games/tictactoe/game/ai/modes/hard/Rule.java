package robson.games.tictactoe.game.ai.modes.hard;

import robson.games.tictactoe.model.Player;
import robson.games.tictactoe.model.Path;

import java.util.List;

public interface Rule {

    boolean executeSelection(Player player, List<Path> paths);
}
