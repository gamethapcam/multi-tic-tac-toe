package robson.games.tictactoe.game.ai.rules;

import robson.games.tictactoe.game.ai.Rule;
import robson.games.tictactoe.io.Printer;
import robson.games.tictactoe.model.Path;
import robson.games.tictactoe.model.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TakeAnEmptyPath implements Rule {

    @Override
    public boolean executeSelection(Player player, List<Path> paths) {
        List<Path> copyPaths = new ArrayList<>(paths);
        Collections.shuffle(copyPaths);
        for (Path path : copyPaths) {
            if (path.isEmpty()) {
                path.getRandomFreeField().assign(player);
                Printer.debug("Here we go!...");
                return true;
            }
        }
        return false;
    }

}
