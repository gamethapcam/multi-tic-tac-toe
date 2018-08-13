package robson.games.tictactoe.utils;

import org.junit.Assert;
import org.junit.Test;

public class NumberUtilsTest {

    @Test
    public void shouldConfirmAValidNumber() {
        Assert.assertTrue(NumberUtils.isNumeric("10"));
        Assert.assertFalse(NumberUtils.isNumeric("a"));
    }

}
