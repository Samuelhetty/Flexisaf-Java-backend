package Simple_calculator;
import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {  // Use try-with-resources
            while (true) {
                System.out.println("\n Simple Calculator");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Exit");
                System.out.print("Enter your choice (1-5): ");

                int choice = scanner.nextInt();
                if (choice == 5) {
                    System.out.println("Exiting calculator. Goodbye!");
                    break;
                }
                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid choice. Please enter a number between 1-5");
                    continue;
                }
                
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();
                
                double result;
                try {
                    result = switch (choice) {
                        case 1 -> add(num1, num2);
                        case 2 -> subtract(num1, num2);
                        case 3 -> multiply(num1, num2);
                        case 4 -> divide(num1, num2);
                        default -> throw new IllegalArgumentException("Invalid choice");
                    };
                } catch (ArithmeticException e) { 
                    System.out.println("Error: " + e.getMessage());
                    continue;
                }
                System.out.println("Result: " + result);
            }
        } 
    }

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return num1 / num2;
    }
}
