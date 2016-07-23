import java.io.*;

public class Main0204 {
    public static void main(String[] args) {//throws IOException{
        try {
            //InputStreamReader isr = new InputStreamReader(new FileInputStream("input.txt"));
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            int[] s1 = new int[100000];
            int[] s2 = new int[100000];
            int ch;
            int i;
            int[] ASCII = new int[300];


            for(i=0;true;i++) {
                ch=br.read();
                s1[i]=ch;
                if(ch=='\n') break;
            }

            for(i=0;true;i++) {
                ch=br.read();
                s2[i]=ch;
                if(ch==-1) break;
            }

            for(i=0;s2[i]!=-1;i++) {
                ASCII[s2[i]]++;
            }
            for(i=0;s1[i]!='\n';i++) {
                if(ASCII[s1[i]]!=0) s1[i] = 0;
            }

            for(i=0;s1[i]!='\n';i++) {
                if(s1[i]!=0) System.out.printf("%c",s1[i]);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
