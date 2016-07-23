import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Noverish on 2016-02-08.
 */
public class MainProgram {
    private static String ans = "";

    private static Scanner sc;

    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);

        System.out.println("하실 작업을 선택해 주세요.\n");

        System.out.println("1. 음수의 사칙연산 출력");
        System.out.println("2. 항의 사칙연산 출력");
        System.out.println("3. 연립방정식 출력");
        System.out.println("4. 곱셈나눗셈기호 생략");
        System.out.println("5. 분배법칙");
        System.out.println("6. 일차방정식");

        System.out.println("");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 : {
                case01();

                break;
            }
            case 2 : {
                case02();

                break;
            }
            case 3 : {
                SimultaneousEquations simultaneousEquations = new SimultaneousEquations();

                ans = simultaneousEquations.process();

                break;
            }
            case 4 : {
                case04();

                break;
            }
            case 5 : {
                case05();

                break;
            }
            case 6 : {
                case06();

                break;
            }
        }

        ans = ans.replace(" ", "````");

        FileWriter fw = new FileWriter("output.txt");
        fw.write(ans);
        fw.close();
    }

    private static void case01() {
        int equationNum = 1;

        NegativeNumberCalculation negativeNumberCalculation = new NegativeNumberCalculation();

        System.out.println("1. 정수");
        System.out.println("2. 유리수");
        System.out.println("3. 둘다");
        int a = sc.nextInt();

        System.out.println("예) 124인 경우 +×÷ 만 나타남");
        System.out.println("1. +    2. -    3. ×    4. ÷");
        int b = sc.nextInt();

        int c = 1, d = 1, e = 1;
        if(a == 2 || a == 3) {
            System.out.println("1. 양수만");
            System.out.println("2. 둘다");
            c = sc.nextInt();

            System.out.println("1. 분모 같음");
            System.out.println("2. 분모 다름");
            d = sc.nextInt();

            System.out.println("뺄셈의 경우");
            System.out.println("1. 앞의 수가 더 큼");
            System.out.println("2. 상관없음");
            e = sc.nextInt();
        }

        if(a == 1)
            equationNum = NegativeNumberCalculation.INTEGER_DIVIDE;
        else if(a == 2)
            equationNum = NegativeNumberCalculation.FRACTION_DIVIDE;
        else if(a == 3)
            equationNum = NegativeNumberCalculation.INTEGER_DIVIDE;

        for(int i = 1; i<=1000;i++) {
            ans += negativeNumberCalculation.process(a, b, c == 1, d == 1, e == 1);
            if(i % equationNum == 0)
                ans += " =#\n";
            else
                ans += " =##";
        }
    }

    private static void case02() {
        MultinomialExpressionCalculation multinomialExpressionCalculation = new MultinomialExpressionCalculation();

        System.out.println("0. 곰하기나누기");
        System.out.println("1. 더하기빼기");
        System.out.println("2. 둘 다");
        int a = sc.nextInt();

        System.out.println("0. 계수 없음");
        System.out.println("1. 계수 있음");
        int b = sc.nextInt();

        System.out.println("0. 문자 다름");
        System.out.println("1. 문자 같음");
        int c = sc.nextInt();


        System.out.println("더하기빼기의 경우");
        System.out.println("0. 지수 다름");
        System.out.println("1. 지수 같음");
        int d = sc.nextInt();

        ans = multinomialExpressionCalculation.process(a,b,c,d);
    }

    private static void case04() {
        MultiOmit multiOmit = new MultiOmit();

        System.out.println("1. 곱셈기호 생략");
        System.out.println("2. 곱셈기호 추가");
        int a = sc.nextInt();

        System.out.println("1. 음수 있음");
        System.out.println("2. 음수 없음");
        int b = sc.nextInt();

        System.out.println("1. 덧셈뺄셈 있음");
        System.out.println("2. 덧셈밸셈 없음");
        int c = sc.nextInt();


        for(int i = 1; i<=1000;i++) {

            if(a == 1)
                ans += multiOmit.processOmit(b == 1, c == 1);
            else
                ans += multiOmit.processInsert();

            if(i % 6 == 0)
                ans += " =#\n";
            else
                ans += " =##";
        }
    }

    private static void case05() {
        DistributionLaw distributionLaw = new DistributionLaw();

        System.out.println("1. 단항식 x 다항식");
        System.out.println("2. 다항식 x 다항식");
        int a = sc.nextInt();

        System.out.println("1. 음수있음");
        System.out.println("2. 음수없음");
        int b = sc.nextInt();

        System.out.println("1. 같은 문자");
        System.out.println("2. 다른 문자");
        int c = sc.nextInt();

        for(int i = 1; i<=1000;i++) {

            if(a == 1)
                ans += distributionLaw.processDanda(c == 1, b == 1);
            else
                ans += distributionLaw.processDaDa(c == 1, b == 1);

            if(i % 5 == 0)
                ans += " =#\n";
            else
                ans += " =##";
        }
    }

    private static void case06() {
        LinearAlgebra linearAlgebra = new LinearAlgebra();

        for(int i = 1;i<=1000;i++) {
            ans += linearAlgebra.process();

            if(i % 12 == 0)
                ans += " #\n";
            else
                ans += " ##";
        }
    }
}
