import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Noverish on 2015-12-20.
 */
public class Main0302b {
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
            if(sen[i]=='\\') {
                i++;
                switch (sen[i])
                {
                    case 'n' : {
                        System.out.printf("\n");
                        break;
                    }
                    case 't' : {
                        System.out.printf("\t");
                        break;
                    }
                    case 'b' : {
                        System.out.printf("\b");
                        break;
                    }
                    default:
                        System.out.printf("\\");
                        System.out.printf("%c",sen[i]);
                        break;
                }
            }
            else System.out.printf("%c",sen[i]);
        }
    }
}
