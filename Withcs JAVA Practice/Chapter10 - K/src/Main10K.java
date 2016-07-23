import java.util.*;

public class Main10K {
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

            ArrayList<Integer> rest0 = new ArrayList<Integer>();
            ArrayList<Integer> rest1 = new ArrayList<Integer>();
            ArrayList<Integer> rest2 = new ArrayList<Integer>();
            ArrayList<Integer> all = new ArrayList<Integer>();

            String[] str = sc.nextLine().split(" ");

            for(String a : str) {


                switch(sumOfDigit(a)%3) {
                    case 0 : {
                        rest0.add(Integer.parseInt(a));
                        break;
                    }
                    case 1 : {
                        rest1.add(Integer.parseInt(a));
                        break;
                    }
                    case 2 : {
                        rest2.add(Integer.parseInt(a));
                        break;
                    }
                }
                all.add(Integer.parseInt(a));
            }



            Collections.sort(rest0);
            Collections.sort(rest1);
            Collections.sort(rest2);
            Collections.sort(all, sorter);

            alll : while(true) {
                String numSen = "";

                for (int i = 0; i < all.size(); i++) {
                    numSen += all.get(i).toString();
                }
                switch (sumOfDigit(numSen)%3) {
                    case 0 : {
                        System.out.println(numSen);
                        break alll;
                    }
                    case 1 : {
                        all.remove(all.indexOf(rest1.get(0)));
                        rest1.remove(0);
                        break;
                    }
                    case 2 : {
                        all.remove(all.indexOf(rest2.get(0)));
                        rest2.remove(0);
                        break;
                    }
                }
            }
        }
    }

    public static int sumOfDigit(String sen) {
        int sum = 0;
        int len = sen.length();

        for(int i = 0;i<len;i++) {
            sum += sen.charAt(i) - '0';
        }

        return sum;
    }
}
