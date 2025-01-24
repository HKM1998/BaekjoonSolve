package etc;

import java.util.Scanner;

public class EX19945 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int count = n == 0 ? 1 : 0;
		while(n > 0) {
			n /= 2;
			count++;
		}
		
		System.out.println(n >= 0 ? count : 32);
	}

}
