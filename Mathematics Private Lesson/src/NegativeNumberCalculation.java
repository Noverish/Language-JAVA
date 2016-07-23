import essential.Hang;
import essential.Rational;
import essential.Operator;
import essential.Random;

public class NegativeNumberCalculation {
    public static int INTEGER_DIVIDE = 12;
    public static int FRACTION_DIVIDE = 7;

    public String process(int integer, int operatorNum, boolean onlyPositive, boolean sameDenominator, boolean biggerPrior) {
        if (integer == 1)
            return processInteger(operatorNum);
        else if (integer == 2)
            return processFraction(operatorNum, onlyPositive, sameDenominator, biggerPrior);
        else {
            if (Math.random() > 0.5)
                return processInteger(operatorNum);
            else
                return processFraction(operatorNum ,onlyPositive, sameDenominator, biggerPrior);
        }
    }

    private String processInteger(int operatorNum) {
        int a, b;
        String operator = Random.randomAmongArrayList(Operator.getOperatorArray(operatorNum));
        String ans = "BULLET ";

        if (operator.equals("÷")) {
            do {
                b = Random.randomWithoutZero(-10, 10);
                a = b * Random.randomWithoutZero(-5, 5);
            } while (!(a < 0 || b < 0));
        } else if (operator.equals("-")) {
            do {
                a = Random.randomWithoutZero(-10, 10);
                b = Random.randomWithoutZero(-10, 10);
            } while (a > b);
        } else {
            do {
                a = Random.randomWithoutZero(-10, 10);
                b = Random.randomWithoutZero(-10, 10);
            } while (!(a < 0 || b < 0));
        }

        ans += new Hang(a);
        ans += " " + operator + " ";
        ans += new Hang(b);

        return ans;
    }

    private String processFraction(int operatorNum, boolean onlyPositive, boolean sameDenominator, boolean biggerPrior) {
        Rational f1, f2;
        String operator = Random.randomAmongArrayList(Operator.getOperatorArray(operatorNum));
        String ans = "BULLET ";

        do {
            if (onlyPositive) {
                f1 = new Rational(Random.random(1, 10), Random.random(1, 10));
                f2 = new Rational(Random.random(1, 10), Random.random(1, 10));
            } else {
                f1 = new Rational(Random.randomWithoutZero(-10, 10), Random.randomWithoutZero(-10, 10));
                f2 = new Rational(Random.randomWithoutZero(-10, 10), Random.randomWithoutZero(-10, 10));
            }

            if (sameDenominator) {
                f1.setDown(f2.getDown());
            }

        } while ((f1.noDenominator() || f2.noDenominator() || (biggerPrior && f1.getUp() <= f2.getUp())));

        ans += f1.toString();
        ans += " " + operator + " ";
        ans += f2.toString();

        return ans;
    }





}
