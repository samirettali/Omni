package algorithms;
import java.util.Arrays;
import misc.Stopwatch;

public class Sorting {

    public static void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++)
            for (int j = 0; j < length - i; j++)
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }

    public static void insertionSort(int[] array) {
        int v;
        int j;
        int length = array.length;
        for (int i = 1; i < length; i++) {
            v = array[i];
            j = i;
            while (j > 0 && array[j - 1] > v) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = v;
        }
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int index = start;
            int smallerCount = 0;
            int biggerCount = 0;
            int equalsCount = 0;
            int length = end - start;
            int pivotIndex = (start + end) / 2;
            int pivot = array[pivotIndex];
            int[] smaller = new int[length];
            int[] bigger = new int[length];

            for (int i = start; i <= end; i++) {
                int c = array[i] - array[pivotIndex];
                if (c < 0)
                    smaller[smallerCount++] = array[i];
                else if (c > 0)
                    bigger[biggerCount++] = array[i];
                else
                    equalsCount++;
            }

            quickSort(smaller, 0, smallerCount - 1);
            quickSort(bigger, 0, biggerCount - 1);

            for (int i = 0; i < smallerCount; i++)
                array[index++] = smaller[i];
            for (int i = 0; i < equalsCount; i++)
                array[index++] = pivot;
            for (int i = 0; i < biggerCount; i++)
                array[index++] = bigger[i];

        }
    }

    public static void bucketSort(int[] array) {
        int[] occurrences;

        int i;
        int j;
        int max = array[0];
        int length = array.length;

        for(i = 1; i < length; i++)
            if(array[i] > max)
                max = array[i];

        occurrences = new int[max + 1];

        for(i = 0; i < length; i++)
            occurrences[array[i]]++;

        i = 0;
        j = 0;
        while(i < length && j < occurrences.length) {
            int times = 0;
            while(times < occurrences[j]) {
                array[i++] = j;
                times++;
            }
            j++;
        }
    }

    public static void countingSort(int[] array) {
        int[] occurrences;

        int i;
        int j;
        int times;
        int max = array[0];
        int min = array[0];
        int length = array.length;

        for(i = 1; i < length; i++) {
            if(array[i] > max)
                max = array[i];
            else if(array[i] < min)
                min = array[i];
        }

        occurrences = new int[max - min + 1];

        for(i = 0; i < length; i++)
            occurrences[array[i] - min]++;

        i = 0;
        j = 0;
        while(j < occurrences.length) {
            while(occurrences[j] > 0) {
                array[i++] = j + min;
                occurrences[j]--;
            }
            j++;
        }
    }

    public static void gnomeSort(int[] array) {
        int i = 1;
        int j = 2;
        int length = array.length;

        while(i < length) {
            if(array[i - 1] <= array[i])
                i = j++;
            else {
                int temp = array[i - 1];
                array[i - 1] = array[i];
                array[i] = temp;
                i--;
                if(i == 0)
                    i = 1;
            }

        }
    }

    public static void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] temp, int start, int end) {
        if(start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, temp, start, middle);
            mergeSort(array, temp, middle + 1, end);
            mergeSort(array, temp, start, middle + 1, end);
        }
    }

    private static void mergeSort(int[] array, int[] temp, int start, int middle, int end) {
        int i = middle - 1;
        int j = start;
        int k = end - start + 1;

        while(start <= i && middle <= end) {
            if(array[start] <= array[middle])
                temp[j++] = array[start++];
            else
                temp[j++] = array[middle++];
        }

        while(start <= i)
            temp[j++]=array[start++];

        while(middle <= end)
            temp[j++] = array[middle++];

        for(int l = 0; l < k; l++, end--)
            array[end] = temp[end];
    }

    public static void radixSort(int[] array) {
        if(array.length == 0)
            return;
        int[][] np = new int[array.length][2];
        int[] q = new int[256];
        int i, j, k, l, f = 0;
        for(k = 0; k < 4; k++) {
            for(i = 0; i < (np.length - 1); i++)
                np[i][1] = i+1;
            np[i][1] = -1;
            for(i = 0; i < q.length; i++)
                q[i] = -1;
            for(f = i = 0; i < array.length; i++) {
                j = ((255 << (k << 3)) & array[i]) >> (k << 3);
                if(q[j] == -1)
                    l = q[j] = f;
                else {
                    l = q[j];
                    while(np[l][1] != -1)
                        l = np[l][1];
                    np[l][1] = f;
                    l = np[l][1];
                }
                f = np[f][1];
                np[l][0] = array[i];
                np[l][1] = -1;
            }
            for(l = q[i = j = 0]; i < 256; i++)
                for(l = q[i]; l != -1; l = np[l][1])
                    array[j++] = np[l][0];
        }
    }
    public static boolean isSorted(int[] array) {
        int i = 0;
        int last = array.length - 1;

        while (i < last && array[i] <= array[i + 1])
            i++;

        return i == last;
    }

    public static void benchmark(int length) {
        benchmark(length, 1000);
    }

    public static void benchmark(int length, int limit) {
        Stopwatch sw = new Stopwatch();

        int[] array = util.Array.randomPositiveIntArray(length, limit);
        int[] java = new int[length];
        int[] bubble = new int[length];
        int[] insertion = new int[length];
        int[] quick = new int[length];
        int[] bucket = new int[length];
        int[] counting = new int[length];
        int[] gnome = new int[length];
        int[] merge = new int[length];
        int[] radix = new int[length];

        System.arraycopy(array, 0, java, 0, length);
        System.arraycopy(array, 0, bubble, 0, length);
        System.arraycopy(array, 0, insertion, 0, length);
        System.arraycopy(array, 0, quick, 0, length);
        System.arraycopy(array, 0, bucket, 0, length);
        System.arraycopy(array, 0, counting, 0, length);
        System.arraycopy(array, 0, gnome, 0, length);
        System.arraycopy(array, 0, merge, 0, length);
        System.arraycopy(array, 0, radix, 0, length);

        System.out.println(String.format("%d integers\n%d limit-value\n", length, limit));
        System.out.println(String.format("%-20s %s", "ALGORITHM", "MICROSECONDS"));
        sw.start();
        Arrays.sort(java);
        System.out.println(String.format("%-20s %d", "Java default sort", sw.elapsedMicro()));
        if (!isSorted(java)) {
            System.out.println("Java default sort isn't working");
            // util.Array.print(java);
        }

        sw.start();
        bubbleSort(bubble);
        System.out.println(String.format("%-20s %d", "Bubble sort", sw.elapsedMicro()));
        if (!isSorted(bubble)) {
            System.out.println("Bubble sort isn't working");
            // util.Array.print(bubble);
        }

        sw.start();
        insertionSort(insertion);
        System.out.println(String.format("%-20s %d", "Insertion sort", sw.elapsedMicro()));
        if (!isSorted(insertion)) {
            System.out.println("Insertion sort isn't working");
            // util.Array.print(insertion);
        }

        sw.start();
        quickSort(quick);
        System.out.println(String.format("%-20s %d", "Quick sort", sw.elapsedMicro()));
        if (!isSorted(quick)) {
            System.out.println("Quick sort isn't working");
            // util.Array.print(quick);
        }

        sw.start();
        bucketSort(bucket);
        System.out.println(String.format("%-20s %d", "Bucket sort", sw.elapsedMicro()));
        if (!isSorted(bucket)) {
            System.out.println("Bucket sort isn't working");
            // util.Array.print(bucket);
        }

        sw.start();
        countingSort(counting);
        System.out.println(String.format("%-20s %d", "Counting sort", sw.elapsedMicro()));
        if (!isSorted(counting)) {
            System.out.println("Counting sort isn't working");
            // util.Array.print(counting);
        }

        sw.start();
        gnomeSort(gnome);
        System.out.println(String.format("%-20s %d", "Gnome sort", sw.elapsedMicro()));
        if (!isSorted(gnome)) {
            System.out.println("Gnome sort isn't working");
            // util.Array.print(gnome);
        }

        sw.start();
        mergeSort(merge);
        System.out.println(String.format("%-20s %d", "Merge sort", sw.elapsedMicro()));
        if (!isSorted(merge)) {
            System.out.println("Merge sort isn't working");
            // util.Array.print(merge);
        }

        sw.start();
        radixSort(radix);
        System.out.println(String.format("%-20s %d", "Radix sort", sw.elapsedMicro()));
        if (!isSorted(radix)) {
            System.out.println("Radix sort isn't working");
            // util.Array.print(radix);
        }
    }
}
