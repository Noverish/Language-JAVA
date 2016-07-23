import java.util.*;

public class Main10A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(;testCase>0;testCase--){
            int num = sc.nextInt();

            ArrayList<Integer> factors = new ArrayList<Integer>();

            for(int i = 2;i<=num;i++){
                while(num%i==0){
                    factors.add(i);
                    num/=i;
                }
            }

            for(int i = factors.size() -1;i>=0;i--) {
                System.out.print(factors.get(i));

                if(i!=0)
                    System.out.print(" ");
            }

            System.out.println();
        }
    }
}
