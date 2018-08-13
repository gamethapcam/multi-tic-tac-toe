package robson.games.tictactoe.game.ai.rules;

import org.junit.Assert;
import org.junit.Test;
import robson.games.tictactoe.model.Field;
import robson.games.tictactoe.model.Path;
import robson.games.tictactoe.model.Player;

import java.util.ArrayList;
import java.util.List;

public class DestroySomeoneElseVictoryTest {

    private final DestroySomeoneElseVictory destroySomeoneElseVictory = new DestroySomeoneElseVictory();

    @Test
    public void shouldChangeIfPathIsReadyToTheVictory() {
        List<Path> paths = new ArrayList<>();

        Field field = new Field(0, 0);
        field.assign(new Player('T'));
        Path pathA = new Path();

        pathA.add(new Field(0, 0));
        pathA.add(field);
        pathA.add(field);
        paths.add(pathA);

        destroySomeoneElseVictory.executeSelection(new Player('X'), paths);
        Assert.assertTrue(pathA.isFull());
    }

    @Test
    public void shouldntChangeIfPathIsntReadyToTheVictory() {
        List<Path> paths = new ArrayList<>();

        Field field = new Field(0, 0);
        field.assign(new Player('T'));
        Path pathA = new Path();

        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        pathA.add(field);
        paths.add(pathA);

        destroySomeoneElseVictory.executeSelection(new Player('X'), paths);
        Assert.assertTrue(pathA.countFreeFields() == 2);
    }

    @Test
    public void shouldntChangeAnEmptyPath() {
        List<Path> paths = new ArrayList<>();

        Path pathA = new Path();

        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        paths.add(pathA);

        destroySomeoneElseVictory.executeSelection(new Player('X'), paths);
        Assert.assertTrue(pathA.isEmpty());

    }
}
