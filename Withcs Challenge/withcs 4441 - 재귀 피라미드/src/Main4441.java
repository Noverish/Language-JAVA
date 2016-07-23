import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main4441 {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("input.txt"));

        int num = sc.nextInt();
        num/=3;
        num = (int)(Math.log(num)/Math.log(2));

        triangle(3);
    }

    public static void triangle(int n){
        n= (int)Math.pow(2, n);
        StringBuilder line= new StringBuilder(); //use a "mutable String"
        char t= 0;
        char u= 0; // avoid warnings
        for(int i= 0;i <= 2 * n;++i)
            line.append(" "); //start empty
        line.setCharAt(n, '*'); //with the top point of the triangle
        for(int i= 0;i < n;++i){
            System.out.println(line);
            u= '*';
            for(int j= n - i;j < n + i + 1;++j){
                t= (line.charAt(j - 1) == line.charAt(j + 1) ? ' ' : '*');
                line.setCharAt(j - 1, u);
                u= t;
            }
            line.setCharAt(n + i, t);
            line.setCharAt(n + i + 1, '*');
        }
    }
}
/*
    int main()
    {
        int x, y, i;
        for (y = SIZE - 1; y >= 0; y--) {
            for (i = 0; i < y; i++)
                printf(" ");
            for (x = 0; x + y < SIZE; x++) {
                //printf((x & y) ? "  " : "* ");
                printf("%d %d %d\n",x,y,(x&y));
            }
            printf("\n");
        }
        return 0;
    }
    */
