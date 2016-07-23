import java.io.*;

public class Main0116 {
    public static void main(String[] args) throws IOException{
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream("input.txt"));
            //InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            String ans = null;
            int ansLenght = 0;

            while(true) {
                String str = br.readLine();

                if(str == null)
                    break;

                if(ansLenght < str.length()){
                    ans = str;
                    ansLenght = str.length();
                }
            }

            System.out.println(ansLenght);
            System.out.println(ans);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
