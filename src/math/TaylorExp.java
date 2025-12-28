package math;

import util.PrecisionContext;

import java.math.BigDecimal;
import java.math.MathContext;

public class TaylorExp {

    public static BigDecimal exp(BigDecimal x, PrecisionContext pc) {

        MathContext mc = pc.mc();

        BigDecimal sum = BigDecimal.ONE;      // 1
        BigDecimal term = BigDecimal.ONE;     // current term
        int n = 1;

        while (n <= pc.maxIterations()) {

            // term = term * x / n
            term = term.multiply(x, mc)
                    .divide(BigDecimal.valueOf(n), mc);

            sum = sum.add(term, mc);

            // stopping condition
            if (term.abs().compareTo(pc.epsilon()) < 0) {
                break;
            }

            n++;
        }

        return sum;
    }
}
