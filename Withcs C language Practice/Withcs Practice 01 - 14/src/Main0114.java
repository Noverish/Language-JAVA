import java.io.*;

public class Main0114 {
    public static void main(String[] args) throws IOException{
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream("input.txt"));
            //InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            int[] chart = new int[255];

            for(int i = 0;i<255;i++)
                chart[i] = 0;

            while(true) {
                int ch = br.read();

                if(ch == -1)
                    break;

                if('!' <= ch && ch <= '~')
                    chart[ch]++;
            }


            for(int i = '!';i<='~';i++) {
                System.out.print((char)i + ": ");
                for(int j = 0;j<chart[i];j++)
                    System.out.print("*");
                System.out.println();
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
