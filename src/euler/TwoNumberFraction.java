package euler;

import java.util.ArrayList;

/**
 * @author Samir Ettali
 **/
public class TwoNumberFraction {
    private int numerator;
    private int denominator;

    public TwoNumberFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public double getValue() {
        if (denominator != 0)
            return ((double) numerator) / ((double) denominator);
        else
            return -1;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public ArrayList<TwoNumberFraction> simplify() {
        ArrayList<TwoNumberFraction> simplifiedFractions = new ArrayList<>();
        if (numerator / 10 == denominator / 10)
            simplifiedFractions.add(new TwoNumberFraction(numerator % 10, denominator % 10));
        if (numerator % 10 != 0 && denominator % 10 != 0 && numerator % 10 == denominator % 10)
            simplifiedFractions.add(new TwoNumberFraction(numerator / 10, denominator / 10));
        if (numerator / 10 == denominator % 10)
            simplifiedFractions.add(new TwoNumberFraction(numerator % 10, denominator / 10));
        if (numerator % 10 == denominator / 10)
            simplifiedFractions.add(new TwoNumberFraction(numerator / 10, denominator % 10));
        return simplifiedFractions;
    }

    @Override
    public String toString() {
        return Integer.toString(numerator) + "/" + Integer.toString(denominator);
    }
}
