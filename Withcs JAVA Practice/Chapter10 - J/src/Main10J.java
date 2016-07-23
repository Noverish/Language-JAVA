import java.util.*;

public class Main10J {
    private static Comparator<Integer> sorter = new Comparator<Integer>(){
        public int compare(Integer o1, Integer o2) {
            String ab = o1.toString().concat(o2.toString());
            String ba = o2.toString().concat(o1.toString());

            return ba.compareTo(ab);
        }
    };

    public static String join(List<Integer> things){
        String output = "";
        for(int obj:things){
            output += obj;
        }
        return output;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        sc.nextLine();

        for(;testCase>0;testCase--) {

            ArrayList<Integer> ints = new ArrayList<Integer>();

            String[] str = sc.nextLine().split(" ");

            for(String a : str) {
                ints.add(Integer.parseInt(a));
            }

            Collections.sort(ints, sorter);
            System.out.println(join(ints));

        }
    }
}