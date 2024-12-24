package search;

import java.util.Scanner;

public class EX1300 {

	public static void main(String[] args) {
		//
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		long start = 1;
		long end = K;
		long result = 0;

		while (start <= end) {
			long mid = (end + start) / 2;
			long count = 0;
			for (int i = 1; i <= N; i++) {
				count += Math.min(mid / i, N);
			}
			if (count < K)
				start = mid + 1;
			else {
				result = mid;
				end = mid - 1;
			}
		}
		System.out.println(result);
	}

}
