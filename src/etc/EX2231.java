package etc;

import java.util.Scanner;

public class EX2231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int log10 = (int)(Math.log10(N)+1);
		int result = 0;
		
		for(int i = N - (log10 * 9); i < N ; i++) {
			int num = i;
			int sum = i;
			while(num > 0) {
				sum += num % 10;
				num /= 10;
			}
			if(sum == N) {
				result = i;
				break;
			}
				
		}
		if(result > 0)
			System.out.println(result);
		else 
			System.out.println(0);
		
	}

}
