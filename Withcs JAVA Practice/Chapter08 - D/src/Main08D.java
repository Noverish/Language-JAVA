import java.util.*;

public class Main08D {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int sizeofA = sc.nextInt();
        int sizeofB = sc.nextInt();
        int x = sc.nextInt();

        int[] A = new int[sizeofA];
        int[] B = new int[sizeofB];

        for(int i = 0;i < sizeofA;i++)
            A[i] = sc.nextInt();

        for(int i = 0;i < sizeofB;i++)
            B[i] = sc.nextInt();

        Arrays.sort(A);
        Arrays.sort(B);

        int gap = 0x7fffffff;
        int ansA = 0, ansB = 0;
        int a = 0, b = sizeofB-1;

        while(a<sizeofA && b>=0) {
            if(Math.abs(A[a] + B[b] - x) < gap) {
                ansA = a;
                ansB = b;
                gap = Math.abs(A[a] + B[b] - x);
            }

            if(A[a] + B[b] > x)
                b--;
            else
                a++;

        }

        System.out.println(Math.abs(x - (A[ansA] + B[ansB])));


    }
}
