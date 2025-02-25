package etc;

import java.util.Scanner;

public class EX11179 {

	public static void main(String[] args) {
		myAnswer();
	}
	
	public static void myAnswer() {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 0;
		
		String binaryArr = Integer.toBinaryString(N);

		for(int i = binaryArr.length() - 1; i >= 0 ; i--) {
			result = result << 1;
			if(binaryArr.charAt(i) == '1') {
				result += 1;
			}
		}
		System.out.println(result);
	}
	
	public static void otherAnswer() {
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String binary = Integer.toBinaryString(n);
        
        StringBuilder sb = new StringBuilder();
        sb.append(binary);
        sb.reverse();
        
        String reverseBinary = sb.toString();
        System.out.println(Integer.parseInt(reverseBinary,2));
	}
}
