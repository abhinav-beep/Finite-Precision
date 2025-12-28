package math;

import complex.Complex;
import util.PrecisionContext;

import java.math.BigDecimal;

public class ComplexExp {

    public static Complex expI(BigDecimal theta, PrecisionContext pc) {

        BigDecimal real = TaylorCos.cos(theta, pc);
        BigDecimal imag = TaylorSin.sin(theta, pc);

        return new Complex(real, imag);
    }
}
