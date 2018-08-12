package robson.games.tictactoe.game.ai.rules;

import robson.games.tictactoe.game.ai.Rule;
import robson.games.tictactoe.model.Player;
import robson.games.tictactoe.model.Slice;

import java.util.List;

public class AmICloseToWinTheGame implements Rule {

    @Override
    public boolean execute(Player player, List<Slice> slices) {
        for (Slice slice: slices) {
            if (slice.containsOnly(player) && slice.countFreeFields() == 1) {
                slice.getFirstFreeField().assign(player);
                return true;
            }
        }
        return false;
    }

}
