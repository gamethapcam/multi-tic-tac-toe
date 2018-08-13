package robson.games.tictactoe.game.ai.rules;

import org.junit.Assert;
import org.junit.Test;
import robson.games.tictactoe.model.Field;
import robson.games.tictactoe.model.Path;
import robson.games.tictactoe.model.Player;

import java.util.ArrayList;
import java.util.List;

public class TakeARandomFieldTest {

    private final TakeARandomField takeARandomField = new TakeARandomField();

    @Test
    public void shouldTakeARandomField() {
        List<Path> paths = new ArrayList<>();

        Path pathA = new Path();

        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        paths.add(pathA);

        takeARandomField.executeSelection(new Player('X'), paths);
        Assert.assertTrue(pathA.countFreeFields() == 4);
    }


}
