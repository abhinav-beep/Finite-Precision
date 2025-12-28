package complex;

import java.math.BigDecimal;
import java.math.MathContext;

public class Complex {

    private final BigDecimal re;
    private final BigDecimal im;

    public Complex(BigDecimal re, BigDecimal im) {
        this.re = re;
        this.im = im;
    }

    public BigDecimal real() {
        return re;
    }

    public BigDecimal imag() {
        return im;
    }

    public Complex add(Complex other, MathContext mc) {
        return new Complex(
                this.re.add(other.re, mc),
                this.im.add(other.im, mc)
        );
    }

    public Complex subtract(Complex other, MathContext mc) {
        return new Complex(
                this.re.subtract(other.re, mc),
                this.im.subtract(other.im, mc)
        );
    }

    public Complex multiply(Complex other, MathContext mc) {
        BigDecimal realPart = this.re.multiply(other.re, mc)
                .subtract(this.im.multiply(other.im, mc), mc);

        BigDecimal imagPart = this.re.multiply(other.im, mc)
                .add(this.im.multiply(other.re, mc), mc);

        return new Complex(realPart, imagPart);
    }

    public BigDecimal magnitude(MathContext mc) {
        BigDecimal re2 = re.multiply(re, mc);
        BigDecimal im2 = im.multiply(im, mc);
        return re2.add(im2, mc).sqrt(mc);
    }

    @Override
    public String toString() {
        if (im.signum() >= 0) {
            return re + " + " + im + "i";
        } else {
            return re + " - " + im.abs() + "i";
        }
    }
}
