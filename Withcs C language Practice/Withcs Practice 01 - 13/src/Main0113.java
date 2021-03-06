import java.io.*;

public class Main0113 {
    public static void main(String[] args) {//throws IOException{
        try {
            //InputStreamReader isr = new InputStreamReader(new FileInputStream("input.txt"));
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            int[] chart = new int[10];

            for(int i = 0;i<10;i++)
                chart[i] = 0;

            while(true) {
                int ch = br.read();

                if(ch == -1)
                    break;

                if('0' <= ch && ch <= '9')
                    chart[ch-'0']++;
            }


            for(int i = 0;i<10;i++) {
                System.out.println(i + ": " + chart[i]);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
