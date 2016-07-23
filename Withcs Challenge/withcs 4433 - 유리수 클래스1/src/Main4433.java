import java.io.File;
import java.io.IOException;
import java.math.*;
import java.util.Scanner;

public class Main4433 {
    public static void main(String[] args) throws IOException{
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("input.txt"));

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            Rational r1 = new Rational(new BigInteger(sc.next()), new BigInteger(sc.next()));
            Rational r2 = new Rational(new BigInteger(sc.next()), new BigInteger(sc.next()));

            System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
            System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
            System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
            System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        }
    }
}

class Rational {
    private BigInteger up, down;
    private boolean minus;

    public Rational() {
        up = new BigInteger("1");
        down = new BigInteger("1");
    }

    public Rational(BigInteger up, BigInteger down) {
        if(up.compareTo(new BigInteger("0")) + down.compareTo(new BigInteger("0")) == 0)
            minus = true;
        else
            minus = false;

        if(up.compareTo(new BigInteger("0")) == -1)
            this.up = up.negate();
        else
            this.up = up;

        if(down.compareTo(new BigInteger("0")) == -1)
            this.down = down.negate();
        else
            this.down = down;

        if(minus)
            this.up = this.up.negate();

        BigInteger gcd = this.up.gcd(this.down);
        this.up = this.up.divide(gcd);
        this.down = this.down.divide(gcd);
    }

    public String toString() {
        if(down.equals(BigInteger.ONE))
            return up.toString();
        else
            return up + "/" + down;
    }

    public String add(Rational val) {
        Rational num1 = this.copy();
        Rational num2 = val.copy();
        Rational answer;
        num1.multiplyUpDown(val.down);
        num2.multiplyUpDown(this.down);

        answer = new Rational(num1.up.add(num2.up), num1.down).reduceFraction();

        return answer.toString();
    }

    public String subtract(Rational val) {
        Rational num1 = this.copy();
        Rational num2 = val.copy();
        Rational answer;
        num1.multiplyUpDown(val.down);
        num2.multiplyUpDown(this.down);

        answer = new Rational(num1.up.subtract(num2.up), num1.down).reduceFraction();

        return answer.toString();
    }

    public String multiply(Rational val) {
        Rational num1 = this.copy();
        Rational num2 = val.copy();
        Rational answer;

        answer = new Rational(num1.up.multiply(num2.up), num1.down.multiply(num2.down)).reduceFraction();

        return answer.toString();
    }

    public String divide(Rational val) {
        Rational num1 = this.copy();
        Rational num2 = val.copy();
        Rational answer;
        if(num2.minus) {
            num2.up = num2.up.negate();
            num2.down = num2.down.negate();
        }

        answer = new Rational(num1.up.multiply(num2.down), num1.down.multiply(num2.up)).reduceFraction();

        return answer.toString();
    }

    public Rational copy() {
        return new Rational(up,down);
    }

    public void multiplyUpDown(BigInteger a) {
        up = up.multiply(a);
        down = down.multiply(a);
    }

    public Rational reduceFraction() {
        Rational answer = new Rational();

        BigInteger gcd = up.gcd(down);
        answer.up = up.divide(gcd);
        answer.down = down.divide(gcd);

        return answer;
    }
}

