package robson.games.tictactoe.game.ai.modes.hard.rules;



import robson.games.tictactoe.game.ai.modes.hard.Rule;
import robson.games.tictactoe.model.Path;
import robson.games.tictactoe.model.Player;

import java.util.List;

public class WinTheGame implements Rule {

    @Override
    public boolean executeSelection(Player player, List<Path> paths) {
        for (Path path: paths) {
            if (path.containsOnly(player) && path.countFreeFields() == 1) {
                path.getFirstFreeField().assign(player);
                return true;
            }
        }
        return false;
    }
}