import essential.Hang;

/**
 * Created by Noverish on 2016-02-08.
 */
public class MultinomialExpressionCalculation {
    private String[] chars = {"a", "b", "c", "x", "y", "z"};
    private String[] operators = {"－", "＋", "×", "÷"};
    private String ans = "";

    private int totalPrintCount = 10;
    private int printPerOnce = 11;


    public String processOnlyMulti(boolean yesCoef, boolean sameChar) {
        int[] coef = new int[2];
        String[] ch = randomChar(sameChar);
        int[] pow = random(-7,7,false,false);
        String operator = randomOperatorOnlyMulti();

        if(yesCoef)
            coef = random(-15,10,true,false);
        else
            coef[0] = coef[1] = 1;

        return new Hang(coef[0], ch[0], pow[0]) + operator + new Hang(coef[1], ch[1], pow[1]);
    }

    public String processOnlyPlusMius(boolean yesCoef, boolean sameChar, boolean samePow) {
        int[] coef = new int[2];
        String[] ch = randomChar(sameChar);
        int[] pow;
        String operator = randomOperatorOnlyPlusMinus();

        if(yesCoef)
            coef = random(-15,10,true,false);
        else
            coef[0] = coef[1] = 1;


        double pivot;
        if(samePow)
            pivot = 1;
        else
            pivot = 0.5;

        if(Math.random() < pivot)
            pow = random(-5,5,true,true);
        else
            pow = random(-5,5,true,false);

        if(operator.equals(" + ") || coef[1] < 0) {
            if(Math.random() < 0.5) {
                operator = " - ";
                coef[1] *= -1;
            }
        }

        return new Hang(coef[0], ch[0], pow[0]) + operator + new Hang(coef[1], ch[1], pow[1]);
    }

    private void plusMinusRandomize(int coefficient, int ch, int pow) {
        if(ch == 0) {
            if(pow == 0) {
                if(Math.random() < 0.3) {
                    ans += processOnlyPlusMius(coefficient == 1, true, true);
                } else {
                    double pivot = Math.random();

                    if(pivot < 0.4) {
                        ans += processOnlyPlusMius(coefficient == 1, false, true);
                    } else if (pivot < 0.8) {
                        ans += processOnlyPlusMius(coefficient == 1, true, false);
                    } else {
                        ans += processOnlyPlusMius(coefficient == 1, false, false);
                    }
                }
            } else {
                if(Math.random() < 0.5) {
                    ans += processOnlyPlusMius(coefficient == 1, true, true);
                } else {
                    ans += processOnlyPlusMius(coefficient == 1, false, true);
                }
            }
        } else {
            if(pow == 0) {
                if(Math.random() < 0.5) {
                    ans += processOnlyPlusMius(coefficient == 1, true, true);
                } else {
                    ans += processOnlyPlusMius(coefficient == 1, true, false);
                }
            } else {
                ans += processOnlyPlusMius(coefficient == 1, true, true);
            }
        }
    }

    public String process(int operation, int coefficient, int ch, int pow) {

        for(int i = 1 ; i <= totalPrintCount * printPerOnce ; i++) {

            ans += "BULLET ";

            if(operation == 0) {
                ans += processOnlyMulti(coefficient == 1, ch == 1);
            } else if(operation == 1) {
                plusMinusRandomize(coefficient, ch, pow);
            } else {
                if(Math.random() < 0.5) {
                    ans += processOnlyMulti(coefficient == 1, ch == 1);
                } else {
                    plusMinusRandomize(coefficient, ch, pow);
                }
            }

            if(i%printPerOnce == 0)
                ans += " =#\n";
            else
                ans += " =##";
        }

        return ans;
    }

    private int[] random(int from, int to, boolean withoutZero, boolean same) {
        int[] number = new int[2];

        number[0] = (int)(Math.random() * (to - from + 1) + from);
        number[1] = (int)(Math.random() * (to - from + 1) + from);

        if(withoutZero) {
            while (number[0] == 0 || number[1] == 0) {
                number[0] = (int)(Math.random() * (to - from + 1) + from);
                number[1] = (int)(Math.random() * (to - from + 1) + from);
            }
        }

        if(same)
            number[0] = number[1];

        return number;
    }

    private String[] randomChar(boolean same) {
        String[] str = new String[2];

        str[0] = chars[(int)(Math.random() * chars.length)];
        str[1] = chars[(int)(Math.random() * chars.length)];

        if(same)
            str[0] = str[1];

        return str;
    }



    private String randomOperator() {
        return " " + operators[(int)(Math.random() * operators.length)] + " ";
    }

    private String randomOperatorOnlyMulti() {
        return " " + operators[(int)(Math.random() * 2) + 2] + " ";
    }

    private String randomOperatorOnlyPlusMinus() {
        return " " + operators[(int)(Math.random() * 2)] + " ";
    }
}
