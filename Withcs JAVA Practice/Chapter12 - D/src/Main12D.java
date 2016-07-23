import java.util.Scanner;

public class Main12D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        sc.nextLine();
        for(int i = 0;i<testCase;i++) {
            String input = sc.nextLine();
            String[] inputs = input.split(" ");

            if(inputs[0].matches("-?[0-9]+") && inputs[2].matches("-?[0-9]+")) {
                int num1 = Integer.parseInt(inputs[0]);
                int num2 = Integer.parseInt(inputs[2]);

                if(inputs[1].equals("+"))
                    System.out.println(input + " = " + (num1+num2));
                else if(inputs[1].equals("-"))
                    System.out.println(input + " = " + (num1-num2));
                else if(inputs[1].equals("*"))
                    System.out.println(input + " = " + (num1*num2));
                else if(inputs[1].equals("%"))
                    System.out.println(input + " = " + (num1%num2));
                else if(inputs[1].equals("/"))
                    if(num2 == 0)
                        System.out.println("Wrong Input: " + inputs[2]);
                    else
                        System.out.println(input + " = " + ((double)num1/num2));
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
