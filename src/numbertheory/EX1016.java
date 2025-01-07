package numbertheory;

import java.util.Scanner;

public class EX1016 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();

		boolean[] nPow = new boolean[(int) (max - min + 1)];

		for (long i = 2; i * i <= max; i++) {
			long pow = i * i;
			long startIndex = min / pow;
			if (min % pow != 0) {
				startIndex++;
			}
			for (long j = startIndex; j * pow <= max; j++) {
				nPow[(int) ((j * pow) - min)] = true;
			}
		}
		int count = 0;
		for (int i = 0; i <= max - min; i++) {
			if (!nPow[i])
				count++;
		}
		System.out.println(count);
	}

}
