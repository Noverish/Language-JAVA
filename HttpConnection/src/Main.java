import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Noverish on 2016-04-22.
 */
public class Main {
    public static void main(String[] args) {
        HttpConnectionThread thread = new HttpConnectionThread("http://marumaru.in/c/26","","POST");

        try {
            thread.start();
            thread.join();
        } catch (Exception ex) {

        }

        writeHtmlCode(thread.getHtmlCode());

    }

    private static void writeHtmlCode(String str) {
        try {
            FileWriter fileWriter = new FileWriter("output.txt");
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException io) {
            System.out.println("[WARNING!] IOException occurred! During writing Html code on output.txt");
        }
    }
}
