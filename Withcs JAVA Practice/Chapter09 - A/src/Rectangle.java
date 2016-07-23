public class Rectangle {
    public double width;
    public double height;

    public Rectangle() { }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return Math.round(width*height*100)/100;
    }

    public double getPerimeter() {
        return 2*(width + height);
    }
}
