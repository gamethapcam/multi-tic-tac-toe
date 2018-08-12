package robson.games.tictactoe.game.ai.rules;


import robson.games.tictactoe.game.ai.Rule;
import robson.games.tictactoe.model.Path;
import robson.games.tictactoe.model.Player;

import java.util.List;

public class DestroySomeoneElseVictory implements Rule {

    @Override
    public boolean executeSelection(Player player, List<Path> paths) {
        for (Path path : paths) {
            if (path.containsSamePlayerOnly() && path.countFreeFields() == 1) {
                path.getFirstFreeField().assign(player);
                return true;
            }
        }
        return false;
    }
}