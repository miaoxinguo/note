package strategy;

import java.math.BigDecimal;

/**
 * 费用策略接口，定义标准计费方法
 */
public interface FeeStrategy {

    BigDecimal getFee();
}
