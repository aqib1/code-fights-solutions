import java.util.HashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PalindromeRearrange {
	
	int arrayMaximalAdjacentDifference(int[] inputArray) {
		int diff = Integer.MIN_VALUE;
		for(int x = 0; x < inputArray.length-1; x++) {
			int tempdiff = inputArray[x] - inputArray[x+1];
			if(diff < tempdiff) {
				diff = Math.abs(tempdiff);
			}
		}
		return diff;
	}

	boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
		return Math.max(yourLeft, yourRight) == Math.max(friendsLeft, friendsRight)
				&& Math.min(yourLeft, yourRight) == Math.min(friendsLeft, friendsRight);
	}

	String longestString(String[] inputArray) {

		return Stream.of(inputArray).max((x, y) -> x.length() - y.length()).orElse("");
	}

	static boolean palindromeRearranging(String inputString) {
		if (inputString.length() == 1)
			return true;
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : inputString.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		if (map.size() == 1) {
			return true;
		}

		if (inputString.length() % 2 == 0) {
			return getCountByFilterOverValue(map, x -> x % 2 == 0) == inputString.length();
		} else {
			long oddCount = getCountByFilterOverValue(map, x -> x % 2 != 0);
			return map.entrySet().stream().map(x -> x.getValue()).filter(x -> x % 2 != 0).count() == 1
					&& getCountByFilterOverValue(map, x -> x % 2 == 0) == inputString.length() - oddCount;
		}
	}

	static long getCountByFilterOverValue(HashMap<Character, Integer> map, Predicate<Integer> predicate) {
		return map.entrySet().stream().map(x -> x.getValue()).filter(predicate)
				.collect(Collectors.summingInt(Integer::intValue));
	}

	public static void main(String[] args) {
		System.out.println(palindromeRearranging("aaaabbbcccc"));
	}
}
