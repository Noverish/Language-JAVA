import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main1011 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("input.txt"));

        int pointNum = sc.nextInt();
        double[][] points = new double[pointNum][3];
        ArrayList<double[]> distances = new ArrayList<>();
        double answer = 0;

        for(int i = 0;i<pointNum;i++)
            points[i] = new double[]{sc.nextDouble(), sc.nextDouble(), i};

        for(int i = 0;i<pointNum-1;i++) {
            for(int j = i+1;j<pointNum;j++) {
                double x1 = points[i][0];
                double y1 = points[i][1];
                double x2 = points[j][0];
                double y2 = points[j][1];
                distances.add(new double[]{i,j,Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2))});
            }
        }

        Collections.sort(distances, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o1[2] < o2[2])
                    return -1;
                else if(o1[2] == o2[2])
                    return 0;
                else
                    return 1;
            }
        });

        for(int i = 0;i<distances.size();i++) {
            int p1 = (int) distances.get(i)[0];
            int p2 = (int) distances.get(i)[1];
            double dis = distances.get(i)[2];

            if(points[p1][2] != points[p2][2]) {
                points[p2][2] = points[p1][2];
                answer += dis;
            }
        }

        System.out.printf("%.2f",answer);
    }
}