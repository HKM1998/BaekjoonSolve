package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EX1427 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int[] numArray = new int[str.length()];
		for(int i = 0; i < str.length(); i++) {
			numArray[i] = Integer.parseInt(str.substring(i, i+1));
		}
		
		for(int i = 0; i < str.length(); i++) {
			int maxindex = i;
			for(int j = i; j < str.length(); j++ ) {
				if(numArray[j] > numArray[maxindex])
					maxindex = j;
			}
			int temp = numArray[i];
			numArray[i] = numArray[maxindex];
			numArray[maxindex] = temp;
		}
		
		for(int i : numArray)
			System.out.print(i);
		System.out.println();
	}

}
