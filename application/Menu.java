package application;
import java.util.Scanner;

public class Menu {

private static double balance = 1000.0;  // Starting balance

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
        System.out.println("====== Payment App Menu ======");
        System.out.println("1. View Balance");
        System.out.println("2. Make Payment");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                viewBalance();
                break;
            case 2:
                makePayment(scanner);
                break;
            case 3:
                System.out.println("Exiting the app. Thank you!");
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    } while (choice != 3);
    
    scanner.close();
}

private static void viewBalance() {
    System.out.println("Your current balance is: $" + balance);
}

private static void makePayment(Scanner scanner) {
    System.out.print("Enter payment amount: $");
    double paymentAmount = scanner.nextDouble();

    if (paymentAmount > 0 && paymentAmount <= balance) {
        balance -= paymentAmount;
        System.out.println("Payment of $" + paymentAmount + " was successful!");
        System.out.println("Your new balance is: $" + balance);
    } else if (paymentAmount > balance) {
        System.out.println("Insufficient balance for this payment.");
    } else {
        System.out.println("Invalid payment amount.");
    }
}
}


