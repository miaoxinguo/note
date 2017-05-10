import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class TestNumberUtils {

    @Test
    public void testNumberUtils() {

        Assert.assertFalse(NumberUtils.isDigits(null));
        Assert.assertFalse(NumberUtils.isNumber(null));

        Assert.assertFalse(NumberUtils.isDigits(StringUtils.EMPTY));
        Assert.assertFalse(NumberUtils.isNumber(StringUtils.EMPTY));

        String a = "1.23";
        Assert.assertFalse(NumberUtils.isDigits(a));
        Assert.assertTrue(NumberUtils.isNumber(a));

        String b = "-1.23";
        Assert.assertFalse(NumberUtils.isDigits(b));
        Assert.assertTrue(NumberUtils.isNumber(b));
    }
}
