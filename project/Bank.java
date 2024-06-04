public class Bank {
    private double balance;

     public Bank(double initialbalance) {
        this.balance = initialbalance;
    }

    public boolean withdraw (double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        else {
            System.out.println("Insufficient balance");
            return false;
        }
    }

    public boolean deposit (double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        else {
            System.out.println("Enter valid amount");
            return false;
        }
    }

    public double getBalance () {
        return balance;
    }
}
