package essential;

import java.util.ArrayList;

/**
 * Created by Noverish on 2016-02-14.
 */
public class Random {
    public static int random(int from, int to) {
        return (int) (Math.random() * (to - from + 1) + from);
    }

    public static int randomWithoutZero(int from, int to) {
        int ans;

        do {
            ans = (int) (Math.random() * (to - from + 1) + from);
        } while (ans == 0);

        return ans;
    }

    public static int randomWithout(int from, int to, ArrayList<Integer> list) {
        int ans;

        do {
            ans = (int) (Math.random() * (to - from + 1) + from);
        } while (list.indexOf(ans) >= 0);

        return ans;
    }

    public static boolean randomProbability(double probability) {
        return Math.random() < probability;
    }

    public static String randomAmongArrayList(ArrayList<String> operator) {
        int pivot = random(0, operator.size() - 1);

        return operator.get(pivot);
    }

    public static String randomAmongArray(String[] strings) {
        int pivot = random(0, strings.length - 1);

        return strings[pivot];
    }
}
