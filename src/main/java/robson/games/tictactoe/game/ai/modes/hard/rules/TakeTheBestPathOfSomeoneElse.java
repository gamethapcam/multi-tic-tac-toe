package robson.games.tictactoe.game.ai.modes.hard.rules;

import robson.games.tictactoe.game.ai.modes.hard.Rule;
import robson.games.tictactoe.game.ai.modes.hard.comparators.PathWithFewerFreeFieldsComparator;
import robson.games.tictactoe.model.Player;
import robson.games.tictactoe.model.Path;

import java.util.Collections;
import java.util.List;

public class TakeTheBestPathOfSomeoneElse implements Rule {

    @Override
    public boolean executeSelection(Player player, List<Path> paths) {
        Collections.sort(paths, new PathWithFewerFreeFieldsComparator());
        for (Path path : paths) {
            if (path.containsSamePlayerOnly() && path.countFreeFields() > 0) {
                path.getFirstFreeField().assign(player);
                return true;
            }
        }
        return false;
    }
}
