package robson.games.tictactoe.game.ai;

import robson.games.tictactoe.model.Player;
import robson.games.tictactoe.model.Playfield;

public interface AIAutoSelectable {
    void select(Player player, Playfield playfield);
}
