import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;

public class Main18E {
    private static int size = 8;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] map = new char[size][size];
        int[][] answer;

        for(int i = 0;i<size;i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        answer = process(map);

        /*for(int i = 0;i<size;i++) {
            for (int j = 0; j < size; j++)
                System.out.printf("%3d",answer[i][j]);
            System.out.println();
        }*/

        System.out.println(answer[size-1][size-1] - 1);
    }

    public static int[][] process(char[][] originMap) {
        int[][] map = new int[size][size];
        ArrayList<Point2D> queue = new ArrayList<Point2D>();
        queue.add(new Point2D.Float(0,0)); // start point
        int length = 2;

        /* make map Integer from Character */
        for(int i = 0;i<size;i++)
            for(int j = 0;j<size;j++) {
                char ch = originMap[i][j];
                if(ch == '.')
                    map[i][j] = 0;
                else
                    map[i][j] = 111;
            }
        map[0][0] = 1;


        while(true) {
            int queueSize = queue.size();
            for(int i = 0;i<queueSize;i++) {
                int x = (int) queue.get(i).getX();
                int y = (int) queue.get(i).getY();

                if(x == size-1 && y==size-1)
                    return map;

                /** check surrounding point **/
                /* right point */
                int a = x;
                int b = y+1;
                if(b < size)
                    if(map[a][b] == 0) {
                        map[a][b] = length;
                        queue.add(new Point2D.Float(a,b));
                    }

                /* down point */
                a = x+1;
                b = y;
                if(a < size)
                    if(map[a][b] == 0) {
                        map[a][b] = length;
                        queue.add(new Point2D.Float(a,b));
                    }

                /* left point */
                a = x;
                b = y-1;
                if(b >= 0)
                    if(map[a][b] == 0) {
                        map[a][b] = length;
                        queue.add(new Point2D.Float(a,b));
                    }

                /* up point */
                a = x-1;
                b = y;
                if(a >= 0)
                    if(map[a][b] == 0) {
                        map[a][b] = length;
                        queue.add(new Point2D.Float(a,b));
                    }

            }

            /* remove existing point */
            for(int i = 0;i<queueSize;i++)
                queue.remove(0); // because if index[0] is deleted, index[1] becomes index[0]

            length++;
        }
    }
}
