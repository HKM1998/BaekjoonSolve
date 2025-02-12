package etc;

import java.util.Scanner;

public class EX15494 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int X = 1;
		int K = 1;
		
		while(true) {
			if((N - (K * 1092)) % 364 == 0) {
				X = (N - (K*1092)) / 364;
				if(X>100) {
					K++;
					continue;
				}
				break;
			}
			K++;
		}
		
		System.out.println(X + "\n" + K);
	}

}
