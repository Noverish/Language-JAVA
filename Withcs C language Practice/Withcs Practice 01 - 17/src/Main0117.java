import java.io.*;

public class Main0117 {
    public static void main(String[] args) throws IOException{
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream("input.txt"));
            //InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);


            while(true) {
                String str = br.readLine();

                if(str == null)
                    break;

                if(str.length()<32)
                    System.out.println(str);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
