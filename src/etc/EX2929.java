package etc;

import java.util.Scanner;

public class EX2929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] mCode = sc.next().toCharArray();
		int point = 0;
		int smallCount= 0;
		int nopCount = 0;
		
		for (int i = 0; i < mCode.length ; i++) {
			int charInt = (int)mCode[i] - (int)'A';
			// 대문자 알파벳인 경우 중 마지막 대문자 위치만 결정하면 됨
			if(charInt >= 0 && charInt < 26) {
				// 명령 수가 4가 넘는 경우 대문자 위치 +4
				if(smallCount >= 4) {
					point += 4 * (smallCount/4);
				}
				nopCount = point - i;
				point += 4;
				smallCount= 0;
			}
			else smallCount++;
		}
		
		System.out.println(nopCount);
	}

}
