package strategy;

import java.math.BigDecimal;

/**
 * 具体的策略实现类 - 新加坡的计费策略
 */
public class FeeStrategySg implements FeeStrategy {

    public BigDecimal getFee() {
        /*
         * 一些具体的费率计算规则代码
         */
        System.out.println("按新加坡计费规则计算...");
        return BigDecimal.ONE;
    }
}
