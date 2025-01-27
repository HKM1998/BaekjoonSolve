package etc;

import java.util.Scanner;

public class EX15650 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		print(0, "", 1);
		
		System.out.println(sb.toString());
	}

	static void print(int now, String tmp, int depth) {
		if(depth == m) {
			for(int i = now +1; i <= n ; i++) {
				if(depth != 1) {
					sb.append(tmp);
					sb.append(" ");
				}
				sb.append(i);
				sb.append("\n");
			}
		}else {
			for(int i = now + 1; i <=n ; i++) {
				if(depth != 1)
					print(i, tmp + " " + i, depth+1);
				else 
					print(i, "" + i, depth+1);
			}
		}
	}
}
