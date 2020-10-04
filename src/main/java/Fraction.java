public class Fraction implements IFraction {

    private final Integer numerator;
    private final Integer denominator;

    public Fraction(Integer numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        if (denominator == 0) throw new ArithmeticException("Cannot Divide by 0");
    }

    @Override
    public Integer getNumerator() {
        return numerator;
    }

    @Override
    public Integer getDenominator() {
        return denominator;
    }

    @Override
    public IFraction plus(IFraction other) {
        int finalNum = (getNumerator() *  other.getDenominator()) + (other.getNumerator() * getDenominator());
        int finalDen = getDenominator() * other.getDenominator();

        return createNormalised(finalNum, finalDen);

    }

    @Override
    public IFraction minus(IFraction other) {
        int finalNum = (getNumerator() *  other.getDenominator()) - (other.getNumerator() * getDenominator());
        int finalDen = getDenominator() * other.getDenominator();

        return createNormalised(finalNum, finalDen);
    }

    @Override
    public IFraction times(IFraction other) {
        int finalNum = getNumerator() * other.getNumerator();
        int finalDen = getDenominator() * other.getDenominator();

        return createNormalised(finalNum, finalDen);
    }

    @Override
    public IFraction dividedBy(IFraction other) {
        int finalNum = getNumerator() * other.getDenominator();
        int finalDen = other.getNumerator() * getDenominator();

        return createNormalised(finalNum, finalDen);
    }


    public static int getGcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return  getGcd(n2, n1 % n2);
    }

    public static Fraction createNormalised(Integer numerator, Integer denominator) {
        var gcd = getGcd(numerator, denominator);

        return new Fraction(numerator / gcd, denominator/ gcd);
    }

    @Override
    public String toString() {
        return "Fraction " + numerator + "|" + denominator;
    }
}