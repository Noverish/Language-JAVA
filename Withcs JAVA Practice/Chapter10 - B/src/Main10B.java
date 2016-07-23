import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main10B {
    public static void main(String[] args) {//throws IOException{
        //Scanner sc = new Scanner(new File("input.txt"));
        Scanner sc = new Scanner(System.in);
        int asdf = 0;

        Account[] acc = new Account[10];
        for(int i = 0;i<10;i++)
            acc[i] = new Account(i,100);

        while(true) {
            if(asdf++!=0)
                System.out.println();
            System.out.print("Enter an id: ");
            int id = sc.nextInt();

            if(0<= id && id < 10) {
                a : while(true) {
                    System.out.print("\nMain menu\n" +
                            "1: check balance\n" +
                            "2: withdraw\n" +
                            "3: deposit\n" +
                            "4: exit\n" +
                            "Enter a choice: ");

                    int input = sc.nextInt();

                    switch (input) {
                        case 1 : {
                            System.out.printf("The balance is %.1f\n",acc[id].getBalance());
                            break;
                        }
                        case 2 : {
                            System.out.print("Enter an amount to withdraw: ");
                            double money = sc.nextDouble();
                            if(money > acc[id].getBalance()) {
                                System.out.println("The amount is too large, ignored");
                            }
                            else {
                                acc[id].withdraw(money);
                            }
                            break;
                        }
                        case 3 : {
                            System.out.print("Enter an amount to deposit: ");
                            double money = sc.nextDouble();
                            if(money < 0) {
                                System.out.println("The amount is negative, ignored");
                            }
                            else {
                                acc[id].deposit(money);
                            }

                            break;
                        }
                        case 4 : {
                            break a;
                        }
                        default: {
                            System.out.println("Wrong choice, try again: ");
                            break;
                        }
                    }
                }
            }
            else {
                if(id == -20150901) {
                    System.out.print("Exit code entered");
                    break;
                }
                System.out.print("Please enter a correct id");
            }
        }
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
        balance -= money;
    }

    public void deposit(double money) {
        balance += money;
    }
}