import java.io.*;

public class Main0111 {
    public static void main(String[] args) {//throws IOException{
        try {
            //InputStreamReader isr = new InputStreamReader(new FileInputStream("input.txt"));
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            int enter = 0;

            while(true) {
                int ch = br.read();

                if(ch == -1)
                    break;

                if('a' <= ch && ch <= 'z') {
                    System.out.print((char) ch);
                    enter = 0;
                }
                else if('A' <= ch && ch <= 'Z') {
                    System.out.print((char)ch);
                    enter = 0;
                }
                else if('0' <= ch && ch <= '9'){
                    System.out.print((char)ch);
                    enter = 0;
                }
                else {
                    if(enter == 0) {
                        System.out.println();
                        enter = 1;
                    }
                }

            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
