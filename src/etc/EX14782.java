package etc;

import java.util.Scanner;

public class EX14782 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 1 + N;
		for (int i = 2; i <= N / 2; i++) {
			if(N % i == 0) result += i;
		}
		System.out.println(result);
	}

}
