import essential.Hang;
import essential.Operator;
import essential.Random;
import essential.Rational;

/**
 * Created by Noverish on 2016-02-29.
 */
public class DistributionLaw {
    public String processDanda(boolean sameChar, boolean negative) {
        String ans = "BULLET ";

        Hang hang, hang1, hang2;

        if(sameChar) {
            if(negative) {
                if (Random.randomProbability(0.5f)) {
                    hang = Hang.randomHang(Rational.randomRational(-10, 10, 1, 1), null, 1, 1);
                } else {
                    hang = Hang.randomHang(Rational.randomRational(-10, 10, 1, 1), new char[]{'x', 'x', 'x'}, 1, 2);
                }
                hang1 = Hang.randomHang(Rational.randomRational(-10, 10, 1, 1), new char[]{'x', 'x', 'x'}, 1, 2);
                hang2 = Hang.randomHang(Rational.randomRational(-10, 10, 1, 1), new char[]{'x', 'x', 'x'}, 1, 2);
            } else {
                if (Random.randomProbability(0.5f)) {
                    hang = Hang.randomHang(Rational.randomRational(2, 10, 1, 1), null, 1, 1);
                } else {
                    hang = Hang.randomHang(Rational.randomRational(2, 10, 1, 1), new char[]{'x', 'x', 'x'}, 1, 2);
                }
                hang1 = Hang.randomHang(Rational.randomRational(1, 10, 1, 1), new char[]{'x', 'x', 'x'}, 1, 2);
                hang2 = Hang.randomHang(Rational.randomRational(1, 10, 1, 1), new char[]{'x', 'x', 'x'}, 1, 2);
            }
        } else {
            if(negative) {
                if (Random.randomProbability(0.5f)) {
                    hang = Hang.randomHang(Rational.randomRational(-10, 10, 1, 1), null, 1, 1);
                } else {
                    hang = Hang.randomHang(Rational.randomRational(-10, 10, 1, 1), new char[]{'x', 'y', 'z'}, 1, 2);
                }
                hang1 = Hang.randomHang(Rational.randomRational(-10, 10, 1, 1), new char[]{'x', 'y', 'z'}, 1, 2);
                hang2 = Hang.randomHang(Rational.randomRational(-10, 10, 1, 1), new char[]{'x', 'y', 'z'}, 1, 2);
            } else {
                if (Random.randomProbability(0.5f)) {
                    hang = Hang.randomHang(Rational.randomRational(2, 10, 1, 1), null, 1, 1);
                } else {
                    hang = Hang.randomHang(Rational.randomRational(2, 10, 1, 1), new char[]{'x', 'y', 'z'}, 1, 2);
                }
                hang1 = Hang.randomHang(Rational.randomRational(1, 10, 1, 1), new char[]{'x', 'y', 'z'}, 1, 2);
                hang2 = Hang.randomHang(Rational.randomRational(1, 10, 1, 1), new char[]{'x', 'y', 'z'}, 1, 2);
            }
        }


        String op2 = Random.randomAmongArrayList(Operator.getOperatorArray(12));

        if(Random.randomProbability(0.5f)) {
            String op = "×";

            ans += hang;
            ans += " " + op + " ";
            ans += "(";
            ans += hang1 + " " + op2 + " " + hang2;
            ans += ")";

        } else {
            String op = "÷";

            hang1.multiply(hang);
            hang2.multiply(hang);

            ans += "(";
            ans += hang1 + " " + op2 + " " + hang2;
            ans += ")";
            ans += " " + op + " ";
            ans += hang;
        }

        return ans;
    }

    public String processDaDa(boolean sameChar, boolean negative) {
        String ans = "BULLET ";

        String op1 = Random.randomAmongArrayList(Operator.getOperatorArray(12));
        String op2 = Random.randomAmongArrayList(Operator.getOperatorArray(12));
        Hang hang1, hang2, hang3, hang4;


        if(sameChar) {
            if(negative) {
                hang1 = Hang.randomHang(new Rational(Random.randomWithoutZero(-5, 5), 1), new char[]{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, 1, 1);
                hang3 = Hang.randomHang(new Rational(Random.randomWithoutZero(-5, 5), 1), new char[]{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, 1, 1);

                if(Random.randomProbability(0.5f)) {
                    hang2 = Hang.randomHang(new Rational(Random.randomWithoutZero(-10, 10), 1), null, 1, 2);
                } else {
                    hang2 = Hang.randomHang(new Rational(Random.randomWithoutZero(-10, 10), 1), new char[]{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, 1, 2);
                }

                if(Random.randomProbability(0.5f)) {
                    hang4 = Hang.randomHang(new Rational(Random.randomWithoutZero(-10, 10), 1), null, 1, 2);
                } else {
                    hang4 = Hang.randomHang(new Rational(Random.randomWithoutZero(-10, 10), 1), new char[]{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, 1, 2);
                }
            } else {
                hang1 = Hang.randomHang(new Rational(Random.randomWithoutZero(2, 5), 1), new char[]{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, 1, 1);
                hang3 = Hang.randomHang(new Rational(Random.randomWithoutZero(2, 5), 1), new char[]{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, 1, 1);

                if(Random.randomProbability(0.5f)) {
                    hang2 = Hang.randomHang(new Rational(Random.randomWithoutZero(2, 10), 1), null, 1, 2);
                } else {
                    hang2 = Hang.randomHang(new Rational(Random.randomWithoutZero(2, 10), 1), new char[]{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, 1, 2);
                }

                if(Random.randomProbability(0.5f)) {
                    hang4 = Hang.randomHang(new Rational(Random.randomWithoutZero(2, 10), 1), null, 1, 2);
                } else {
                    hang4 = Hang.randomHang(new Rational(Random.randomWithoutZero(2, 10), 1), new char[]{'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, 1, 2);
                }
            }
        } else {
            if(negative) {
                hang1 = Hang.randomHang(new Rational(Random.randomWithoutZero(-5, 5), 1), new char[]{'x', 'x', 'y', 'y', 'z', 'z', 'x', 'y'}, 1, 1);
                hang3 = Hang.randomHang(new Rational(Random.randomWithoutZero(-5, 5), 1), new char[]{'x', 'x', 'y', 'y', 'z', 'z', 'x', 'y'}, 1, 1);

                if(Random.randomProbability(0.5f)) {
                    hang2 = Hang.randomHang(new Rational(Random.randomWithoutZero(-10, 10), 1), null, 1, 2);
                } else {
                    hang2 = Hang.randomHang(new Rational(Random.randomWithoutZero(-10, 10), 1), new char[]{'x', 'x', 'y', 'y', 'z', 'z', 'x', 'y'}, 1, 2);
                }

                if(Random.randomProbability(0.5f)) {
                    hang4 = Hang.randomHang(new Rational(Random.randomWithoutZero(-10, 10), 1), null, 1, 2);
                } else {
                    hang4 = Hang.randomHang(new Rational(Random.randomWithoutZero(-10, 10), 1), new char[]{'x', 'x', 'y', 'y', 'z', 'z', 'x', 'y'}, 1, 2);
                }
            } else {
                hang1 = Hang.randomHang(new Rational(Random.randomWithoutZero(2, 5), 1), new char[]{'x', 'x', 'y', 'y', 'z', 'z', 'x', 'y'}, 1, 1);
                hang3 = Hang.randomHang(new Rational(Random.randomWithoutZero(2, 5), 1), new char[]{'x', 'x', 'y', 'y', 'z', 'z', 'x', 'y'}, 1, 1);

                if(Random.randomProbability(0.5f)) {
                    hang2 = Hang.randomHang(new Rational(Random.randomWithoutZero(2, 10), 1), null, 1, 2);
                } else {
                    hang2 = Hang.randomHang(new Rational(Random.randomWithoutZero(2, 10), 1), new char[]{'x', 'x', 'y', 'y', 'z', 'z', 'x', 'y'}, 1, 2);
                }

                if(Random.randomProbability(0.5f)) {
                    hang4 = Hang.randomHang(new Rational(Random.randomWithoutZero(2, 10), 1), null, 1, 2);
                } else {
                    hang4 = Hang.randomHang(new Rational(Random.randomWithoutZero(2, 10), 1), new char[]{'x', 'x', 'y', 'y', 'z', 'z', 'x', 'y'}, 1, 2);
                }
            }
        }


        ans += "(" + hang1 + " " + op1 + " " + hang2 + ")";
        ans += " × ";
        ans += "(" + hang3 + " " + op2 + " " + hang4 + ")";

        return ans;
    }
}
