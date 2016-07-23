import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main10I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String str = sc.next();
            String delimiter = sc.next();

            String tokens = split(str, delimiter);
            System.out.println(tokens);
        }
    }

    public static String split(String str, String deli) {
        List<String> matchList = new ArrayList<String>();

        Pattern regex = Pattern.compile(deli);
        Matcher regexMatcher = regex.matcher(str);

        while(regexMatcher.find()) {
            //matchList.add();
            System.out.println(regexMatcher.group());
        }
        /*
        String re = "";

        while(!matchList.isEmpty()) {
            int index = str.indexOf(matchList.get(0));
            String match = matchList.get(0);

            re += str.substring(0,index);
            re += "," + match + ",";

            str = str.substring(index+match.length());

            matchList.remove(0);
        }

        re += str;*/

        return "";//re;
    }

}