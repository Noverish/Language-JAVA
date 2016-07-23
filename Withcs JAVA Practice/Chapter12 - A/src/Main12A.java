import java.util.Scanner;

public class Main12A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        sc.nextLine();
        for(int i = 0;i<testCase;i++) {
            String str1 = sc.next();
            String op = sc.next();
            String str2 = sc.next();
            int num1 = -1, num2 = -1;

            try {
                num1 = Integer.parseInt(str1);
            }
            catch (Exception ex) {
                System.out.println("Wrong Input: " + str1);
                continue;
            }

            try {
                num2 = Integer.parseInt(str2);
            }
            catch (Exception ex) {
                System.out.println("Wrong Input: " + str2);
                continue;
            }

            if(op.equals("+"))
                System.out.println(num1 + " " + op + " " + num2 + " = " + (num1+num2));
            else if(op.equals("-"))
                System.out.println(num1 + " " + op + " " + num2 + " = " + (num1-num2));
            else if(op.equals("*"))
                System.out.println(num1 + " " + op + " " + num2 + " = " + (num1*num2));
            else if(op.equals("%"))
                System.out.println(num1 + " " + op + " " + num2 + " = " + (num1%num2));
            else if(op.equals("/"))
                if(num2 == 0)
                    System.out.println("Wrong Input: " + num2);
                else
                    System.out.println(num1 + " " + op + " " + num2 + " = " + (num1/num2));

        }
    }
}




/*import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main12A {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("input.txt"));

        int testCase = sc.nextInt();
        sc.nextLine();
        for(int i = 0;i<testCase;i++) {
            String input = sc.nextLine();
            String[] inputs = input.split(" ");

            if(inputs[0].matches("-?[0-9]+") && inputs[2].matches("-?[0-9]+")) {
                int num1 = Integer.parseInt(inputs[0]);
                int num2 = Integer.parseInt(inputs[2]);
                String op = inputs[1];

                if(inputs[1].equals("+"))
                    System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
                else if(inputs[1].equals("-"))
                    System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
                else if(inputs[1].equals("*"))
                    System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
                else if(inputs[1].equals("%"))
                    System.out.println(num1 + " % " + num2 + " = " + (num1%num2));
                else if(inputs[1].equals("/"))
                    if(num2 == 0)
                        System.out.println("Wrong Input: " + inputs[2]);
                    else
                        System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
            }
            else {
                if(!inputs[0].matches("-?[0-9]"))
                    System.out.println("Wrong Input: " + inputs[0]);
                else
                    System.out.println("Wrong Input: " + inputs[2]);
            }
        }
    }
}

/*
class Class {

    void method() {

        try {
            op = sc.nextInt();
            System.out.println(op);
        }
        catch(Exception ex) {
            System.out.println("Wrong Input: " + ex);
        }
        try {
            str2 = sc.nextInt();
            System.out.println(str2);
        }
        catch(Exception ex) {
            System.out.println("Wrong Input: " + ex);
        }








/*
            String str1 = sc.next();
            String op = sc.next();
            String str2 = sc.next();
            int num1 = -1, num2 = -1;

            try {
                num1 = Integer.parseInt(str1);
            }
            catch (Exception ex) {
                System.out.println("Wrong Input: " + str1);
                continue;
            }

            try {
                num2 = Integer.parseInt(str2);
            }
            catch (Exception ex) {
                System.out.println("Wrong Input: " + str2);
                continue;
            }

            if(op.equals("+"))
                System.out.println(num1 + " " + op + " " + num2 + " = " + (num1+num2));
            else if(op.equals("-"))
                System.out.println(num1 + " " + op + " " + num2 + " = " + (num1-num2));
            else if(op.equals("*"))
                System.out.println(num1 + " " + op + " " + num2 + " = " + (num1*num2));
            else if(op.equals("%"))
                System.out.println(num1 + " " + op + " " + num2 + " = " + (num1%num2));
            else if(op.equals("/"))
                if(num2 == 0)
                    System.out.println("Wrong Input: " + num2);
                else
                    System.out.println(num1 + " " + op + " " + num2 + " = " + ((double)num1/num2));

                    */