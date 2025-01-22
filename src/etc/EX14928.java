package etc;

import java.util.Scanner;

public class EX14928 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder str = new StringBuilder(sc.next());
		
		long temp = 0;
		long now = 0;
		for(int i = 0; i < str.toString().length(); i+=10) {

			if(str.toString().length() - i < 10) {
				now = Long.parseLong(str.toString().substring(i, str.toString().length()));
				for(int j=0;j <= Math.log10(now);j++)
					temp *=10;
				temp += now;
				temp %= 20000303;
				break;
			}
			else {
				now = Long.parseLong(str.toString().substring(i, i + 10));
				temp *= 10000000000L + now;
				temp %= 20000303;
			}
		}
		System.out.println(temp);
	}

}
