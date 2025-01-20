package etc;

import java.util.Scanner;

public class EX24389 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int re = ~N + 1;

		String str1 = Integer.toBinaryString(N);
		String str2 = Integer.toBinaryString(re);
		int count =0;
		while(str1.length() < 32)
			str1 = "0" + str1;
		for (int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i))
				count++;
		}
		System.out.println(count);
	}

}
