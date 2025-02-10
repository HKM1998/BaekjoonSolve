package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX24839 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T ; i++) {
			char[] destArr = br.readLine().toCharArray();
			char[] inputArr = br.readLine().toCharArray();
			int count = 0;
			int dIdx = 0, iIdx = 0;
			boolean isPossible = true;
			while(dIdx < destArr.length) {
				if(iIdx >= inputArr.length) {
					isPossible = false;
					break;
				}
				if(destArr[dIdx] == inputArr[iIdx]) {
					dIdx++;
					iIdx++;
				} else {
					iIdx++;
					count++;
				}
			}
			if(isPossible) {
				if(iIdx < inputArr.length)
					count += inputArr.length - iIdx;
				System.out.println("Case #" + (i+1) + ": " + count);
			}
			else
				System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
		}
	}

}
