package etc;

import java.util.Scanner;

public class EX15727 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		
		System.out.println(L % 5 > 0 ? L / 5 + 1: L / 5);
	}

}
