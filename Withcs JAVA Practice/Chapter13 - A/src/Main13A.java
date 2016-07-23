import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main13A {
    public static void main(String[] args) throws IOException{
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("input.txt"));

        int N = sc.nextInt();
        GeometricObject1[] aCircle1 = new Circle1[N];
        for (int i = 0; i < N; i++) {
            aCircle1[i] = new Circle1(sc.nextDouble(), sc.next(), sc.nextDouble());
        }
        Arrays.sort(aCircle1);
        for (GeometricObject1 c1 : aCircle1) {
            System.out.println(c1);
        }
    }
}

class GeometricObject1 {
    protected String color = "null";
    protected double weight = 0;

    public GeometricObject1() {}

    public GeometricObject1(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public static GeometricObject1 max(GeometricObject1 a, GeometricObject1 b) {
        return a;
    }
}

class Circle1 extends GeometricObject1 implements Comparable<Circle1> {
    private double radius = 0;

    public Circle1() {
        super();
    }

    public Circle1(double radius, String color, double weight) {
        super(color, weight);
        this.radius = radius;
    }

    public String toString() {
        return String.format("radius:%.1f, color:%s, weight:%.1f",radius,color,weight);
    }

    public static GeometricObject1 max(Circle1 a, Circle1 b) {
        if(a.radius > b.radius)
            return a;
        else
            return b;
    }

    @Override
    public int compareTo(Circle1 object1) {
        if(this.radius > object1.radius)
            return 1;
        else if(this.radius == object1.radius)
            return 0;
        else
            return -1;
    }
}
