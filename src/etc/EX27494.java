package etc;

import java.util.Scanner;

public class EX27494 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		int[] num = {2,0,2,3};
		
		if(N >= 2023) {
			count++;
			for(int i = 12023; i <= N;i++) {
				int k = 0;
				int tmp = i;
				for(int j = (int)Math.log10(i); j >= 0 ;j--) {
					if(k == 4) break;
					int t = (int)(Math.pow(10, j));
					if(tmp/t == num[k])
						k++;
					tmp %= t;
				}
				if (k == 4) count++;
			}
		}
		
		System.out.println(count);
	}

}
