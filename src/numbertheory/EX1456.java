package numbertheory;

import java.util.Scanner;

public class EX1456 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		
		boolean[] prime = new boolean[(int)Math.sqrt(B)+1];
		prime[1] = true;
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(!prime[i]) {
				for(int j = i+i; j <= prime.length; j+= i) {
					prime[j]= true;
				}
			}
		}
		int count = 0;
		for(int i = 2; i <= Math.sqrt(B); i++) {
			if(!prime[i]) {
				long temp = i;
				while((double)i <= (double)B/(double)temp){
					if((double)i >= (double)A/(double)temp) {
						count ++;
					}
					temp *= i;
				}
			}
		}
		System.out.println(count);
	}

}
