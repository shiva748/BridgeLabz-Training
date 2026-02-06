import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ThreadStateMonitoringSystem {

    public static void main(String[] args) {

        TaskRunner task1 = new TaskRunner("Task-1");
        TaskRunner task2 = new TaskRunner("Task-2");

        StateMonitor monitor = new StateMonitor(task1, task2);

        monitor.start();

        try { Thread.sleep(200); } catch (InterruptedException e) {}

        task1.start();
        task2.start();
    }
}

class TaskRunner extends Thread {

    public TaskRunner(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);

            long sum = 0;
            for (int i = 0; i < 5_000_000; i++) {
                sum += i;
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

class StateMonitor extends Thread {

    private Thread t1;
    private Thread t2;

    private Map<String, Set<Thread.State>> stateHistory = new HashMap<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public StateMonitor(Thread t1, Thread t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public void run() {

        while (true) {
            monitorThread(t1);
            monitorThread(t2);

            if (t1.getState() == Thread.State.TERMINATED &&
                    t2.getState() == Thread.State.TERMINATED) {

                printSummary();
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void monitorThread(Thread t) {
        String name = t.getName();
        Thread.State state = t.getState();
        String time = LocalTime.now().format(formatter);

        System.out.println("[Monitor] " + name + " is in " + state + " state at " + time);

        stateHistory
                .computeIfAbsent(name, k -> new HashSet<>())
                .add(state);
    }

    private void printSummary() {
        System.out.println("\nSummary of state changes:");
        for (String threadName : stateHistory.keySet()) {
            int totalStates = stateHistory.get(threadName).size();
            System.out.println("Summary: " + threadName + " went through " + totalStates + " states");
        }
    }
}
