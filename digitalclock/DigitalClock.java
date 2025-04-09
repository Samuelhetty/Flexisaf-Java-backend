package digitalclock;

import digitalclock.modes.*;
import java.util.Scanner;

public class DigitalClock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClockMode mode = null;

        while (true) {
            System.out.println("Select mode: 1) Watch 2) Stopwatch 3) Timer 4) Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> mode = new Watch();
                case 2 -> mode = new Stopwatch();
                case 3 -> {
                    System.out.print("Enter timer duration in seconds: ");
                    long seconds = scanner.nextLong();
                    mode = new TimerMode(seconds);
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }

            if (mode != null) {
                System.out.println("Commands: start, stop, reset, exit");
                while (true) {
                    String command = scanner.next();
                    if (command.equalsIgnoreCase("start")) mode.start();
                    else if (command.equalsIgnoreCase("stop")) mode.stop();
                    else if (command.equalsIgnoreCase("reset")) mode.reset();
                    else if (command.equalsIgnoreCase("exit")) break;
                    else System.out.println("Invalid command. Try again.");
                }
            }
        }
    }
}
