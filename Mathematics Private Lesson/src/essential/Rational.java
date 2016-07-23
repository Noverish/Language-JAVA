package essential;

/**
 * Created by Noverish on 2016-02-24.
 */
public class Rational {
    int up, down;

    public Rational() {
        up = 1;
        down = 2;
    }

    public Rational(int num1, int num2) {
        up = num1;
        down = num2;

        reduction();
    }

    public String toString() {
        String tmp;

        if(Math.abs(down) == 1) {
            tmp = "{" + Math.abs(up) + "}";
        } else {
            tmp = "{" + Math.abs(up) + "over" + Math.abs(down) + "}";
        }

        if(up < 0) {
            tmp = "LEFT(-" + tmp + "RIGHT)";
        }

        return tmp;
    }

    public String toStringWithoutBracket() {
        String tmp;

        if(Math.abs(down) == 1) {
            tmp = "{" + Math.abs(up) + "}";
        } else {
            tmp = "{" + Math.abs(up) + "over" + Math.abs(down) + "}";
        }

        if(up < 0) {
            tmp = "-" + tmp;
        }

        return tmp;
    }


    public boolean noDenominator() {
        return down == 1;
    }

    public void setDown(int down) {
        this.down = down;
        reduction();
    }

    public void setUp(int up) {
        this.up = up;
        reduction();
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public void multiply(int num) {
        setUp(this.up * num);
    }

    public void multiply(Rational r) {
        setUp(this.up * r.getUp());
        setDown(this.down * r.getDown());
    }

    public void divide(int num) {
        setDown(this.down * num);
    }

    public void divide(Rational r) {
        setUp(this.up * r.getDown());
        setDown(this.down * r.getUp());
    }


    public static Rational randomRational(int upFrom, int upTo, int downFrom, int downTo) {
        int up = Random.randomWithoutZero(upFrom, upTo);
        int down = Random.randomWithoutZero(downFrom, downTo);

        return new Rational(up, down);
    }

    private void reduction() {
        if(up == 0 || down == 0) {
            up = 0;
            down = 0;
        } else {
            int negativeUp = (up < 0) ? -1 : 1;
            int negativeDown = (down < 0) ? -1 : 1;

            negativeUp = negativeUp * negativeDown;

            up = Math.abs(up);
            down = Math.abs(down);

            up /= gcd(up, down) * negativeUp;
            down /= gcd(up, down);
        }
    }

    private int gcd(int a, int b) {
        if(a == 0 || b == 0)
            return a+b; // base case
        return gcd(b,a%b);
    }
}
