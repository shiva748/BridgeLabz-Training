public class StringConcatenationPerformance {

	private static final int ITERATIONS = 100_000;
	private static final String TEXT = "java";

	public static void main(String[] args) {
		testStringConcatenation();
		testStringBuilder();
		testStringBuffer();
	}

	private static void testStringConcatenation() {
		String result = "";
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < ITERATIONS; i++) {
			result += TEXT;
		}

		long endTime = System.currentTimeMillis();
		System.out.println("String Time: " + (endTime - startTime) + " ms");
	}

	private static void testStringBuilder() {
		StringBuilder builder = new StringBuilder();
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < ITERATIONS; i++) {
			builder.append(TEXT);
		}

		long endTime = System.currentTimeMillis();
		System.out.println("StringBuilder Time: " + (endTime - startTime) + " ms");
	}

	private static void testStringBuffer() {
		StringBuffer buffer = new StringBuffer();
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < ITERATIONS; i++) {
			buffer.append(TEXT);
		}

		long endTime = System.currentTimeMillis();
		System.out.println("StringBuffer Time: " + (endTime - startTime) + " ms");
	}
}
