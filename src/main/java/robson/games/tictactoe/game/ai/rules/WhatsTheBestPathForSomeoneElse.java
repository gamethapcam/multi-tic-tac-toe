package robson.games.tictactoe.game.ai.rules;

import robson.games.tictactoe.game.ai.Rule;
import robson.games.tictactoe.model.Player;
import robson.games.tictactoe.model.Slice;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WhatsTheBestPathForSomeoneElse implements Rule {

    @Override
    public boolean execute(Player player, List<Slice> slices) {
        Collections.sort(slices, new Comparator<Slice>() {
            @Override
            public int compare(Slice slice, Slice t1) {
                return slice.countFreeFields().compareTo(t1.countFreeFields());
            }
        });
        for (Slice slice: slices) {
            if (slice.containsOnlyOnePlayer() && slice.countFreeFields() > 0) {
                slice.getAFreeField().assign(player);
                return true;
            }
        }
        return false;
    }
}
