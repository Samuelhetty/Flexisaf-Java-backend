package digitalclock.modes;

public class Stopwatch implements ClockMode {
    private volatile boolean running = false;
    private long startTime = 0;
    private long elapsedTime = 0;

    @Override
    public void start() {
        if (!running) {
            running = true;
            startTime = System.currentTimeMillis() - elapsedTime;
            Thread thread = new Thread(() -> {
                while (running) {
                    long time = System.currentTimeMillis() - startTime;
                    System.out.println("Stopwatch: " + time / 1000 + "s");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            thread.start();
        }
    }

    @Override
    public void stop() {
        running = false;
        elapsedTime = System.currentTimeMillis() - startTime;
    }

    @Override
    public void reset() {
        running = false;
        startTime = 0;
        elapsedTime = 0;
        System.out.println("Stopwatch reset.");
    }
}
