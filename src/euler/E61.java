package euler;

import java.util.HashSet;

import static math.Properties.isSquare;
import static math.Properties.isTriangular;
import static math.Properties.isPentagonal;
import static math.Properties.isHexagonal;
import static math.Properties.isHeptagonal;
import static math.Properties.isOctagonal;

public class E61 {

    public static void start() {
        HashSet<Integer> triangles = new HashSet<Integer>();
        HashSet<Integer> squares = new HashSet<Integer>();
        HashSet<Integer> pentagonals = new HashSet<Integer>();
        HashSet<Integer> hexagonals = new HashSet<Integer>();
        HashSet<Integer> heptagonals = new HashSet<Integer>();
        HashSet<Integer> octagonals = new HashSet<Integer>();

        for (Integer i = 1000; i < 10000; i++) {
            if (isTriangular(i))
                triangles.add(i);
            if (isSquare(i))
                squares.add(i);
            if (isPentagonal(i))
                pentagonals.add(i);
            if (isHexagonal(i))
                hexagonals.add(i);
            if (isHeptagonal(i))
                heptagonals.add(i);
            if (isOctagonal(i))
                octagonals.add(i);
        }

        for (int triangular : triangles) {
            int lastTwoTriangle = triangular % 100;
            for (int square : squares) {
                int firstTwoSquare = square / 100;
                if (lastTwoTriangle == firstTwoSquare) {
                    int lastTwoSquare = square % 100;
                    for (int pentagonal : pentagonals) {
                        int firstTwoPentagonal = pentagonal / 100;
                        if (lastTwoSquare == firstTwoPentagonal) {
                            int lastTwoPentagonal = pentagonal % 100;
                                // for (int tri : triangles) {
                                    if (lastTwoPentagonal == triangular / 100)
                                        System.out.println(triangular + " " + square + " " + pentagonal);
                                // }

                        }
                    }
                }
            }

        }

        System.out.println("TRI " + triangles);
        System.out.println("SQU " + squares);
        System.out.println("PEN " + pentagonals);
        System.out.println(hexagonals);
        System.out.println(heptagonals);
        System.out.println(octagonals);

    }
}
