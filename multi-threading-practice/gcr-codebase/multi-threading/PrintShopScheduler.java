public class PrintShopScheduler {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting print jobs...");

        long startTime = System.currentTimeMillis();

        Printer printer = new Printer();

        Thread j1 = new Thread(new PrintJob("Job1", 10, 5, printer), "Job1-Thread");
        Thread j2 = new Thread(new PrintJob("Job2", 5, 8, printer), "Job2-Thread");
        Thread j3 = new Thread(new PrintJob("Job3", 15, 3, printer), "Job3-Thread");
        Thread j4 = new Thread(new PrintJob("Job4", 8, 6, printer), "Job4-Thread");
        Thread j5 = new Thread(new PrintJob("Job5", 12, 7, printer), "Job5-Thread");

        j1.setPriority(5);
        j2.setPriority(8);
        j3.setPriority(3);
        j4.setPriority(6);
        j5.setPriority(7);

        j1.start();
        j2.start();
        j3.start();
        j4.start();
        j5.start();

        j1.join();
        j2.join();
        j3.join();
        j4.join();
        j5.join();

        long endTime = System.currentTimeMillis();

        System.out.println("All jobs completed in " + (endTime - startTime) + "ms");
    }
}

class Printer {
    public synchronized void print(String jobName, int pages, String priorityLabel) {
        for (int i = 1; i <= pages; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("[" + priorityLabel + "] Printing " +
                    jobName + " - Page " + i + " of " + pages);
        }
    }
}

class PrintJob implements Runnable {

    private String jobName;
    private int pages;
    private int priority;
    private Printer printer;

    public PrintJob(String jobName, int pages, int priority, Printer printer) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
        this.printer = printer;
    }

    @Override
    public void run() {
        String label = getPriorityLabel(priority);
        printer.print(jobName, pages, label);
    }

    private String getPriorityLabel(int priority) {
        if (priority >= 8) return "High Priority";
        if (priority >= 5) return "Medium Priority";
        return "Low Priority";
    }
}
