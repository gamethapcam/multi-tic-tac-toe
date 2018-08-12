package robson.games.tictactoe.game.ai.modes.hard.rules;

import robson.games.tictactoe.game.ai.modes.hard.Rule;
import robson.games.tictactoe.model.Player;
import robson.games.tictactoe.model.Path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImFeelingLucky implements Rule {

    @Override
    public boolean executeSelection(Player player, List<Path> paths) {
        List<Path> copyPaths = new ArrayList<>(paths);
        Collections.shuffle(copyPaths);
        for (Path path : copyPaths) {
            if (path.countFreeFields() > 0) {
                path.getRandomFreeField().assign(player);
                return true;
            }
        }
        return false;
    }
}
