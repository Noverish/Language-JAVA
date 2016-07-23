import java.util.*;

public class Main08E {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int sizeMatrix = sc.nextInt();
        int[][] array = new int[sizeMatrix+1][2];

        for(int i = 0;i<sizeMatrix;i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }

        for(int i = 0;i<sizeMatrix-1;i++)
            for(int j = i + 1;j<sizeMatrix;j++)
                if(array[i][0] > array[j][0]) {
                    int tmp = array[i][0];
                    array[i][0] = array[j][0];
                    array[j][0] = tmp;

                    tmp = array[i][1];
                    array[i][1] = array[j][1];
                    array[j][1] = tmp;
                }

        int count = 0;
        array[sizeMatrix][0] = array[sizeMatrix][1] = 0x7fffffff;

        for(int x = 0;x<sizeMatrix;x++) {
            if(array[x][0] == array[x+1][0]) {
                count++;
            }
            else {
                if(count != 0) {
                    for(int i = x-count;i<x;i++)
                        for(int j = i + 1;j<x+1;j++)
                            if(array[i][1] > array[j][1]) {
                                int tmp = array[i][0];
                                array[i][0] = array[j][0];
                                array[j][0] = tmp;

                                tmp = array[i][1];
                                array[i][1] = array[j][1];
                                array[j][1] = tmp;
                            }
                    count = 0;
                }


            }
        }

        for(int i = 0;i<sizeMatrix;i++)
            System.out.println(array[i][0] + " " + array[i][1]);

    }
}
