package misc;

public class DeBruijn {

    public static String deBruijn(int k, int n) {
        StringBuilder sequence = new StringBuilder();
        generateLyndonWords(1, 1, k, new int[n + 1], sequence);
        return sequence.toString();
    }

    private static void generateLyndonWords(int t, int p, int k, int[] a, StringBuilder sequence) {
        if (t > a.length - 1) {
            if ((a.length - 1) % p == 0) {
                for (int i = 1; i < p + 1; i++) {
                    sequence.append(a[i]);
                }
            }
        } else {
            a[t] = a[t - p];
            generateLyndonWords(t + 1, p, k, a, sequence);
            for (int j = a[t - p] + 1; j <= k - 1; j++) {
                a[t] = j;
                generateLyndonWords(t + 1, t, k, a, sequence);
            }
        }
    }
}

