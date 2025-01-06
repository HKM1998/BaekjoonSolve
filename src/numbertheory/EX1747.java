package numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX1747 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] prime = new boolean[10000001];
		int N = Integer.parseInt(br.readLine());
		prime[1] = true;

		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (!prime[i]) {
				for (int j = i + i; j < prime.length; j += i) {
					prime[j] = true;
				}
			}
		}

		for (int i = N; i < prime.length; i++) {
			if (!prime[i]) {
				char[] ch = String.valueOf(i).toCharArray();
				int start = 0;
				int end = ch.length - 1;
				boolean isPalindrome = true;
				while (start < end) {
					if (ch[start] != ch[end]) {
						isPalindrome = false;
						break;
					}
					start++;
					end--;
				}

				if (isPalindrome) {
					System.out.println(i);
					break;
				}
			}
		}
	}

}
