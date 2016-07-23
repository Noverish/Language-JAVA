import java.util.*;

public class Main08F {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int bankNum = sc.nextInt();
        double limit = sc.nextDouble();
        double[] bank = new double[bankNum];
        int connectCount = 0;
        double[][] connection = new double[10000][3];

        for(int i = 0;i<bankNum;i++) {
            bank[i] = sc.nextDouble();

            int connectNum = sc.nextInt();
            for(int j = 0;j<connectNum;j++){
                connection[connectCount][0] = i;
                connection[connectCount][1] = sc.nextInt();
                connection[connectCount][2] = sc.nextDouble();

                bank[i] += connection[connectCount][2];
                connectCount++;
            }
        }

        connectionSort(connectCount, connection);

        for(int a = 0;a<10;a++) {
            for (int i = 0; i < bankNum; i++) {
                if (bank[i] < limit) {
                    reduceAsset(i, bank, connection, connectCount);

                    connectionSort(connectCount, connection);

                }
            }
        }

        int tmp = 0;

        for (int i = 0; i < bankNum; i++) {
            if (bank[i] < limit) {
                if(tmp == 0) {
                    System.out.print(i);
                    tmp++;
                }
                else
                    System.out.print(" " + i);
            }
        }

    }

    public static void connectionSort(int connectCount, double[][] connection) {

        for(int i = 0;i<connectCount -1;i++)
            for(int j = i+1;j<connectCount;j++) {
                if(connection[i][1] > connection[j][1]) {
                    for(int k = 0;k<3;k++) {
                        double tmp = connection[i][k];
                        connection[i][k] = connection[j][k];
                        connection[j][k] = tmp;
                    }
                }
            }
    }

    public static void reduceAsset(int bankNumber, double[] bank, double[][] connection, int connectCount) {

        int i = 0;
        
        while(connection[i][1] != bankNumber && i<connectCount)
            i++;

        for(;connection[i][1] == bankNumber && i<connectCount;i++) {
            bank[(int)connection[i][0]] -= connection[i][2];
            connection[i][1] = 0x7fffffff;
        }
    }
}
