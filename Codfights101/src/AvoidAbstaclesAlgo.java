import java.util.stream.IntStream;

public class AvoidAbstaclesAlgo {
	static int avoidObstacles(int[] inputArray) {
		int hop = 2;
		int maxNumber = IntStream.of(inputArray).max().orElse(0);
		
		for(; hop<=maxNumber; ) {
			int temp = hop;
			if(IntStream.of(inputArray).filter(t -> t%temp == 0).count() != 0) {
				hop++;
			}else break;
		}
		return hop;
	}

	
	public static void main(String[] args) {
		System.out.println(avoidObstacles(new int [] {3,5,6,7,9}));
	}
}
