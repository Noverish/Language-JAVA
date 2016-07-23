import java.util.*;
public class Main1008 {
	public static char[] answer_n_2 = new char[1001];
	public static char[] answer_n_1 = new char[1001];
	public static char[] answer_n = new char[1001];

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int number;
		int i, j;

		number = sc.nextInt();

		fibonacci(number);

		for (i = 1000; i >= 0; i--) if (answer_n[i] != 0) break;

		for (; i >= 0; i--) System.out.printf("%c", answer_n[i] + '0');
	}

	public static int fibonacci(int n) {

		int fibo_number = 3;
		int i, j;

		answer_n_2[0] = answer_n_1[0] = 1;

		for (; ; fibo_number++) {
			for (i = 0; i < 1001; i++) answer_n[i] = 0;
			for (i = 0; i < 1001; i++) {
				answer_n[i] += answer_n_1[i] + answer_n_2[i];

				if (answer_n[i] >= 10) {
					answer_n[i + 1]++;
					answer_n[i] -= 10;
				}
			}

			if (fibo_number == n) return 0;

			for (i = 0; i < 1001; i++) answer_n_2[i] = answer_n_1[i];
			for (i = 0; i < 1001; i++) answer_n_1[i] = answer_n[i];

			int a;
		}

	}
}