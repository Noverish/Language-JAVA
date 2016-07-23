import java.util.*;

public class Main07C {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int slotNum = sc.nextInt();
        int[] slot = new int[slotNum];

        for(int i = 0;i < slotNum;i++)
            slot[i] = 0;

        String fuck = sc.nextLine();

        for(int i = 0;i < testCase;i++) {
            String sen = sc.nextLine();
            int location = 0;

            for(int j = 0;j < slotNum-1;j++) {
                if(sen.charAt(j) == 'R')
                    location++;
            }

            slot[location]++;
        }

        for(int i = 0;i < slotNum;i++)
            System.out.println(slot[i]);

    }
}
