package robson.games.tictactoe.model;

import org.junit.Assert;
import org.junit.Test;

public class PlayfieldTest {

    @Test
    public void shouldCreateAPlayfieldWithGivenRowAndColumns() {
        Playfield playfield = new Playfield(3, 4);
        Assert.assertEquals(3, playfield.getFields().length);
        Assert.assertEquals(4, playfield.getFields()[0].length);
        Assert.assertEquals(3, playfield.getRows());
        Assert.assertEquals(4, playfield.getColumns());
    }

    @Test
    public void shouldSliceItsPathsAccordingToItsSize() {
        Playfield playfield = new Playfield(3, 3);
        Assert.assertEquals(8, playfield.getPaths().size());
    }

    @Test
    public void shouldAssignAPlayerToFreeAField() {
        Playfield playfield = new Playfield(3, 3);
        playfield.select(new Player('X'), 0,1);
        Assert.assertEquals(new Player('X'), playfield.getFields()[0][1].getAssigned());
    }

    @Test
    public void shouldIdentifyAWinner() {
        Playfield playfield = new Playfield(3, 3);
        playfield.select(new Player('X'), 0,0);
        playfield.select(new Player('X'), 0,1);
        playfield.select(new Player('X'), 0,2);
        Assert.assertTrue(playfield.hasWinner());
    }

    @Test
    public void shouldIdentifyTheWinnerPlayer() {
        Playfield playfield = new Playfield(3, 3);
        playfield.select(new Player('X'), 0,0);
        playfield.select(new Player('X'), 0,1);
        playfield.select(new Player('X'), 0,2);
        Assert.assertEquals(new Player('X'), playfield.getWinner());
    }

    @Test
    public void shouldIdentifyADrawGame() {
        Playfield playfield = new Playfield(3, 3);
        playfield.select(new Player('X'), 0,0);
        playfield.select(new Player('Y'), 0,1);
        playfield.select(new Player('Z'), 0,2);
        playfield.select(new Player('Z'), 1,0);
        playfield.select(new Player('Y'), 1,1);
        playfield.select(new Player('X'), 1,2);
        playfield.select(new Player('Y'), 2,0);
        playfield.select(new Player('Z'), 2,1);
        playfield.select(new Player('X'), 2,2);
        Assert.assertTrue(playfield.isDraw());
    }

    @Test
    public void shouldIdentifyAGameOver() {
        Playfield playfield = new Playfield(3, 3);
        playfield.select(new Player('X'), 0,0);
        playfield.select(new Player('Y'), 0,1);
        playfield.select(new Player('Z'), 0,2);
        playfield.select(new Player('Z'), 1,0);
        playfield.select(new Player('Y'), 1,1);
        playfield.select(new Player('X'), 1,2);
        playfield.select(new Player('Y'), 2,0);
        playfield.select(new Player('Z'), 2,1);
        playfield.select(new Player('X'), 2,2);
        Assert.assertTrue(playfield.isOver());

        Playfield playfield2 = new Playfield(3, 3);
        playfield2.select(new Player('X'), 0,0);
        playfield2.select(new Player('X'), 0,1);
        playfield2.select(new Player('X'), 0,2);
        Assert.assertTrue(playfield2.isOver());
    }

    @Test
    public void shouldIdentifyAValidRange() {
        Playfield playfield = new Playfield(3, 3);
        Assert.assertTrue(playfield.hasField(0,1));
        Assert.assertFalse(playfield.hasField(-1,1));
        Assert.assertFalse(playfield.hasField(0,3));
        Assert.assertFalse(playfield.hasField(5,7));
    }

    @Test
    public void shouldIdentifyAnAvailableField() {
        Playfield playfield = new Playfield(3, 3);
        playfield.select(new Player('X'), 0,0);
        Assert.assertTrue(playfield.isFieldAvailable(0,1));
        Assert.assertFalse(playfield.isFieldAvailable(0,0));
    }

}
