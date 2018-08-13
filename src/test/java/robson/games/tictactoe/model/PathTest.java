package robson.games.tictactoe.model;

import org.junit.Assert;
import org.junit.Test;

public class PathTest {

    @Test
    public void shouldHaveAWinner() {
        Field field = new Field(0, 0);
        field.assign(new Player('T'));

        Path pathA = new Path();
        pathA.add(field);
        pathA.add(field);
        pathA.add(field);

        Assert.assertTrue(pathA.hasWinner());
    }

    @Test
    public void shouldntHaveAWinner() {
        Field field = new Field(0, 0);
        field.assign(new Player('T'));

        Path pathA = new Path();
        pathA.add(field);
        pathA.add(field);
        pathA.add(new Field(0, 0));

        Assert.assertFalse(pathA.hasWinner());
    }

    @Test
    public void shouldBeABadPath() {
        Field field = new Field(0, 0);
        field.assign(new Player('T'));

        Field field2 = new Field(0, 0);
        field2.assign(new Player('X'));

        Path pathA = new Path();
        pathA.add(field);
        pathA.add(field2);
        pathA.add(field);

        Assert.assertTrue(pathA.isBadPath());
    }

    @Test
    public void shouldBeFull() {
        Field field = new Field(0, 0);
        field.assign(new Player('T'));

        Field field2 = new Field(0, 0);
        field2.assign(new Player('X'));

        Path pathA = new Path();
        pathA.add(field);
        pathA.add(field2);
        pathA.add(field);

        Assert.assertTrue(pathA.isFull());
    }

    @Test
    public void shouldBeEmpty() {
        Path pathA = new Path();
        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));

        Assert.assertTrue(pathA.isEmpty());
    }

    @Test
    public void shouldReturnTheFreeFields() {
        Field field = new Field(0, 0);
        field.assign(new Player('T'));

        Path pathA = new Path();
        pathA.add(field);
        pathA.add(new Field(0, 0));
        pathA.add(new Field(0, 0));

        Assert.assertEquals(2, pathA.countFreeFields());
    }

    @Test
    public void shouldReturnTheFirstFreeFields() {
        Field field = new Field(0, 0);
        field.assign(new Player('T'));

        Field freeField = new Field(0, 0);


        Path pathA = new Path();
        pathA.add(field);
        pathA.add(field);
        pathA.add(freeField);

        Assert.assertSame(freeField, pathA.getFirstFreeField());
    }

    @Test
    public void shouldReturnARandomFreeField() {
        Field field = new Field(0, 0);
        field.assign(new Player('T'));

        Field freeField = new Field(0, 0);


        Path pathA = new Path();
        pathA.add(field);
        pathA.add(freeField);
        pathA.add(field);
        pathA.add(field);
        pathA.add(freeField);


        Field result = pathA.getRandomFreeField();
        Assert.assertFalse(result.isAssigned());
    }

    @Test
    public void shouldConfirmWhetherAPathContainsOnlyAGivenPlayer() {
        Field field = new Field(0, 0);
        field.assign(new Player('T'));

        Field field2 = new Field(0, 0);
        field2.assign(new Player('X'));

        Path pathA = new Path();
        pathA.add(field);
        pathA.add(field);
        pathA.add(new Field(0, 0));
        pathA.add(field);
        pathA.add(field);

        Assert.assertTrue(pathA.containsOnly(new Player('T')));

        pathA.add(field2);

        Assert.assertFalse(pathA.containsOnly(new Player('T')));
    }

    @Test
    public void shouldConfirmWhetherAPathIsComposedBySamePlayerOnly() {
        Field field = new Field(0, 0);
        field.assign(new Player('T'));

        Field field2 = new Field(0, 0);
        field2.assign(new Player('X'));

        Path pathA = new Path();
        pathA.add(field);
        pathA.add(field);
        pathA.add(new Field(0, 0));
        pathA.add(field);
        pathA.add(field);

        Assert.assertTrue(pathA.containsSamePlayerOnly());

        pathA.add(field2);

        Assert.assertFalse(pathA.containsSamePlayerOnly());
    }

}
