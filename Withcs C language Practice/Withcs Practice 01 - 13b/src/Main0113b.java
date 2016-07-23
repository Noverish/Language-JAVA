import java.io.*;

public class Main0113b {
    public static void main(String[] args) throws IOException{
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream("input.txt"));
            //InputStreamReader isr = new InputStreamReader(System.in);
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

            int max = 0;

            for(int i = 0;i<10;i++)
                if(max < chart[i])
                    max = chart[i];

            for(int i = max;i>0;i--) {
                for(int j = 0;j<10;j++) {
                    if (chart[j] == i) {
                        System.out.print("*");
                        chart[j]--;
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

            System.out.print("----------\n" +
                    "0123456789");


        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
