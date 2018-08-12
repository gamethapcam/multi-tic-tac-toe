package robson.games.tictactoe.game.ai;

import robson.games.tictactoe.model.Player;
import robson.games.tictactoe.model.Slice;

import java.util.List;

public interface Rule {

    boolean execute(Player player, List<Slice> slices);
}
