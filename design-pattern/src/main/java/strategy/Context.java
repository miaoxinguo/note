package strategy;

import java.math.BigDecimal;

/**
 * 计费场景类，业务方法使用该类
 */
public class Context {

    // 保持一个计费策略的引用, 由业务类负责注入(construct or set)具体的策略实现
    private FeeStrategy feeStrategy;

    public Context() {
    }

    public Context(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    /**
     * 由业务方法调用
     */
    public BigDecimal getFee() {
        return feeStrategy.getFee();
    }
}
