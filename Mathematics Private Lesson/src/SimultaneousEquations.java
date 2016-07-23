/**
 * Created by Noverish on 2016-02-08.
 */
public class SimultaneousEquations {
    private int totalPrintCount = 10;
    private int printPerOnce = 6;
    private String ans = "";

    public String process() {
        int ans1, ans2;

        for(int i = 1 ; i<totalPrintCount * printPerOnce ; i++) {
            ans1 = random(-8,8);
            ans2 = random(-8,8);

            int[] coef1 = new int[2];
            int[] coef2 = new int[2];

            int constant1, constant2;

            boolean bigConstant, sameCoef, oneEquation;

            do {
                coef1[0] = random(-8, 8, 0);
                coef1[1] = random(-8, 8, 0);
                coef2[0] = random(-8, 8, 0);
                coef2[1] = random(-8, 8, 0);

                constant1 = coef1[0] * ans1 + coef1[1] * ans2;
                constant2 = coef2[0] * ans1 + coef2[1] * ans2;

                bigConstant = Math.abs(constant1) > 20 || Math.abs(constant2) > 20;
                sameCoef = coef1[0] == coef2[0] || coef1[1] == coef2[1];
                oneEquation = (double)coef1[0]/coef2[0] == (double)coef1[1]/coef2[1];
            } while (bigConstant || sameCoef || oneEquation);

            ans += "BULLET ";
            ans += "LEFT{eqalign{";
            ans += makePart(coef1[0]) + "x + " + makePart(coef1[1]) + "y = " + constant1 + "#";
            ans += makePart(coef2[0]) + "x + " + makePart(coef2[1]) + "y = " + constant2;
            ans += "}RIGHT.######";

            if(i%printPerOnce == 0)
                ans += "\n";
        }

        return ans;
    }

    private int random(int from, int to) {
        return (int)(Math.random() * (to - from + 1) + from);
    }

    private int random(int from, int to, int without) {
        int output;

        do {
            output = (int)(Math.random() * (to - from + 1) + from);
        } while (output == without);

        return output;
    }

    private String makePart(int i) {
        if(i == 1)
            return "";

        if(i == -1)
            return "-";

        if(i > 0)
            return String.valueOf(i);
        else
            return "(" + i + ")";
    }

}
