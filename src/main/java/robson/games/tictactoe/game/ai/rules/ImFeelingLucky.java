package robson.games.tictactoe.game.ai.rules;

import robson.games.tictactoe.game.ai.Rule;
import robson.games.tictactoe.model.Player;
import robson.games.tictactoe.model.Slice;

import java.util.List;

public class ImFeelingLucky implements Rule {

    @Override
    public boolean execute(Player player, List<Slice> slices) {
        for (Slice slice: slices) {
            if (slice.countFreeFields() > 0) {
                slice.getAFreeField().assign(player);
                return true;
            }
        }
        return false;
    }
}
