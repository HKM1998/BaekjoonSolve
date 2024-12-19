package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EX14471 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int result = 0;
		int[] intArr = new int[m];
		
		for(int i = 0; i < m ; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			intArr[i] = n - a;
			result += intArr[i]>=0? intArr[i] : 0;
		}
		Arrays.sort(intArr);
		result -= intArr[intArr.length - 1];
		
		System.out.println(result);
	}

}
