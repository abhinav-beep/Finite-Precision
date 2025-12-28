package math;

import util.PrecisionContext;

import java.math.BigDecimal;
import java.math.MathContext;

public class TaylorCos {

    public static BigDecimal cos(BigDecimal x, PrecisionContext pc) {

        MathContext mc = pc.mc();

        BigDecimal sum = BigDecimal.ONE;   // first term: 1
        BigDecimal term = BigDecimal.ONE;  // current term
        BigDecimal x2 = x.multiply(x, mc);

        int n = 1;

        while (n <= pc.maxIterations()) {

            // term *= -x^2 / ((2n-1)(2n))
            BigDecimal denominator = BigDecimal.valueOf(2L * n - 1)
                    .multiply(BigDecimal.valueOf(2L * n), mc);

            term = term.multiply(x2, mc)
                    .divide(denominator, mc)
                    .negate();

            sum = sum.add(term, mc);

            if (term.abs().compareTo(pc.epsilon()) < 0) {
                break;
            }

            n++;
        }

        return sum;
    }
}
