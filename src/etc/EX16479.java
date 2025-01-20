package etc;

import java.io.IOException;
import java.util.Scanner;

public class EX16479 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		double K = sc.nextDouble();

		double D1 = sc.nextDouble();
		double D2 = sc.nextDouble();

		if (D1 == D2) {
			System.out.println(K * K);
		} else {
			double num = (D1 - D2) / 2;
			System.out.println(K * K - (num * num));
		}
	}

}
