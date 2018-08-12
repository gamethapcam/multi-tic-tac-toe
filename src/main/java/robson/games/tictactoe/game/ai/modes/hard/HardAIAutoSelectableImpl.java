package robson.games.tictactoe.game.ai.modes.hard;

import robson.games.tictactoe.game.ai.AIAutoSelectable;
import robson.games.tictactoe.game.ai.modes.hard.rules.DestroySomeoneElseVictory;
import robson.games.tictactoe.game.ai.modes.hard.rules.ImFeelingLucky;
import robson.games.tictactoe.game.ai.modes.hard.rules.TakeAnEmptyPath;
import robson.games.tictactoe.game.ai.modes.hard.rules.TakeTheBestPathForMe;
import robson.games.tictactoe.game.ai.modes.hard.rules.TakeTheBestPathOfSomeoneElse;
import robson.games.tictactoe.game.ai.modes.hard.rules.WinTheGame;
import robson.games.tictactoe.model.Player;
import robson.games.tictactoe.model.Playfield;
import robson.games.tictactoe.model.Path;

import java.util.ArrayList;
import java.util.List;

public class HardAIAutoSelectableImpl implements AIAutoSelectable {

    private List<Rule> rulesKnowledgeBase;

    public HardAIAutoSelectableImpl() {
        this.rulesKnowledgeBase = new ArrayList<>();
        this.rulesKnowledgeBase.add(new WinTheGame());
        this.rulesKnowledgeBase.add(new DestroySomeoneElseVictory());
        this.rulesKnowledgeBase.add(new TakeTheBestPathForMe());
        this.rulesKnowledgeBase.add(new TakeAnEmptyPath());
        this.rulesKnowledgeBase.add(new TakeTheBestPathOfSomeoneElse());
        this.rulesKnowledgeBase.add(new ImFeelingLucky());
    }

    @Override
    public void select(Player player, Playfield playfield) {
        List<Path> paths = playfield.getPaths();
        for (Rule rule: rulesKnowledgeBase) {
            if (rule.executeSelection(player, paths)) {
                break;
            }
        }
    }
}
