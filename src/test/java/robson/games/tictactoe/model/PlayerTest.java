package robson.games.tictactoe.model;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void shouldControlItsCreation() {
        Player player = new Player('C');
        Assert.assertNotEquals(new Player('c'), player);
        Assert.assertEquals(new Player('C'), player);
        Assert.assertTrue(player.isHuman());
        Assert.assertFalse(new Player('X', false).isHuman());
    }
}
