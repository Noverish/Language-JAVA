import java.util.*;

public class Main0301 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double a, b, c;
        double check, answer1, answer2, answer;
        long answerInt;

        a=sc.nextDouble();
        b=sc.nextDouble();
        c=sc.nextDouble();

        check = b*b-4*a*c;

        if(check<0)
            System.out.println("complex");
        else {

            answer1 = (-b - Math.pow(check,0.5))/(2*a);
            answer2 = (-b + Math.pow(check,0.5))/(2*a);

            if(answer1 >= answer2)
                answer = answer1;
            else
                answer = answer2;

            answerInt = (long) Math.floor(answer*10);
            answer = (double) answerInt / 10;
            answerInt = (long) answer;

            if(answerInt == answer)
                System.out.println(answerInt);
            else
                System.out.println(answer);


        }
    }
}
