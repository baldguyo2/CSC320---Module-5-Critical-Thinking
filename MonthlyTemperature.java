import java.util.Scanner;

public class MonthlyTemperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        double[] temperatures = new double[12];

        System.out.println("Enter the average temperature for each month:");

        for (int i = 0; i < months.length; i++) {
            System.out.print(months[i] + ": ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // clear invalid input
                System.out.print(months[i] + ": ");
            }
            temperatures[i] = scanner.nextDouble();
        }

        System.out.print("\nEnter a month name to view its temperature or type \"year\" to view full report: ");
        scanner.nextLine(); // consume leftover newline
        String input = scanner.nextLine().trim();

        boolean found = false;

        if (input.equalsIgnoreCase("year")) {
            double sum = 0;
            double max = temperatures[0];
            double min = temperatures[0];
            String maxMonth = months[0];
            String minMonth = months[0];

            System.out.println("\n--- Monthly Temperatures ---");
            for (int i = 0; i < months.length; i++) {
                System.out.printf("%-10s: %.2f°C%n", months[i], temperatures[i]);
                sum += temperatures[i];
                if (temperatures[i] > max) {
                    max = temperatures[i];
                    maxMonth = months[i];
                }
                if (temperatures[i] < min) {
                    min = temperatures[i];
                    minMonth = months[i];
                }
            }

            double average = sum / months.length;
            System.out.printf("\nYearly Average Temperature: %.2f°C%n", average);
            System.out.printf("Highest Monthly Average: %.2f°C (%s)%n", max, maxMonth);
            System.out.printf("Lowest Monthly Average: %.2f°C (%s)%n", min, minMonth);
            found = true;
        } else {
            for (int i = 0; i < months.length; i++) {
                if (months[i].equalsIgnoreCase(input)) {
                    System.out.printf("\n%s Average Temperature: %.2f°C%n", months[i], temperatures[i]);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Invalid input. Please enter a valid month or \"year\".");
        }

        scanner.close();
    }
}
