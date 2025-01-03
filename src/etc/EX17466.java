package etc;

import java.util.Scanner;

public class EX17466 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int P = sc.nextInt();
		long result = 1;
		for(int i = 2; i <= N; i++) {
			result = (result * i) % P;
		}
		System.out.println(result);
	}

}
