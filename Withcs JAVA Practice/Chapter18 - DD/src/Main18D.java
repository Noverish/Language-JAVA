import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main18D {
    public static ArrayList<String> all =  new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.nextLine().toCharArray();

        permutate(input, 0);

        Collections.sort(all);

        for(String str : all)
            System.out.println(str);

    }

    public static void permutate(char[] list, int pointer) {
        if (pointer == list.length) {
            all.add(String.valueOf(list));
            return;
        }
        for (int i = pointer; i < list.length; i++) {
            char[] permutation = list.clone();
            permutation[pointer] = list[i];
            permutation[i] = list[pointer];
            permutate(permutation, pointer + 1);
        }
    }
}
