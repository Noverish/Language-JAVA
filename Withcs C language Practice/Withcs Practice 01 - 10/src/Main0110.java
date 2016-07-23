import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main0110 {
    public static void main(String[] args) {//throws IOException {
        try {
            //InputStreamReader isr = new InputStreamReader(new FileInputStream("input.txt"));
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            while(true) {
                int ch = br.read();

                if(ch == -1)
                    break;

                if(ch == '\t')
                    System.out.print("\\t");
                else if(ch == '\\')
                    System.out.print("\\\\");
                else
                    System.out.print((char)ch);

            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
