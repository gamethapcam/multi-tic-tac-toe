package robson.games.tictactoe.game.ai;

import robson.games.tictactoe.game.ai.modes.EasyAIAutoSelectableImpl;
import robson.games.tictactoe.game.ai.modes.HardAIAutoSelectableImpl;
import robson.games.tictactoe.game.ai.modes.NormalAIAutoSelectableImpl;

public enum Mode {
    EASY {
        @Override
        public AIAutoSelectable getInstance() {
            return new EasyAIAutoSelectableImpl();
        }
    }, NORMAL {
        @Override
        public AIAutoSelectable getInstance() {
            return new NormalAIAutoSelectableImpl();
        }
    }, HARD {
        @Override
        public AIAutoSelectable getInstance() {
            return new HardAIAutoSelectableImpl();
        }
    };

    public abstract AIAutoSelectable getInstance();
}
