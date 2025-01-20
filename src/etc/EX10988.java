package etc;

import java.util.Scanner;

public class EX10988 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] charArr = sc.next().toCharArray();
		
		int start = 0;
		int end = charArr.length - 1;
		boolean isP = true;
		
		while(start < end) {
			if(charArr[start] != charArr[end]) {
				isP = false;
				break;
			}
			start++;
			end--;
		}
		
		if(isP) System.out.println(1);
		else System.out.println(0);
	}

}
