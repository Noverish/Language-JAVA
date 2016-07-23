import java.util.Scanner;

public class Main3000a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int height = sc.nextInt();
        int i, j;
        
        for (i = 1; i <= height; i++) {
            for (j = 0; j < height - i; j++) {
                System.out.printf(" ");
            }
            for (j = 0; j < 2 * (i - 1) + 1; j++) {
                System.out.printf("*");
            }
            System.out.printf("\n");
        }
    }
}
