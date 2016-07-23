import java.util.Scanner;

public class Main0208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        int[] x_bit = new int[32];
        int x = sc.nextInt(), n = sc.nextInt();
        int i,j;

        for(i=0;x!=0;i++) {
            x_bit[i]=x%2;
            x/=2;
        }
        if(n>=0) {
            j=n%32;
            for(;j<32;j++) {
                System.out.printf("%d",x_bit[j]);
            }
            for(j=0;j<n%32;j++) {
                System.out.printf("%d",x_bit[j]);
            }
        }
        else {
            n*=-1;
            j=n%32;
            for(;j>0;j--) {
                System.out.printf("%d",x_bit[32-j]);
            }
            for(j=0;j<32-(n%32);j++) {
                System.out.printf("%d",x_bit[j]);
            }
        }
    }
}
