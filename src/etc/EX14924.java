package etc;

import java.util.Scanner;

public class EX14924 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int S = sc.nextInt();
		int T = sc.nextInt();
		int D = sc.nextInt();
		
		System.out.println(D/2/S*T);
	}

}
