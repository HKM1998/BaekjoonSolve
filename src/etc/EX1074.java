package etc;

import java.util.Scanner;

public class EX1074 {
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		// 2^N * 2^N 행렬
		System.out.println(searchIdx(N,r,c));
	}
	
	static int searchIdx(int N, int r, int c) {
		int count = 0;
		int num = (int)Math.pow(2, N - 1);
		if(N == 1) {
			return  c + r * 2 ;
		}
		else {
			if(r>=num) {
				r = r - num;
				count += num * num * 2;
			}
			if(c>=num) {
				c = c - num;
				count += num * num;
			}
			
			return count + searchIdx(N-1, r, c);
		}
		
			
	}
}
