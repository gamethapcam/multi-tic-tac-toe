package robson.games.tictactoe.game.ai.modes.hard.comparators;

import robson.games.tictactoe.model.Path;

import java.util.Comparator;

public class PathWithFewerFreeFieldsComparator implements Comparator<Path> {

    @Override
    public int compare(Path path, Path path2) {
        if (path.countFreeFields() == 0 && path2.countFreeFields() > 0) {
            return 1;
        }
        if (path.countFreeFields() > 0 && path2.countFreeFields() == 0) {
            return -1;
        }
        if (path.countFreeFields() == path2.countFreeFields()) {
            return 0;
        }
        return path.countFreeFields() < path2.countFreeFields() ? -1 : 1;
    }

}
