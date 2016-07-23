import java.util.*;
import java.io.*;

public class Main10D {
    public static void main(String[] args) throws IOException{
        Queue queue = new Queue();
        Scanner sc = new Scanner(new File("input.txt"));

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            if (n == -1) {
                if (!queue.empty()) queue.dequeue();
            } else {
                queue.enqueue(n);
            }
        }
        while (!queue.empty())
            System.out.println(queue.dequeue());

    }
}

class Queue {

    int[] num = new int[2000];
    int front = 0;
    int end = 0;

    public void enqueue(int v) {
        num[end++] = v;
    }

    public int dequeue() {
        int a = num[front];
        num[front] = 0;
        front++;
        return a;
    }

    public boolean empty() {
        if(end-front == 0)
            return true;
        else
            return false;
    }

    public int getSize() {
        return end-front;
    }

}
