import java.util.*;

public class Main07E {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] column = new int[size];
        int answer = 0;
        int row = 0;

        for(int i = 0 ; i < size ; i++)
            column[i] = -1;

        while(row >= 0) {
            while(column[row] < size) {
                int tmp = 0;
                column[row]++;

                for(int i = 1;i <= row;i++) {
                    if(column[row - i] == column[row] || column[row - i] == column[row] - i || column[row - i] == column[row] + i) {
                        tmp = -1;
                    }
                }

                if(tmp == 0)
                    break;
            }

            if(column[row] == size)
                row--;
            else {
                if(row < size -1)
                    column[++row] = -1;
                else
                    answer++;
            }
        }

        System.out.println(answer);
    }




}
