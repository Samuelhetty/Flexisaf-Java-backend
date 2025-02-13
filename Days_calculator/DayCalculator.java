package Days_calculator;
// Define the interface with two methods
interface HoursCalculator {
    // This method calculates and returns the number of hours
    int calculateHours();

    // This method displays the number of hours
    void displayHours();
}

// DayCalculator implements the HoursCalculator interface
public class DayCalculator implements HoursCalculator {

    // Implement calculateHours() to return the number of hours in a day
    @Override
    public int calculateHours() {
        return 24;
    }

    // Implement displayHours() to print the result to the console
    @Override
    public void displayHours() {
        System.out.println("There are " + calculateHours() + " hours in a day.");
    }

    // The main method to run the program
    public static void main(String[] args) {
        DayCalculator calculator = new DayCalculator();
        calculator.displayHours();
    }
}
