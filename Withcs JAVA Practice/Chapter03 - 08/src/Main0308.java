import java.util.*;

public class Main0308{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);

        double x1=s.nextDouble();
        double y1=s.nextDouble();
        double w1=s.nextDouble();
        double h1=s.nextDouble();
        double x2=s.nextDouble();
        double y2=s.nextDouble();
        double w2=s.nextDouble();
        double h2=s.nextDouble();

        double square1Left,square1Down,square1Right,square1Up;
        double square2Left,square2Down,square2Right,square2Up;

        square1Left=x1-w1/2;
        square1Down=y1-h1/2;
        square1Right=x1+w1/2;
        square1Up=y1+h1/2;
        square2Left=x2-w2/2;
        square2Down=y2-h2/2;
        square2Right=x2+w2/2;
        square2Up=y2+h2/2;

        if(square1Down<=square2Down && square2Right<=square1Right && square2Up<=square1Up && square1Left<=square2Left)
            System.out.printf("inside\n");
        else {

            if(square1Down>square2Down)
            {
                double tmp=square1Left;
                square1Left=square2Left;
                square2Left=tmp;

                tmp=square1Down;
                square1Down=square2Down;
                square2Down=tmp;

                tmp=square1Right;
                square1Right=square2Right;
                square2Right=tmp;

                tmp=square1Up;
                square1Up=square2Up;
                square2Up=tmp;
            }

            if(square1Right==square2Left && square1Up>square2Down)
                System.out.printf("attach\n");
            else if(square1Left==square2Right && square1Up>square2Down)
                System.out.printf("attach\n");
            else if(square1Up==square2Down && !(square2Right<=square1Left || square2Left>=square1Right))
                System.out.printf("attach\n");
            else
                System.out.printf("outside\n");
        }
    }
}