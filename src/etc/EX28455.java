package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class EX28455 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Integer[] A = new Integer[N];
		int totalLevel = 0;
		int totalStmt = 0;
		boolean isUp42 = N >= 42 ? true : false;
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
			totalLevel += A[i];
			if(!isUp42) {
				if(A[i]>= 250)
					totalStmt+=5;
				else if(A[i]>= 200)
					totalStmt+=4;
				else if(A[i]>= 140)
					totalStmt+=3;
				else if(A[i]>= 100)
					totalStmt+=2;
				else if(A[i]>= 60)
					totalStmt+=1;
			}
		} 
		
		if(isUp42) {
	        Arrays.sort(A,Collections.reverseOrder());
	        totalLevel = 0;
	        for(int i = 0; i < 42; i++) {
				totalLevel += A[i];
				if(A[i]>= 250)
					totalStmt+=5;
				else if(A[i]>= 200)
					totalStmt+=4;
				else if(A[i]>= 140)
					totalStmt+=3;
				else if(A[i]>= 100)
					totalStmt+=2;
				else if(A[i]>= 60)
					totalStmt+=1;
			} 
			System.out.println(totalLevel + " " + totalStmt);
		}
		else
			System.out.println(totalLevel + " " + totalStmt);
	}

}
