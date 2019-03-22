package recursive;

public class Hanoi {

    public static void moveTower(int n, int da, int a, int aux) {
        if (n > 0) {
            moveTower(n - 1, da, aux, a);
            moveDisc(da, a);
            moveTower(n - 1, aux, a, da);
        }
    }

    public static void moveDisc(int from, int to) {
        System.out.println(from + " -> " + to);
    }

    public static void hanoi(int n) {
        moveTower(n, 1, 3, 2);
    }
}
