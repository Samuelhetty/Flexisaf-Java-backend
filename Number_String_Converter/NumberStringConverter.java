package Number_String_Converter;

public class NumberStringConverter {
    
    // Convert number to string
    public static String numberToString(int number) {
        return Integer.toString(number);
    }

    // Convert string to number
    public static int stringToNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + str);
            return 0;
        }
    }

    // Reverse a string
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        int number = 12345;
        String numberAsString = numberToString(number);
        System.out.println("Number to String: " + numberAsString);

        int stringAsNumber = stringToNumber(numberAsString);
        System.out.println("String to Number: " + stringAsNumber);

        String originalString = "Learning is Fun";
        String reversedString = reverseString(originalString);
        System.out.println("Original String: " + originalString);
        System.out.println("Reversed String: " + reversedString);
    }
}
