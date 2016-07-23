import java.io.*;
import java.util.*;

public class Main2924 {
    public static void main(String[] arg) {//throws IOException {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String id = in.nextLine();
            assert id.length() > 0 && id.length() <= 100;
            boolean cpp = false;
            boolean java = false;
            for (int i = 0; i < id.length(); i++) {
                char c = id.charAt(i);
                assert ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || (c == '_');
                if (c == '_') {
                    cpp = true;
                }
                if ('A' <= c && c <= 'Z') {
                    java = true;
                }
            }

            if (java && cpp) {
                System.out.println("Error!");
            } else if (java) {
                if ('A' <= id.charAt(0) && id.charAt(0) <= 'Z') {
                    System.out.println("Error!");
                } else {
                    String r = "";
                    for (int i = 0; i < id.length(); i++) {
                        char c = id.charAt(i);
                        if ('A' <= c && c <= 'Z') {
                            r += "_" + (char) (c - 'A' + 'a');
                        } else {
                            r += c;
                        }
                    }
                    System.out.println(r);
                }
            } else if (cpp) {
                boolean invalid = false;
                String r = "";
                boolean newWord = true;
                for (int i = 0; i < id.length(); i++) {
                    char c = id.charAt(i);
                    if (c == '_') {
                        if (newWord) {
                            invalid = true;
                        } else {
                            newWord = true;
                        }
                    } else {
                        if (i != 0 && newWord) {
                            r += (char) (c + 'A' - 'a');
                        } else {
                            r += c;
                        }
                        newWord = false;
                    }
                }
                if (newWord) {
                    invalid = true;
                }
                if (invalid) {
                    System.out.println("Error!");
                } else {
                    System.out.println(r);
                }
            } else {
                System.out.println(id);
            }
        }
    }
}
