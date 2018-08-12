package robson.games.tictactoe.game.ai.rules;

import org.junit.Assert;
import org.junit.Test;
import robson.games.tictactoe.model.Field;
import robson.games.tictactoe.model.Path;
import robson.games.tictactoe.model.Player;

import java.util.ArrayList;
import java.util.List;

public class TakeAnEmptyPathTest {

    private TakeAnEmptyPath takeAnEmptyPath = new TakeAnEmptyPath();

    @Test
    public void shouldTakeAnEmptyPath() {
        List<Path> paths = new ArrayList<>();

        Path pathA = new Path();

        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        paths.add(pathA);

        takeAnEmptyPath.executeSelection(new Player('X'), paths);
        Assert.assertTrue(pathA.countFreeFields() == 2);
    }

    @Test
    public void shouldntTakeANonEmptyPath() {
        List<Path> paths = new ArrayList<>();

        Field field = new Field(0,0);
        field.assign(new Player('T'));
        Path pathA = new Path();

        pathA.add(field);
        pathA.add(field);
        pathA.add(new Field(0, 0));
        paths.add(pathA);

        takeAnEmptyPath.executeSelection(new Player('X'), paths);
        Assert.assertTrue(pathA.countFreeFields() == 1);
    }

}
