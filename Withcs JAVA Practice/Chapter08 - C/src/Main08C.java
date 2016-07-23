import java.util.*;

public class Main08C {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int matrixNum = sc.nextInt();

        long[] matrix = new long[matrixNum+1];

        for(int i = 0;i<matrixNum;i++) {
            long tmp;

            if(i == 0) {
                matrix[0] = sc.nextInt();
                matrix[1] = sc.nextInt();
            }
            else {
                tmp = sc.nextInt();
                matrix[i + 1] = sc.nextInt();
            }
        }

        long[][] minimum = new long[matrixNum][matrixNum];

        for(int i = 0;i<matrixNum;i++)
            minimum[i][i] = 0;

        int i,j;

        for(int gap = 1;gap < matrixNum;gap++) {
            for(i = 0, j = i+gap;i < matrixNum-gap;j++,i++) {
                long mini = 0x7fffffff;

                for(int k=0;k<gap;k++) {
                    long result = matrix[i] * matrix[i+k+1] * matrix[j+1] + minimum[i][i+k] + minimum[i+k+1][j];
                    if(mini > result)
                        mini = result;
                }

                minimum[i][j] = mini;
            }
            //print(minimum,matrixNum);
        }

        System.out.print(minimum[0][matrixNum-1]);
    }

    /*public static void print(long[][] minimum, long matrixNum) {
        for(long i = 0; i < matrixNum ; i++) {
            for(long j = 0;j<matrixNum;j++) {
                System.out.printf("%10d",minimum[i][j]);
            }
            System.out.println();
        }

        return;
    }*/
}
