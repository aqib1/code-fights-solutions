import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class DegreeOfArraySmallestSubArrayLength {
	
	public static int degreeOfArray(List<Integer> arr) {
		// Write your code here
		HashMap<Integer, Integer> leftIndexes = new HashMap<>();
		HashMap<Integer, Integer> rightIndexes = new HashMap<>();
		HashMap<Integer, Integer> count = new HashMap<>();
		int smallestLength = arr.size();
		
		for(int x = 0; x < arr.size(); x++) {
			if(!leftIndexes.containsKey(arr.get(x))) {
				leftIndexes.put(arr.get(x), x);
			}
			rightIndexes.put(arr.get(x), x);
			count.put(arr.get(x), count.getOrDefault(arr.get(x), 0) + 1);
		}
		
		int degree = Collections.max(count.values());
		
		Entry<Integer, Integer> entry = count.entrySet()
				.stream()
				.filter(x-> x.getValue() == degree)
				.findFirst()
				.orElse(null);
		smallestLength = Math.min(smallestLength, 
				rightIndexes.get(entry.getKey()) - leftIndexes.get(entry.getKey()) + 1);
		
		return smallestLength;
	}
	public static void main(String[] args) {
		System.out.println(degreeOfArray(new ArrayList<>(Arrays.asList(1,2,2,3,1,4,2))));
	}
}
