import java.util.Arrays;

public class BoxBlurAlgorithm {
	static int[][] boxBlur(int[][] image) {
		int gridLength = image.length < 3 ? image.length : 3;
		int limitOutPutForRow = image.length - 2;
		int limitOfOutPutForCol = image[0].length - 2;
		int[][] blurBox = new int[limitOutPutForRow][limitOfOutPutForCol];
		for (int x = 0; x < blurBox.length; x++) {
			for (int y = 0; y < blurBox[x].length; y++) {
				double countSum = 0;
				for (int z = x; z < gridLength + x; z++) {
					for (int a = y; a < gridLength + y; a++) {
						countSum += image[z][a];
					}
				}
				countSum /= 9;
				blurBox[x][y] = (int) countSum;
			}
		}

		return blurBox;

	}

	public static void main(String[] args) {
		System.out.println(Arrays
				.deepToString(boxBlur(new int[][] { 
					
					{36,0,18,9}, 
					 {27,54,9,0}, 
					 {81,63,72,45}
		})));
	}

}
