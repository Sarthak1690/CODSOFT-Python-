import java.util.Scanner;

public class BinaryToDecimalConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a binary number: ");
        String binary = scanner.nextLine();

        int decimal = convertBinaryToDecimal(binary);
        System.out.println("The decimal equivalent of the binary number " + binary + " is: " + decimal);
    }

    private static int convertBinaryToDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            int binaryDigit = binary.charAt(binary.length() - 1 - i) - '0';
            decimal += binaryDigit * Math.pow(2, i);
        }
        return decimal;
    }
}