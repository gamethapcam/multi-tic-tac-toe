package robson.games.tictactoe.game.ai.rules;

import org.junit.Assert;
import org.junit.Test;
import robson.games.tictactoe.model.Field;
import robson.games.tictactoe.model.Path;
import robson.games.tictactoe.model.Player;

import java.util.ArrayList;
import java.util.List;

public class WinTheGameTest {

    private final WinTheGame winTheGame = new WinTheGame();

    @Test
    public void shouldntChangeIfPlayerIsntReadyToWin() {
        List<Path> paths = new ArrayList<>();

        Field field = new Field(0, 0);
        field.assign(new Player('T'));
        Path pathA = new Path();

        pathA.add(new Field(0, 0));
        pathA.add(field);
        pathA.add(field);
        paths.add(pathA);

        winTheGame.executeSelection(new Player('X'), paths);
        Assert.assertTrue(pathA.countFreeFields() == 1);
    }

    @Test
    public void shouldChangeIfPlayerIsReadyToWin() {
        List<Path> paths = new ArrayList<>();

        Field field = new Field(0, 0);
        field.assign(new Player('T'));
        Path pathA = new Path();

        pathA.add(new Field(0, 0));
        pathA.add(field);
        pathA.add(field);
        paths.add(pathA);

        winTheGame.executeSelection(new Player('T'), paths);
        Assert.assertTrue(pathA.hasWinner());
    }
}
