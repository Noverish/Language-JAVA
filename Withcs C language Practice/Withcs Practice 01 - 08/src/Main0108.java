import java.io.*;

public class Main0108 {
    public static void main(String[] args) {//throws IOException{
        try {
            //InputStreamReader isr = new InputStreamReader(new FileInputStream("input.txt"));
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);


            int space = 0, tap = 0, newLine = 0;

            while(true) {
                int ch = br.read();

                if(ch==-1)
                    break;

                if(ch==' ')
                    space++;
                else if(ch=='\t')
                    tap++;
                else if(ch=='\n')
                    newLine++;
            }

            System.out.println(space);
            System.out.println(tap);
            System.out.println(newLine);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
