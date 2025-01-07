package numbertheory;

import java.util.Scanner;

public class EX23832 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		
		for(int i = 2; i <= N; i++) {
			arr[i] = i;
		}
		for(int i = 2; i <= N ; i++) {
			if(arr[i] % i == 0) {
				arr[i] -= arr[i]/i; 
				for(int j = i+i; j<=N;j+=i) {
					arr[j] -= arr[j]/i; 
				}
			}
		}
		int result = 0;
		for(int i = 2; i <= N; i++) {
			result += arr[i];
		}
		System.out.println(result);
	}

}
