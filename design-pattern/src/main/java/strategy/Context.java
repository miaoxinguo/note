package strategy;

import java.math.BigDecimal;

/**
 * 计费场景类，业务方法使用该类
 *
 * 为什么不是直接调用策略类而是将策略类交给Context类来启动呢？ 为了更灵活的增加一些逻辑
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
