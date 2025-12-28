package math;

import util.PrecisionContext;

import java.math.BigDecimal;
import java.math.MathContext;

public class TaylorSin {

    public static BigDecimal sin(BigDecimal x, PrecisionContext pc) {

        MathContext mc = pc.mc();

        BigDecimal sum = x;          // first term: x
        BigDecimal term = x;         // current term
        BigDecimal x2 = x.multiply(x, mc);

        int n = 1;

        while (n <= pc.maxIterations()) {

            // term *= -x^2 / ((2n)(2n+1))
            BigDecimal denominator = BigDecimal.valueOf(2L * n)
                    .multiply(BigDecimal.valueOf(2L * n + 1), mc);

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
