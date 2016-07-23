package essential;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Noverish on 2016-02-29.
 */
public class Hang {

    private Rational coef = new Rational();
    private HashMap<Character, Integer> charPow = new HashMap<>();

    public Hang() {}

    public Hang(int coef) {
        this.coef = new Rational(coef,1);
    }

    public Hang(int coef, String ch, int pow) {
        this.coef = new Rational(coef,1);
        charPow.put(ch.charAt(0), pow);
    }

    public Hang(int coef, char[] chars, int[] pows) {
        this.coef = new Rational(coef,1);

        for(int i = 0;i<chars.length;i++) {
            charPow.put(chars[i], pows[i]);
        }
    }

    public Hang(int coef, String[] chars, int[] pows) {
        this.coef = new Rational(coef,1);

        for(int i = 0;i<chars.length;i++) {
            charPow.put(chars[i].charAt(0), pows[i]);
        }
    }

    public void multiply(int coef) {
        this.coef.multiply(coef);
    }

    public void multiply(Rational coef) {
        this.coef.multiply(coef);
    }

    public void multiply(char ch) {
        multiply(ch, 1);
    }

    public void multiply(char ch, int p) {
        if(charPow.containsKey(ch)) {
            int pow = charPow.get(ch);
            charPow.replace(ch, pow + p);
        } else {
            charPow.put(ch,p);
        }
    }

    public void multiply(Hang hang) {
        this.coef.multiply(hang.coef);

        ArrayList<Character> keySet = new ArrayList<>(hang.charPow.keySet());
        Collections.sort(keySet);

        for(char ch : keySet) {
            this.multiply(ch, hang.charPow.get(ch));
        }
    }

    public String toString() {
        String tmp;

        if(coef.getUp() == 1 && coef.noDenominator())
            tmp = "";
        else if(coef.getUp() == -1 && coef.noDenominator())
            tmp = "-";
        else if(coef.getUp() == 0)
            return "0";
        else
            tmp = coef.toStringWithoutBracket() + "";

        ArrayList<Character> keySet = new ArrayList<>(charPow.keySet());
        Collections.sort(keySet);

        for(char ch : keySet) {
            int pow = charPow.get(ch);

            if(pow != 0) {
                tmp += ch;

                if(pow != 1)
                    tmp += "^{" + pow + "}";
            }
        }

        if(keySet.size() == 0 && Math.abs(coef.getUp()) == 1 && Math.abs(coef.getDown()) == 1)
            tmp += 1;

        if(coef.getUp() < 0)
            tmp = "(" + tmp + ")";

        if(tmp.equals(""))
            tmp = "1";

        return tmp;
    }

    public String toStringWithoutBracket() {
        String tmp;

        if(coef.getUp() == 1 && coef.noDenominator())
            tmp = "";
        else if(coef.getUp() == -1 && coef.noDenominator())
            tmp = "-";
        else if(coef.getUp() == 0)
            return "0";
        else
            tmp = coef.toStringWithoutBracket() + "";

        ArrayList<Character> keySet = new ArrayList<>(charPow.keySet());
        Collections.sort(keySet);

        for(char ch : keySet) {
            int pow = charPow.get(ch);

            if(pow != 0) {
                tmp += ch;

                if(pow != 1)
                    tmp += "^{" + pow + "}";
            }
        }

        if(tmp.equals(""))
            tmp = "1";

        return tmp;
    }

    public static Hang randomHang(Rational rational, char[] chars , int powFrom, int powTo) {
        Hang hang = new Hang();

        hang.coef = rational;

        if(chars != null) {
            for (char ch : chars) {
                if (Random.randomProbability(0.5f))
                    hang.multiply(ch, Random.random(powFrom, powTo));
            }
        }

        return hang;
    }

}
