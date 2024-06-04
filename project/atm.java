import java.util.Scanner;

public class atm {
    private Bank account;

    public atm(Bank account) {
        this.account=account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);  
        while (true) {
            displayMenu();  
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();  
            switch (choice) {  
                case "1":
                    handlewithdraw(scanner);  
                    break;
                case "2":
                    handledeposit(scanner);  
                    break;
                case "3":
                    handlecheckbalance();  
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM. Goodbye!");  
                    scanner.close();  
                    return;  
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
    }

    private void handlewithdraw(Scanner scanner) {
        System.out.println("Enter amount to withdraw:");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 
        if(account.withdraw(amount)) {
            System.out.println("Successfully withdrew"+amount);
        }
        else {
            System.out.println("insufficient Balance");
        }
    }

    private void handledeposit(Scanner scanner) {
        System.out.println("Enter amount to deposit:");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 
        if(account.deposit(amount)) {
            System.out.printf("Successfully deposited"+amount);  
        } else {
            System.out.println("Invalid deposit amount.");  
         }
    }
            
    private void handlecheckbalance() {
        double balance = account.getBalance();  
        System.out.printf("Your current balance is:"+balance);  
    }

    public static void main(String[] args) {
        Bank account = new Bank(100);  
        atm atm = new atm(account);  
        atm.run(); 
    }
}

