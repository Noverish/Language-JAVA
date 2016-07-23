import java.io.*;
import java.util.*;

public class Main3139 {
    static Scanner in;

    int solve(int n, String[] strategy) {
        List<List<Integer>> pegs = new ArrayList<List<Integer>>();
        pegs.add(new LinkedList<Integer>());
        pegs.add(new LinkedList<Integer>());
        pegs.add(new LinkedList<Integer>());

        for (int i = 0; i < n; i++) {
            pegs.get(0).add(i);
        }

        int last = -1;
        int result = 0;
        while (pegs.get(1).size() != n && pegs.get(2).size() != n) {
            result++;
            for (String move : strategy) {
                List<Integer> peg1 = pegs.get(move.charAt(0) - 'A');
                List<Integer> peg2 = pegs.get(move.charAt(1) - 'A');
                if (
                        !peg1.isEmpty() &&
                                peg1.get(0) != last &&
                                (peg2.isEmpty() || peg1.get(0) < peg2.get(0))
                        ) {
                    last = peg1.remove(0);
                    peg2.add(0, last);
                    break;
                }
            }
        }
        return result;
    }

    void run() {
        int n = in.nextInt();
        in.nextLine();
        String[] strategy = in.nextLine().split(" ");
        int q2 = solve(2, strategy);
        int q3 = solve(3, strategy);
        int m = q3 / q2;
        int d = q3 - q2 * m;
        long z = 1;
        for (int i = 1; i < n; i++) {
            z = z * m + d;
        }
        System.out.println(z);
    }

    public static void main(String[] args) throws IOException {
        in = new Scanner(System.in);


        new Main3139().run();


        in.close();
    }
}