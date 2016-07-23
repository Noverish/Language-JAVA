/*import java.util.*;

public class Main18C {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        input.nextLine();
        for(int i=0; i<T; i++){
            int num = input.nextInt();
            System.out.println(hanoi(num));
        }
    }

    public static int hanoi(int num) {
        return (int)Math.pow(2f,num)-1;
    }
}*/

import java.util.Scanner;

public class Main18C {
    public static int answer;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        input.nextLine();
        for(int i=0; i<T; i++){
            int num = input.nextInt();
            hanoi(num, 'A', 'B', 'C');
            System.out.println(answer);
            answer = 0;
        }
    }

    public static void hanoi(int n, char fromTower,char toTower, char auxTower) {
        if(fromTower == 'A' && toTower == 'B')
            answer++;
        if (n == 1);
        else {
            hanoi(n - 1, fromTower, auxTower, toTower);
            hanoi(n - 1, auxTower, toTower, fromTower);
        }
    }
}