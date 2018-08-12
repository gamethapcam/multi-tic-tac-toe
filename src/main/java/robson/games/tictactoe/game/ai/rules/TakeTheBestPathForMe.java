package robson.games.tictactoe.game.ai.rules;

import robson.games.tictactoe.game.ai.Rule;
import robson.games.tictactoe.game.ai.rules.comparators.PathWithFewerFreeFieldsComparator;
import robson.games.tictactoe.model.Path;
import robson.games.tictactoe.model.Player;

import java.util.Collections;
import java.util.List;

public class TakeTheBestPathForMe implements Rule {

    @Override
    public boolean executeSelection(Player player, List<Path> paths) {
        Collections.sort(paths, new PathWithFewerFreeFieldsComparator());
        for (Path path : paths) {
            if (path.containsOnly(player) && path.countFreeFields() > 0) {
                path.getFirstFreeField().assign(player);
                return true;
            }
        }
        return false;
    }

}
