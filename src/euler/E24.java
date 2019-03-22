package euler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static math.Functions.factorial;

/**
 * Created by Sam on 29/03/2017.
 */
public class E24 {

    public static void permutingArray(ArrayList<String> permutations, List<Integer> arrayList, int element) {
        for (int i = element; i < arrayList.size(); i++) {
            java.util.Collections.swap(arrayList, i, element);
            permutingArray(permutations, arrayList, element + 1);
            java.util.Collections.swap(arrayList, element, i);
        }
        if (element == arrayList.size() - 1) {
            permutations.add(arrayList.toString());
        }
    }

    public static String nthPermutation(ArrayList<Integer> elements, int position) {
        position--;
        String permutation = "";
        ArrayList<Integer> used = new ArrayList<Integer>();
        Collections.sort(elements);
        int size = elements.size(), x = 0, i;
        for (i = 1; i <= size; i++) {
            x = position / (int) factorial(size - i);
            position %= factorial(size - i);
            permutation += elements.remove(x);

        }

        return permutation;
    }

    public static void start() {
        ArrayList<Integer> elements = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            elements.add(i);

        System.out.println(nthPermutation(elements, 1000000));
    }
}
