package essential;

import java.util.ArrayList;

/**
 * Created by Noverish on 2016-02-24.
 */
public class Operator {
    private static String[] op = {"+", "-", "×", "÷"};

    public static ArrayList<String> getOperatorArray(int num) {
        ArrayList<String> ans = new ArrayList<>();

        while(num != 0) {
            int pivot = num % 10;

            if(1 <= pivot && pivot <= 4)
                ans.add(op[pivot - 1]);

            num /= 10;
        }

        return ans;
    }
}
