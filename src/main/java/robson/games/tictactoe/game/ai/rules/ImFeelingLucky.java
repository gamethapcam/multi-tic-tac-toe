package robson.games.tictactoe.game.ai.rules;

import robson.games.tictactoe.game.ai.Rule;
import robson.games.tictactoe.model.Player;
import robson.games.tictactoe.model.Slice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImFeelingLucky implements Rule {

    @Override
    public boolean execute(Player player, List<Slice> slices) {
        List<Slice> copySlices = new ArrayList<>(slices);
        Collections.shuffle(copySlices);
        for (Slice slice: copySlices) {
            if (slice.countFreeFields() > 0) {
                slice.getRandomFreeField().assign(player);
                return true;
            }
        }
        return false;
    }
}
