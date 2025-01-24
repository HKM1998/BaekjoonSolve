package etc;

import java.util.Scanner;

public class EX24265 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long result =0;
		// 결과 값은 1부터 (n-1) 까지 합
		for(int i = 1; i < n; i++) {
			result += i;
		}
		
		System.out.println(result + "\n2");
	}

}
