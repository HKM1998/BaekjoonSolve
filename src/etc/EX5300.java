package etc;

import java.util.Scanner;

public class EX5300 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		
		for(int i = 1; i <= N ; i ++) {
			sb.append(i);
			sb.append(" ");
			if(i % 6 == 0)
				sb.append("Go! ");
		}
		if(N % 6 > 0)
			sb.append("Go!");
		
		System.out.println(sb.toString());
	}

}
