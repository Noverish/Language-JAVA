import java.util.*;

public class Main09F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Fan1 fan1 = new Fan1();
        for (int i = 0; i < n; i++) {
            String op = sc.next();
            String val = sc.next();
            if (op.compareTo("speed") == 0) {
                if (val.compareTo("SLOW") == 0) fan1.setSpeed(Fan1.SLOW);
                else if (val.compareTo("FAST") == 0) fan1.setSpeed(Fan1.FAST);
                else fan1.setSpeed(Fan1.MEDIUM);
            } else if (op.compareTo("radius") == 0) {
                fan1.setRadius(Double.parseDouble(val));
            } else if (op.compareTo("color") == 0) {
                fan1.setColor(val);
            } else if (op.compareTo("on") == 0) {
                if (val.compareTo("true") == 0) fan1.setOn(true);
                else fan1.setOn(false);
            }
        }
        System.out.println(fan1.toString());

        asdf();
    }


    public void asdf() {
        System.out.println("asdf");
    }
}

class Fan1 {
    public static final int SLOW = 1, MEDIUM = 2, FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    String color;

    public Fan1() {
        speed = SLOW;
        on = false;
        radius = 5;
        color = "white";
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double r) {
        this.radius = r;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean getOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        String str = "";
        double r = Math.round(radius*100)/(double)100;

        str += String.format("speed %d\n",speed);
        str += String.format("color %s\n",color);
        str += String.format("radius %.2f\n",r);
        str += "fan is " + ((on) ? "on" : "off");
        str += "\n";

        return str;
    }
}