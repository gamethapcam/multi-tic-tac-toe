package robson.games.tictactoe.game.ai.rules;

import robson.games.tictactoe.game.ai.Rule;
import robson.games.tictactoe.game.ai.rules.comparators.PathWithFewerFreeFieldsComparator;
import robson.games.tictactoe.io.Printer;
import robson.games.tictactoe.model.Path;
import robson.games.tictactoe.model.Player;

import java.util.Collections;
import java.util.List;

public class TakeTheBestPathOfSomeoneElse implements Rule {

    @Override
    public boolean executeSelection(Player player, List<Path> paths) {
        Collections.sort(paths, new PathWithFewerFreeFieldsComparator());
        for (Path path : paths) {
            if (path.containsSamePlayerOnly() && path.countFreeFields() > 0) {
                path.getFirstFreeField().assign(player);
                Printer.debug("No way! It is mine.");
                return true;
            }
        }
        return false;
    }
}
