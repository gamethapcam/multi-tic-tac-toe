package robson.games.tictactoe.game.ai;

import robson.games.tictactoe.game.ai.rules.AmICloseToWinTheGame;
import robson.games.tictactoe.game.ai.rules.ImFeelingLucky;
import robson.games.tictactoe.game.ai.rules.IsSomebodyCloseToWinTheGame;
import robson.games.tictactoe.game.ai.rules.WhatsTheBestPathForMe;
import robson.games.tictactoe.game.ai.rules.WhatsTheBestPathForSomeoneElse;
import robson.games.tictactoe.model.Player;
import robson.games.tictactoe.model.Playfield;
import robson.games.tictactoe.model.Slice;

import java.util.ArrayList;
import java.util.List;

public class AIEngine {
    private List<Rule> rules;

    public AIEngine() {
        this.rules = new ArrayList<>();
        this.rules.add(new AmICloseToWinTheGame());
        this.rules.add(new IsSomebodyCloseToWinTheGame());
        this.rules.add(new WhatsTheBestPathForMe());
        this.rules.add(new WhatsTheBestPathForSomeoneElse());
        this.rules.add(new ImFeelingLucky());

    }

    public void select(Player player, Playfield playfield) {
        List<Slice> slices = playfield.getSlices();
        for (Rule rule: rules) {
            if (rule.execute(player, slices)) {
                break;
            }
        }
    }
}
