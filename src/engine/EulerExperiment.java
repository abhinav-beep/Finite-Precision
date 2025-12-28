import math.TaylorExp;
import util.PrecisionContext;

import java.math.BigDecimal;

public class EulerExperiment {

    public static void main(String[] args) {

        PrecisionContext pc = new PrecisionContext(20, 1000);

        BigDecimal x = new BigDecimal("1.0");
        BigDecimal result = TaylorExp.exp(x, pc);

        System.out.println("e ≈ " + result);
    }
}
