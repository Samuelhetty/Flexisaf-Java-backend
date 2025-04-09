package digitalclock.modes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TimerMode implements ClockMode {
    private volatile boolean running = false;
    private long timeLeft;
    private ExecutorService executor;

    public TimerMode(long seconds) {
        this.timeLeft = seconds;
    }

    @Override
    public void start() {
        if (!running) {
            running = true;
            executor = Executors.newSingleThreadExecutor();
            executor.execute(() -> {
                while (timeLeft > 0 && running) {
                    System.out.println("Timer: " + timeLeft + "s left");
                    timeLeft--;
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (timeLeft == 0) {
                    System.out.println("Time's up!");
                }
            });
        }
    }

    @Override
    public void stop() {
        running = false;
        if (executor != null) {
            executor.shutdownNow();
        }
    }

    @Override
    public void reset() {
        stop();
        System.out.println("Timer reset. Set new time to start.");
    }
}
