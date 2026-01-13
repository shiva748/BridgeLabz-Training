import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.learn.Performance;

import java.util.concurrent.TimeUnit;

class PerformanceTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void longRunningTask_shouldFailIfExecutionExceedsTimeout() throws InterruptedException {
        Performance performance = new Performance();
        performance.longRunningTask();
    }
}
