import java.util.*;

public class Main09E {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        Account account = new Account(sc.nextInt(), sc.nextInt());
        Account.setAnnualInterestRate(sc.nextDouble());

        System.out.printf("Balance : %.2f\n", account.getBalance());
        System.out.printf("Monthly interest : %.2f\n", account.getMonthlyInterest());

        account.withdraw(sc.nextDouble());

        System.out.printf("Balance : %.2f\n", account.getBalance());
        System.out.printf("Monthly interest : %.2f\n", account.getMonthlyInterest());

        account.deposit(sc.nextDouble());

        System.out.printf("Balance : %.2f\n", account.getBalance());
        System.out.printf("Monthly interest : %.2f\n", account.getMonthlyInterest());
    }
}

class Account {
    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated = null;

    public Account() {
        dateCreated = new Date();
    }

    public Account(int id, int balance) {
        this.id = id;
        this.balance = (double)balance;
        dateCreated = new Date();
    }

    public static void setAnnualInterestRate(double a) {
        annualInterestRate = a/100;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate*100;
    }

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate/12;
    }

    public double getMonthlyInterest() {
        return annualInterestRate/12*balance;
    }

    public void withdraw(double money) {
        if(money<=balance && money>=0) {
            balance -= money;
        }
    }

    public void deposit(double money) {
        if(money>=0) {
            balance+=money;
        }
    }
}