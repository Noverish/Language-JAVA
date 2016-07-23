import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Noverish on 2015-12-20.
 */
public class Main0302a {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        char[] sen = new char[1500];
        int i,ch;
        int sen_len = -1;

        try {
            for (i = 0; true; i++) {
                ch = br.read();
                if (ch == -1) break;
                sen[i] = (char)ch;
            }
            sen_len=i-1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for(i=0;i<=sen_len;i++) {
            switch (sen[i])
            {
                case '\t' : {
                    System.out.printf("\\t");
                    break;
                }
                case '\n' : {
                    System.out.printf("\\n");
                    break;
                }
                case '\b' : {
                    System.out.printf("\\b");
                    break;
                }
                default: {
                    System.out.printf("%c",sen[i]);
                    break;
                }
            }
        }
    }
}
