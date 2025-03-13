package askey;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Payment {
    private String userName;
    private double balance;

    public Payment(String userName, double initialBalance) {
        this.userName = userName;
        this.balance = initialBalance;
    }

    public String getUserName() {
        return userName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Amount should be greater than 0!");
        }
    }

    public boolean makePayment(double amount) {
        if (amount <= 0) {
            System.out.println("Amount should be greater than 0!");
            return false;
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
            return false;
        } else {
            balance -= amount;
            System.out.println("Payment of " + amount + " made successfully! New Balance: " + balance);
            return true;
        }
    }
}

public class PaymentApp {
    private static Map<String, Payment> userPayments = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample users
        userPayments.put("Alice", new Payment("Alice", 1000.00));
        userPayments.put("Bob", new Payment("Bob", 500.00));

        while (true) {
            System.out.println("\nWelcome to the Payment App");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Make a Payment");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                if (userPayments.containsKey(username)) {
                    System.out.println(username + "'s Balance: " + userPayments.get(username).getBalance());
                } else {
                    System.out.println("User not found!");
                }
            } else if (choice == 2) {
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                if (userPayments.containsKey(username)) {
                    System.out.print("Enter amount to deposit: ");
                    double amount = scanner.nextDouble();
                    userPayments.get(username).deposit(amount);
                } else {
                    System.out.println("User not found!");
                }
            } else if (choice == 3) {
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                if (userPayments.containsKey(username)) {
                    System.out.print("Enter amount to pay: ");
                    double amount = scanner.nextDouble();
                    userPayments.get(username).makePayment(amount);
                } else {
                    System.out.println("User not found!");
                }
            } else if (choice == 4) {
                System.out.println("Exiting the app. Goodbye!");
                break;
            } else {
                System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
    }
}
