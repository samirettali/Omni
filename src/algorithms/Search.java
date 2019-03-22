package algorithms;
import java.util.ArrayList;

public class Search {

	public static int binarySearch(ArrayList<Integer> vector, int target, int start, int end) {
		int m;
		while (start <= end) {
			m = (start + end) / 2;
			if (vector.get(m) == target)
				return m;
			if (vector.get(m) < target)
				start = m + 1;
			if (vector.get(m) > target)
				start = m - 1;
		}
		return -1;
	}

}
