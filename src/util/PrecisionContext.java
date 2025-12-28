package util;

import java.math.MathContext;
import java.math.RoundingMode;
import java.math.BigDecimal;

public class PrecisionContext {

    private final MathContext mathContext;
    private final BigDecimal epsilon;
    private final int maxIterations;

    public PrecisionContext(int precision, int maxIterations) {
        this.mathContext = new MathContext(precision, RoundingMode.HALF_UP);
        this.epsilon = BigDecimal.ONE.scaleByPowerOfTen(-precision);
        this.maxIterations = maxIterations;
    }

    public MathContext mc() {
        return mathContext;
    }

    public BigDecimal epsilon() {
        return epsilon;
    }

    public int maxIterations() {
        return maxIterations;
    }
}
