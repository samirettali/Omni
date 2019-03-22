package misc;

import java.math.BigDecimal;

/**
 * Created by Sam on 22/03/2017.
 */
public class Feigenbaum {

    // population growht simulation
    // formula x[n+1] = fertility * x[n] * (1 - x[n])
    public static void run(double population, double fertility, int generations) {

        assert population > 0;
        assert population < 1;
        assert fertility > 0;
        assert fertility < 4;
        assert generations > 0;

        BigDecimal pop = new BigDecimal(Double.toString(population));
        BigDecimal fer = new BigDecimal(Double.toString(fertility));
        BigDecimal one = new BigDecimal("1");


        int i = 0;
        do {
            System.out.println((i + 1) + ": " + pop.toPlainString());
            pop = fer.multiply(pop).multiply(one.subtract(pop)).setScale(100, BigDecimal.ROUND_HALF_UP);
            i++;
        } while (i < generations);


    }
}
