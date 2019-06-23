import java.util.HashMap;
import java.util.Map;

public class Sudko {
	static boolean sudoku2(char[][] grid) {
		boolean svalid = false;
		svalid = rowColValidator(grid);
		if(svalid)
		svalid = gridValidator(grid);
		return svalid;
	}

	private static boolean gridValidator(char[][] grid) {
		int xlimit = 3, yLimit = 3;
		HashMap<Character, Integer> mpGrid = new HashMap<>();
		int xPosition = 0, yPosition = 0;
		for (int t = 0; t < grid.length; t++) {
			for (int x = xPosition; x < xlimit; x++) {
				for (int y = yPosition; y < yLimit; y++) {
					if (grid[x][y] != '.') {
						if (mpGrid.containsKey(grid[x][y])) {
							mpGrid.put(grid[x][y], mpGrid.get(grid[x][y]) + 1);
						} else {
							mpGrid.put(grid[x][y], 1);
						}
					}
				}
			}
			if (mpGrid.entrySet().stream().map(Map.Entry::getValue).anyMatch(tt -> tt > 1)){
				return false;
			}
			mpGrid.clear();
			yLimit += 3;
			yPosition += 3;
			if(yPosition >= grid.length) {
				yPosition = 0;
				yLimit = 3;
				xPosition += 3; xlimit += 3;
			}
			if(xPosition >= grid.length) {
				break;
			}
		}
		return true;
	}

	static boolean rowColValidator(char[][] grid) {
		HashMap<Character, Integer> mpRow = new HashMap<>();
		HashMap<Character, Integer> mpCol = new HashMap<>();
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[x].length; y++) {
				if (grid[x][y] != '.') {
					if (mpRow.containsKey(grid[x][y])) {
						mpRow.put(grid[x][y], mpRow.get(grid[x][y]) + 1);
					} else {
						mpRow.put(grid[x][y], 1);
					}
				}
				if (grid[y][x] != '.') {
					if (mpCol.containsKey(grid[y][x])) {
						mpCol.put(grid[y][x], mpCol.get(grid[y][x]) + 1);
					} else {
						mpCol.put(grid[y][x], 1);
					}
				}
			}
			if (mpRow.entrySet().stream().map(Map.Entry::getValue).anyMatch(tt -> tt > 1)
					|| mpCol.entrySet().stream().map(Map.Entry::getValue).anyMatch(tt -> tt > 1))
				return false;
			else {
				mpRow.clear(); mpCol.clear();
			}
		}
		return true;
	}
}
