package digitalclock.modes;

import java.time.LocalTime;

public class Watch implements ClockMode {
    private volatile boolean running = false;

    @Override
    public void start() {
        running = true;
        Thread thread = new Thread(() -> {
            while (running) {
                System.out.println("Current Time: " + LocalTime.now().withNano(0));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public void reset() {
        System.out.println("Watch mode does not require reset.");
    }
}
