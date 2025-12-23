import java.util.Arrays;
public class FootballTeam {
	public static int sum(int[] heights) {
		int s = 0;
		for (int i = 0; i < heights.length; i++)
			s += heights[i];
		return s;
	}
	public static double mean(int[] heights) {
		return (double) sum(heights) / heights.length;
	}
	public static int shortest(int[] heights) {
		int min = Integer.MAX_VALUE;
		for (int h : heights)
			if (h < min)
				min = h;
		return min;
	}
	public static int tallest(int[] heights) {
		int max = Integer.MIN_VALUE;
		for (int h : heights)
			if (h > max)
				max = h;
		return max;
	}
	public static int randomHeight() {
		return (int) (Math.random() * 101) + 150;
	}
	public static void main(String[] args) {
		int[] heights = new int[11];
		for (int i = 0; i < heights.length; i++)
			heights[i] = randomHeight();
		System.out.println("Heights: " + Arrays.toString(heights));
		System.out.printf("Sum of heights = %d%n", sum(heights));
		System.out.printf("Mean height = %.2f cm%n", mean(heights));
		System.out.printf("Shortest height = %d cm%n", shortest(heights));
		System.out.printf("Tallest height = %d cm%n", tallest(heights));
	}
}