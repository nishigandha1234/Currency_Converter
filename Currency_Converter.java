package studentassociation;
import java.util.ArrayList;
import java.util.Scanner;

public class Currency_Converter {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double usdToEurRate = 0.87;
        double usdToGbpRate = 0.75;
        
        System.out.println("Welcome to My Currency Converter!");

        while (true) {
            System.out.print("Enter the amount in USD: ");
            double usdAmount = scanner.nextDouble();

            System.out.println("Choose a currency to convert to:");
            System.out.println("1. Euro (EUR)");
            System.out.println("2. British Pound (GBP)");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    convertAndPrint(usdAmount, "USD", usdToEurRate, "Euro (EUR)");
                    break;
                case 2:
                    convertAndPrint(usdAmount, "USD", usdToGbpRate, "British Pound (GBP)");
                    break;
                

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

            System.out.print("Do you want to convert another amount? (y/n): ");
            char continueChoice = scanner.next().charAt(0);

            if (continueChoice != 'y' && continueChoice != 'Y') {
                System.out.println("Thank you for using the Our Currency Converter. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    private static void convertAndPrint(double amount, String fromCurrency, double exchangeRate, String toCurrency) {
        double convertedAmount = amount * exchangeRate;
        System.out.printf("%.2f %s is equal to %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
    }
}
