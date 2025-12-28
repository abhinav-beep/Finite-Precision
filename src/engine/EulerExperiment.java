package engine;

import complex.Complex;

import java.math.BigDecimal;
import java.math.MathContext;

public class EulerExperiment {

    public static void main(String[] args) {

        MathContext mc = new MathContext(10);

        Complex a = new Complex(
                new BigDecimal("1.0"),
                new BigDecimal("2.0")
        );

        Complex b = new Complex(
                new BigDecimal("3.0"),
                new BigDecimal("4.0")
        );

        Complex result = a.multiply(b, mc);

        System.out.println(result);
    }
}
