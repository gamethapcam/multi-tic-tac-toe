package robson.games.tictactoe.game.ai.rules;

import org.junit.Assert;
import org.junit.Test;
import robson.games.tictactoe.model.Field;
import robson.games.tictactoe.model.Path;
import robson.games.tictactoe.model.Player;

import java.util.ArrayList;
import java.util.List;

public class TakeTheBestPathOfSomeoneElseTest {
    private TakeTheBestPathOfSomeoneElse takeTheBestPathOfSomeoneElse = new TakeTheBestPathOfSomeoneElse();

    @Test
    public void shouldTakeTheBestPathOfSomeoneElse() {
        List<Path> paths = new ArrayList<>();

        Path pathA = new Path();

        Field field = new Field(0,0);
        field.assign(new Player('T'));

        pathA.add(new Field(0,0));
        pathA.add(new Field(0,0));
        pathA.add(new Field(0,0));
        paths.add(pathA);

        Path pathB = new Path();
        pathB.add(new Field(0,0));
        pathB.add(new Field(0,0));
        pathB.add(field);
        paths.add(pathB);

        Path pathC = new Path();
        pathC.add(new Field(0,0));
        pathC.add(field);
        pathC.add(field);
        paths.add(pathC);

        takeTheBestPathOfSomeoneElse.executeSelection(new Player('O'), paths);

        Assert.assertTrue(!pathC.hasWinner());
        Assert.assertTrue(pathC.isFull());

    }
}
