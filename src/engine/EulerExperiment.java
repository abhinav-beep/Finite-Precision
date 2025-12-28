package engine;

import complex.Complex;
import math.ComplexExp;
import util.PrecisionContext;

import java.math.BigDecimal;

public class EulerExperiment {

    public static void main(String[] args) {

        // 1️⃣ Define numerical rules
        PrecisionContext pc = new PrecisionContext(20, 1000);

        // 2️⃣ Define π (hardcoded for now)
        BigDecimal pi = new BigDecimal("3.141592653589793");

        // 3️⃣ Compute e^(iπ)
        Complex expIpi = ComplexExp.expI(pi, pc);

        // 4️⃣ Add 1
        Complex result = expIpi.add(
                new Complex(BigDecimal.ONE, BigDecimal.ZERO),
                pc.mc()
        );

        // 5️⃣ Print result
        System.out.println("e^(iπ) + 1 ≈ " + result);
        System.out.println("Magnitude of error ≈ " + result.magnitude(pc.mc()));
    }
}
