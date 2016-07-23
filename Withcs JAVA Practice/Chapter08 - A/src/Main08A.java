import java.util.*;

public class Main08A {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int[][] timeTable = new int[100][8];
        int testCase;
        String[] name = new String[100];
        int[] order = new int[100];

        testCase = sc.nextInt();
        String line = sc.nextLine();

        for(int i = 0;i < testCase ; i++) {
            line = sc.nextLine();
            String[] split = new String[8];
            split = line.split(" ");
            name[i] = split[0];
            timeTable[i][7] = 0;
            order[i] = i;

            for(int j = 0;j<7;j++) {
                timeTable[i][j] = Integer.parseInt(split[j+1]);
                timeTable[i][7] += timeTable[i][j];
            }


        }

        for(int i = 0; i < testCase -1 ; i++)
            for(int j = i+1;j<testCase;j++)
                if(timeTable[i][7] < timeTable[j][7]) {
                    int tmp = timeTable[i][7];
                    timeTable[i][7] = timeTable[j][7];
                    timeTable[j][7] = tmp;

                    String ttmp = name[i];
                    name[i] = name[j];
                    name[j] = ttmp;

                    tmp = order[i];
                    order[i] = order[j];
                    order[j] = tmp;
                }

        int count = 0;

        for(int p = 0;p<testCase - 1;p++) {
            if(timeTable[p][7] == timeTable[p+1][7]) {
                count++;
            }
            else {
                if(count != 0) {
                    for(int i = p-count; i < p ; i++)
                        for(int j = i+1;j<p+1;j++)
                            if(order[i] > order[j]) {
                                int tmp = timeTable[i][7];
                                timeTable[i][7] = timeTable[j][7];
                                timeTable[j][7] = tmp;

                                String ttmp = name[i];
                                name[i] = name[j];
                                name[j] = ttmp;

                                tmp = order[i];
                                order[i] = order[j];
                                order[j] = tmp;
                            }
                    count = 0;
                }
            }
        }



        for(int i = 0;i<testCase;i++)
            System.out.println(name[i] + " " + timeTable[i][7]);

    }
}
