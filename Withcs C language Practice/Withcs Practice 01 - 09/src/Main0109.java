import java.io.*;

public class Main0109 {
    public static void main(String[] args) {//throws IOException{
        try {
            //InputStreamReader isr = new InputStreamReader(new FileInputStream("input.txt"));
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            int spaceOn = 0;

            while(true) {
                int ch = br.read();

                if(ch == -1)
                    break;

                if(ch==' ' && spaceOn == 1);
                else if(ch==' ' && spaceOn == 0) {
                    System.out.print((char)ch);
                    spaceOn = 1;
                }
                else {
                    spaceOn = 0;
                    System.out.print((char)ch);
                }

            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
