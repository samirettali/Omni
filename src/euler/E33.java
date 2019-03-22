package euler;

import math.Fraction;

public class E33 {

    public static void start() {
        Fraction result = new Fraction(1, 1);
        for (int numerator = 10; numerator < 100; numerator++) {
            for (int denominator = numerator + 1; denominator < 100; denominator++) {
                TwoNumberFraction fraction = new TwoNumberFraction(numerator, denominator);
                for (TwoNumberFraction sim : fraction.simplify()) {
                    if (sim.getDenominator() != 0 && sim.getValue() == fraction.getValue())
                        result = result.mul(new Fraction(numerator, denominator));
                }
            }
        }
        System.out.println(result.simplify().getDenominator());;
    }
}
