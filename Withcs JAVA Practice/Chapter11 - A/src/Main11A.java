import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main11A {
    public static void main(String[] args) throws IOException{
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("input.txt"));

        ArrayList<Person> list = new ArrayList<Person>();
        int N = sc.nextInt();
        sc.nextLine();
        for (int n = 0; n < N; n++) {
            String[] items = sc.nextLine().split("\t");
            Person p = null;
            if (items[4].equals("Student")) {
                Student p1 = new Student();
                if (items[5].equals("FRESHMAN")) p1.status = Student.FRESHMAN;
                else if (items[5].equals("SOPHOMORE")) p1.status = Student.SOPHOMORE;
                else if (items[5].equals("JUNIOR")) p1.status = Student.JUNIOR;
                else if (items[5].equals("SENIOR")) p1.status = Student.SENIOR;
                p = p1;
            } else if (items[4].equals("Employee")) {
                Faculty p1 = new Faculty();
                if (items[5].equals("LECTURER")) p1.rank = Faculty.LECTURER;
                else if (items[5].equals("ASSISTANT_PROFESSOR")) p1.rank = Faculty.ASSISTANT_PROFESSOR;
                else if (items[5].equals("ASSOCIATE_PROFESSOR")) p1.rank = Faculty.ASSOCIATE_PROFESSOR;
                else if (items[5].equals("PROFESSOR")) p1.rank = Faculty.PROFESSOR;
                p = p1;
            } else if (items[4].equals("Staff")) {
                Staff p1 = new Staff();
                p1.title = items[5];
                p = p1;
            }
            p.name = items[0];
            p.address = items[1];
            p.phoneNumber = items[2];
            p.email = items[3];
            list.add(p);
        }
        for (Person p : list) System.out.println(p);
    }
}


class Person{
    public String name = null;
    public String address = null;
    public String phoneNumber = null;
    public String email = null;
}

class Student extends Person {
    public static final int FRESHMAN = 1;
    public static final int SOPHOMORE = 2;
    public static final int JUNIOR = 3;
    public static final int SENIOR = 4;

    public int status;

    public String toString() {
        return name + " is Student";
    }
}

class Employee extends Person {

}

class Staff extends Employee {
    public String title = null;

    public String toString() {
        return name + " is Staff";
    }
}

class Faculty extends Employee {
    public static final int LECTURER = 1;
    public static final int ASSISTANT_PROFESSOR = 2;
    public static final int ASSOCIATE_PROFESSOR = 3;
    public static final int PROFESSOR = 4;

    public int rank = 0;

    public String toString() {
        return name + " is Faculty";
    }
}