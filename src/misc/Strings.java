package misc;

import java.util.ArrayList;
import java.util.Arrays;

public class Strings {

    public static boolean isPalindrome(String s) {
        // TODO len / 2
        int len = s.length();

        for (int i = 0; i < len / 2; i++)
            if (s.charAt(i) != s.charAt(len - (i + 1)))
                return false;

        return true;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end && s.charAt(start) == s.charAt(end))
            System.out.println(s.charAt(start++) + " " + s.charAt(end--));
        return start >= end;
    }

    public static ArrayList<String> permutations(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s.length() == 1) {
            res.add(s);
        } else if (s.length() > 1) {
            int lastIndex = s.length() - 1;

            String last = s.substring(lastIndex);
            String rest = s.substring(0, lastIndex);
            res = merge(permutations(rest), last);
        }
        return res;
    }

    private static ArrayList<String> merge(ArrayList<String> list, String c) {
        ArrayList<String> res = new ArrayList<String>();
        for (String s : list) {
            for (int i = 0; i <= s.length(); ++i) {
                String ps = new StringBuffer(s).insert(i, c).toString();
                res.add(ps);
            }
        }
        return res;
    }

    public static ArrayList<String> rotations(String s) {
        ArrayList<String> rots = new ArrayList<String>();
        rots.add(s);
        for (int i = 0; i < s.length() - 1; i++) {
            s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
            rots.add(s);
        }
        return rots;
    }

    public static long concatLong(long a, long b) {
        long c = b;
        while (c > 0) {
            a *= 10;
            c /= 10;
        }
        return a + b;
    }

    public static boolean isPalindrome(String... s) {
        char[][] c = new char[s.length][];

        for (int i = 0; i < s.length; i++) {
            c[i] = s[i].toCharArray();
            Arrays.sort(c[i]);
        }

        for (int i = 0; i < c.length - 1; i++)
            for (int j = 0; j < c[0].length; j++)
                if (c[i].length != c[i + 1].length || c[i][j] != c[i + 1][j])
                    return false;

        return true;
    }

    public static String reverse(String s) {
        String r = "";

        for (int i = s.length() - 1; i >= 0; i--)
            r += s.charAt(i);

        return r;
    }

    public static int countOccurences(String s, char c) {
        int count = 0;

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == c)
                count++;

        return count;
    }

    public static boolean isPermutation(String... s) {
        char[][] charArray = new char[s.length][];

        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = s[i].toCharArray();
            Arrays.sort(charArray[i]);
        }

        for (int i = 0; i < charArray.length - 1; i++)
            for (int j = 0; j < charArray[i].length; j++)
                if (charArray[i][j] != charArray[i + 1][j])
                    return false;

        return true;
    }

}
