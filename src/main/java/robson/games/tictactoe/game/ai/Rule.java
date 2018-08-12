package robson.games.tictactoe.game.ai;

import robson.games.tictactoe.model.Path;
import robson.games.tictactoe.model.Player;

import java.util.List;

public interface Rule {

    boolean executeSelection(Player player, List<Path> paths);
}
