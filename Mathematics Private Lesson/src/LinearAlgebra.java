import essential.Hang;
import essential.Random;

/**
 * Created by Noverish on 2016-03-28.
 */
public class LinearAlgebra {

    public String process() {
        int pivot = Random.random(0,1);

        if(pivot == 0) {
            return process001();
        } else {
            return process002();
        }
    }

    private String process001() {
        int num1 = Random.randomWithoutZero(-5, 5);
        int num2 = Random.randomWithoutZero(-10, 10);
        int ans = Random.randomWithoutZero(-5, 5);
        String op = Random.randomAmongArray(new String[]{" + ", " - "});

        String tmp = "BULLET ";

        tmp += (new Hang(num1,"x",1)) + op + (new Hang(num2)) + " = ";


        int right;

        if(op.equals(" + ")) {
            right = num1 * ans + num2;
        } else {
            right = num1 * ans - num2;
        }

        tmp += right;

        return tmp;
    }

    private String process002() {
        int num1 = Random.randomWithoutZero(-5, 5);
        int num2 = Random.randomWithoutZero(-10, 10);
        int ans = Random.randomWithoutZero(-5, 5);
        String op = Random.randomAmongArray(new String[]{" + ", " - "});

        String tmp = "BULLET ";

        tmp += (new Hang(num1)) + op + (new Hang(num2,"x",1)) + " = ";


        int right;

        if(op.equals(" + ")) {
            right = num1 + num2 * ans;
        } else {
            right = num1 - num2 * ans;
        }

        tmp += right;

        return tmp;
    }
}
