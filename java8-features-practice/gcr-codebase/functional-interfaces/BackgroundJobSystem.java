public class BackgroundJobSystem {

	public static void main(String[] args) {

		Runnable job1 = () -> {
			System.out.println("Background job 1 started.");
			doWork();
			System.out.println("Background job 1 completed.");
		};

		Runnable job2 = () -> {
			System.out.println("Background job 2 started.");
			doWork();
			System.out.println("Background job 2 completed.");
		};

		Runnable job3 = () -> {
			System.out.println("Background job 3 started.");
			doWork();
			System.out.println("Background job 3 completed.");
		};

		runJob(job1);
		runJob(job2);
		runJob(job3);
	}

	public static void runJob(Runnable job) {

		Thread t = new Thread(job);
		t.start();
	}

	public static void doWork() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}
}
