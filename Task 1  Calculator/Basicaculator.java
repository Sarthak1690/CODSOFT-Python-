import java.util.Scanner;

public class Basicaculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            System.out.print("Enter choice (1/2/3/4/5): ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            }

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid input. Please enter a valid option.");
                continue;
            }

            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            double result = 0.0;

            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    break;
                case 4:
                    result = divide(num1, num2);
                    break;
            }

            System.out.println(String.format("%.2f", num1) + " + " + String.format("%.2f", num2) + " = " + String.format("%.2f", result));

            // Add an option to continue or exit
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            scanner.nextLine(); // Consume the newline character
            String anotherCalculation = scanner.nextLine();
            if (!anotherCalculation.equalsIgnoreCase("yes")) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    private static double add(double x, double y) {
        return x + y;
    }

    private static double subtract(double x, double y) {
        return x - y;
    }

    private static double multiply(double x, double y) {
        return x * y;
    }

    private static double divide(double x, double y) {
        if (y != 0) {
            return x / y;
        } else {
            System.out.println("Cannot divide by zero. Returning 0.0");
            return 0.0;
        }
    }
}
