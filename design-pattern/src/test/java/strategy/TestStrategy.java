package strategy;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 测试策略模式
 */
public class TestStrategy {

    @Test
    public void testIn() {
        Context context = new Context(new FeeStrategyIn());

        Assert.assertEquals(BigDecimal.TEN, context.getFee());
    }

    @Test
    public void testSg() {
        Context context = new Context(new FeeStrategySg());

        Assert.assertEquals(BigDecimal.ONE, context.getFee());
    }
}
