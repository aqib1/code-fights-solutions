
public class ArrayChangeCounter {

	static int arrayChange(int[] inputArray) {
		int changeCapture = 0;
		for(int x = 0; x < inputArray.length-1; x++) {
			if(inputArray[x] >= inputArray[x+1]) {
				int diff = (inputArray[x] - inputArray[x+1]) + 1;
				changeCapture += diff;
				inputArray[x+1] = inputArray[x+1] + diff;
			}
		}
		
		return changeCapture;
	}
	public static void main(String[] args) {
		System.out.println(arrayChange(new int[] {1,1,1}));
	}
}
