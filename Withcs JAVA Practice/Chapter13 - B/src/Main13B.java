import java.util.Scanner;

public class Main13B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        GeometricObject[] aObject = new GeometricObject[N];
        for (int i = 0; i < N; i++) {
            String shape = sc.next();
            if (shape.equals("Square")) {
                aObject[i] = new Square(sc.nextDouble());
            } else if (shape.equals("Rectangle")) {
                aObject[i] = new Rectangle(sc.nextDouble(), sc.nextDouble());
            }
        }
        for (int i = 0; i < aObject.length; i++) {
            if (aObject[i] instanceof Colorable)
                ((Colorable) aObject[i]).howToColor();
            System.out.println("area: " + aObject[i].getArea());
            System.out.println("perimeter: " + aObject[i].getPerimeter());
        }
    }
}

interface Colorable{
    void howToColor();
}

class GeometricObject implements Colorable{

    public void howToColor() {
        System.out.println("howToColor: xxx");
    }

    public double getArea() {
        return 0;
    }

    public double getPerimeter() {
        return 0;
    }
}

class Square extends GeometricObject{
    private double line = 0;

    public Square() {}

    public void howToColor() {
        System.out.println("Square");
        System.out.println("howToColor: xxx");
    }

    public Square(double line) {
        this.line = line;
    }

    public double getArea() {
        return line*line;
    }

    public double getPerimeter() {
        return 4*line;
    }
}

class Rectangle extends GeometricObject{
    private double line1, line2;

    public Rectangle() {}

    public void howToColor() {
        System.out.println("Rectangle");
        System.out.println("howToColor: xxx");
    }

    public Rectangle(double a, double b) {
        this.line1 = a;
        this.line2 = b;
    }

    public double getArea() {
        return line1*line2;
    }

    public double getPerimeter() {
        return 2*(line1+line2);
    }
}