import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        double weight, height;
        double answer;
        int answerInt;
        weight = sc.nextDouble();
        height = sc.nextDouble();

        weight*=0.45359237;
        height*=0.0254;

        answer = weight/(height*height);
        answer*=100;
        answerInt = (int)Math.floor(answer);
        answer = (double)answerInt/100;


        System.out.println(answer);


    }
}