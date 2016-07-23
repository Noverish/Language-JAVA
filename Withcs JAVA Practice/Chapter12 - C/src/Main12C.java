import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main12C {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("input.txt"));
        String all = sc.nextLine();

        while(sc.hasNextLine()) {
            all = all + "\n" + sc.nextLine();
        }

        all = all.replaceAll("\n[\t ]*[{]"," {");

        System.out.println(all);
    }
}

