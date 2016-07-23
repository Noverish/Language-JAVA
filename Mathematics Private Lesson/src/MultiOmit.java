import essential.Hang;
import essential.Random;
import essential.Rational;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Noverish on 2016-02-29.
 */
public class MultiOmit  {

    private String[] ch1 = {"-", "+"};
    private String[] xyz = {"x", "y", "z"};


    public String processOmit(boolean negative, boolean plusMinus) {
        String ans = "BULLET ";

        int pivot = Random.random(0, 2); // The number of '+'

        if(!plusMinus || pivot == 0) {
            ans += processHangSeparate(pivot, negative);
        } else if(pivot == 1) {
            ans += processHangSeparate(pivot, negative) + " " + Random.randomAmongArray(ch1) + " ";
            ans += processHangSeparate(pivot, negative);
        } else {
            ans += processHangSeparate(pivot, negative) + " " + Random.randomAmongArray(ch1) + " ";
            ans += processHangSeparate(pivot, negative) + " " + Random.randomAmongArray(ch1) + " ";
            ans += processHangSeparate(pivot, negative);
        }

        return ans;
    }

    private String processHangSeparate(int para, boolean negative) {
        int numOfNum = 0;

        ArrayList<String> mix = new ArrayList<>();
        String ans = "";
        int pivot = Random.random(6 - para * 2, 8 - para * 3);
        int num1 = Random.randomWithout(-8, 8, new ArrayList<>(Arrays.asList(-1, 0, 1)));
        int num2 = Random.randomWithout(-8, 8, new ArrayList<>(Arrays.asList(-1, 0, 1)));
        int num3 = Random.randomWithout(-8, 8, new ArrayList<>(Arrays.asList(-1, 0, 1)));

        if(!negative) {
            num1 = Random.random(2, 8);
            num2 = Random.random(2, 8);
            num3 = Random.random(2, 8);
        }

        mix.add((new Hang(num1)).toString());
        mix.add((new Hang(num2)).toString());
        mix.add((new Hang(num3)).toString());
        mix.add("x"); mix.add("y"); mix.add("z");
        mix.add("x"); mix.add("y"); mix.add("z");

        for(int i = 1;i<=pivot;i++) {
            String tmp = Random.randomAmongArrayList(mix);

            if(numOfNum == 3) {
                int a = 0;
            }

            if(numOfNum > 2) {
                do {
                    tmp = Random.randomAmongArrayList(mix);
                } while(!tmp.equals("x") && !tmp.equals("y") && !tmp.equals("z"));
            } else {
                if(!tmp.equals("x") && !tmp.equals("y") && !tmp.equals("z"))
                    numOfNum++;
            }

            ans += tmp;

            if(i != pivot) {
                if(Random.randomProbability(0.3f))
                    ans += " ÷ ";
                else
                    ans += " × ";
            }
        }

        return ans;
    }

    public String processInsert() {
        String ans = "BULLET ";

        int pivot = Random.random(0, 1); // The number of '+'

        if(pivot == 0) {
            ans += processHangIntegrate();
        } else if(pivot == 1) {
            ans += processHangIntegrate() + " " + Random.randomAmongArray(ch1) + " ";
            ans += processHangIntegrate();
        }

        return ans;
    }

    private String processHangIntegrate() {
        String ans = "";

        int pivot = Random.random(0, 4);
        int num = Random.randomWithoutZero(-3, 3);
        int constant = Random.randomWithoutZero(-10, 10);

        if(pivot == 0) {
            ans += constant;
        } else if(pivot == 1) {
            String ch = Random.randomAmongArray(xyz);
            ans += new Hang(num, ch, 1);
        } else if(pivot == 2) {
            Rational f = new Rational(1, 2);
            if(Random.randomProbability(0.5f))
                f.setUp(-1);

            ans += f.toString();
            String ch = Random.randomAmongArray(xyz);
            ans += new Hang(1, ch, 1);
        } else if(pivot == 3) {
            int pow = Random.random(2, 4);
            String ch = Random.randomAmongArray(xyz);
            ans += new Hang(num, ch, pow);
        } else if(pivot == 4) {
            int pivot2 = Random.random(0,2);
            String[] chs = new String[2];
            int[] pows = {Random.random(1,3), Random.random(1,3)};

            if(pivot2 == 0) {
                chs[0] = "x";
                chs[1] = "y";
            } else if(pivot2 == 1) {
                chs[0] = "y";
                chs[1] = "z";
            } else if(pivot2 == 2) {
                chs[0] = "x";
                chs[1] = "z";
            }

            ans += new Hang(num, chs, pows);
        }

        return ans;
    }
}
