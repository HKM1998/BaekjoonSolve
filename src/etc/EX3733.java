package etc;

import java.io.IOException;
import java.util.Scanner;

public class EX3733 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLong()) {
			long n = sc.nextLong();
			long s = sc.nextLong();
			
			System.out.println(s/(n+1));
		}
	}

}
