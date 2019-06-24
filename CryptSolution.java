import java.util.HashMap;

public class CryptSolution {

	static long getVal(char[] data, HashMap<Character, Character> map) {
		String valS = "";
		for (char c : data) {
			valS += map.get(c);
		}
		if (valS.length() > 1 && valS.startsWith("0"))
			return Integer.MIN_VALUE;
		return Long.parseLong(valS);
	}

	static boolean isCryptSolution(String[] crypt, char[][] solution) {
		if (crypt.length != 3)
			return false;
		HashMap<Character, Character> map = new HashMap<>();
		for (int x = 0; x < solution.length; x++)
			for (int y = 0; y < solution[x].length - 1;)
				map.put(solution[x][y], solution[x][++y]);
		long sum = 0;
		for (int y = 0; y < crypt.length - 1; y++) {
			sum += getVal(crypt[y].toCharArray(), map);
		}
		return sum == getVal(crypt[crypt.length - 1].toCharArray(), map);
	}

}
