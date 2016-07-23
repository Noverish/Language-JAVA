import java.util.*;

public class Main08J {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int[][] point = new int[4][2];
        double[] d = new double[6];


        for(;testCase>0;testCase--) {
            int order = 0;

            for(int i = 0;i<4;i++)
                for(int j = 0;j<2;j++)
                    point[i][j] = sc.nextInt();

            for(int i = 0;i<3;i++)
                for(int j = i+1;j<4;j++)
                    d[order++] = distance(point[i][0], point[i][1], point[j][0], point[j][1]);

            Arrays.sort(d);

            int a = 0;

            if(d[0] == d[1] && d[0]!=0) {
                if (d[1] == d[2])
                    if (d[2] == d[3])
                        if (d[4] == d[5]) {
                            System.out.println("square");
                            a = 1;
                        }
            }

            if(a==0)
                System.out.println("not square");
        }
    }

    public static double distance(int x1, int y1, int x2, int y2) {

        return Math.sqrt(((double)x1-x2)*(x1-x2) + ((double)y1-y2)*(y1-y2));
    }
}
