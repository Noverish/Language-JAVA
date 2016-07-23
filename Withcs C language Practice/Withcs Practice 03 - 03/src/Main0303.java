import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main0303 {
    public static boolean is_it_ok(int a, int b) {
        int ok1, ok2;

        if('0'<=a&&a<='9') ok1=1;
        else if('A'<=a&&a<='Z') ok1=2;
        else if('a'<=a&&a<='z') ok1=3;
        else return false;

        if('0'<=b&&b<='9') ok2=1;
        else if('A'<=b&&b<='Z') ok2=2;
        else if('a'<=b&&b<='z') ok2=3;
        else return false;

        if(a>b) return false;
        if(ok1!=ok2) return false;

        return true;
    }

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        int ch;
        int[] sen = new int[1500];
        int i,j;

        try {
            for (i = 0; true; i++) {
                ch = br.read();
                sen[i] = ch;
                if (ch == -1) break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for(i=0;sen[i]!=-1;i++) {

            if(sen[i]=='-') {
                if(  is_it_ok(sen[i-1],sen[i+1])  ) {
                    if(sen[i+2]=='-') sen[i+2]=300;
                    if(sen[i-1]==sen[i+1]) {
                        i++;
                        continue;
                    }
                    sen[i-1]++;
                    for(;sen[i-1]<sen[i+1];sen[i-1]++) {
                        System.out.printf("%c",sen[i-1]);
                    }

                }
                else System.out.printf("-");
            }
            else {
                if(sen[i]==300) System.out.printf("-");
                else System.out.printf("%c",sen[i]);
            }
        }
    }
}
