import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main11C {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("input.txt"));

        int testCase = sc.nextInt();
        //int testCase = 1000;

        for(int i = 0;i<testCase;i++) {
            int num = sc.nextInt();
            //int num = i+1;
            int answer = 1;

            System.out.println();
            System.out.println(num);
            System.out.println(factorization(num));
            System.out.println(deleteOverlap(factorization(num)));

            for(int j : deleteOverlap(factorization(num)))
                answer *= j;

            System.out.printf("%d = %d x %d\n", num * answer, num, answer);
        }
    }

    public static ArrayList<Integer> factorization(int num) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        for(int i = 2;i<=num;i++) {
            while(true) {
                if(num%i==0) {
                    num/=i;
                    answer.add(i);
                }
                else
                    break;
            }
        }

        return answer;
    }

    public static ArrayList<Integer> deleteOverlap(ArrayList<Integer> num) {
        ArrayList<Double> numCopy = new ArrayList<Double>();

        for(int i : num)
            numCopy.add((double)i);

        for(int i = 0;i<numCopy.size();i++) {
            while(true) {


                double pivot = numCopy.get(i);

                int first = numCopy.indexOf(pivot);
                int last = numCopy.lastIndexOf(pivot);

                if (first != last) {
                    numCopy.remove(pivot);
                    numCopy.remove(pivot);
                }
                else
                    break;

                if(numCopy.size() == 0 || i >= numCopy.size())
                    break;
            }
        }

        num.clear();

        for(double i : numCopy)
            num.add((int)i);

        return num;
    }
}
