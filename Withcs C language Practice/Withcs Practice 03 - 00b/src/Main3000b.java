import java.util.Scanner;

public class Main3000b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int height = sc.nextInt();
        int i,j;

        height=(height+1)/2;

        for(i=1;i<=height;i++) {
            for(j=0;j<height-i;j++) {
                System.out.printf(" ");
            }
            for(j=0;j<2*(i-1)+1;j++){
                System.out.printf("*");
            }
            System.out.printf("\n");
        }

        for(i=height-1;i>0;i--) {
            for(j=0;j<height-i;j++) {
                System.out.printf(" ");
            }
            for(j=0;j<2*(i-1)+1;j++){
                System.out.printf("*");
            }
            if(i!=1) System.out.printf("\n");
        }
    }
}
