package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX18238 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		
		char nowChar = 'A';
		int result = 0;
		
		for(int i = 0; i < arr.length; i++) {
			int tmpA = arr[i] - nowChar; // 단순 거리
			int tmpB = Math.abs(arr[i] - nowChar) - 26; // 'A' -> 'Z' / 'Z' -> 'A'
			
			result += Math.min(Math.abs(tmpA), Math.abs(tmpB));
			
			nowChar = arr[i];
		}
		System.out.println(result);
	}

}
